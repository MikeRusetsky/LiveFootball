package com.mikerusetsky.livefootball.ui.Home

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

    companion object {
        fun newInstance() = HomeFragment()
    }
}