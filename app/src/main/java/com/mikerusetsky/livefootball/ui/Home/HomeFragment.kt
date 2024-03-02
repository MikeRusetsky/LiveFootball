package com.mikerusetsky.livefootball.ui.Home

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.memorycards.Base.Factory
import com.mikerusetsky.livefootball.App
import com.mikerusetsky.livefootball.R
import com.mikerusetsky.livefootball.databinding.FragmentHomeBinding
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Locale

class HomeFragment : Fragment(R.layout.fragment_home) {

    private val binding by viewBinding(FragmentHomeBinding::bind)
    private val viewModel by viewModels<HomeViewModel> {
        Factory {
            App.appComponent
                .getHomeComponent()
                .viewModel()
        }
    }
    private lateinit var adapter: MatchAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupMatches()
        binding.share.setOnClickListener { share() }

        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.observeUi().collect { state ->
                    adapter.submitList(state.items)
                }
            }
        }
    }

    private fun setupMatches() {
        adapter = MatchAdapter()
        binding.matches.adapter = adapter
        binding.matches.layoutManager = LinearLayoutManager(requireContext())
    }

    private fun share() {
        val stringBuilder = StringBuilder()
        stringBuilder.append("Today matches: \n")

        viewModel.observeUi().value.items.forEach {
            val leftTeam = it.teams[0]
            val rightTeam = it.teams[1]
            val time = SimpleDateFormat("mm:HH", Locale.getDefault()).format(it.startingAt)

            stringBuilder.append("${leftTeam.name} ${time} ${rightTeam.name} \n")
        }

        val intent = Intent(Intent.ACTION_SEND)
        intent.putExtra(Intent.EXTRA_TEXT, stringBuilder.toString())
        intent.type = "text/plain"

        val shareIntent = Intent.createChooser(intent, null)
        startActivity(shareIntent)
    }

    companion object {
        fun newInstance() = HomeFragment()
    }
}