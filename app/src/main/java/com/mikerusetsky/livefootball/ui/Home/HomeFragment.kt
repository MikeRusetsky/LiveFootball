package com.mikerusetsky.livefootball.ui.Home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.memorycards.Base.Factory
import com.mikerusetsky.livefootball.App
import com.mikerusetsky.livefootball.R
import com.mikerusetsky.livefootball.databinding.FragmentHomeBinding

class HomeFragment : Fragment(R.layout.fragment_home) {

    private val binding by viewBinding(FragmentHomeBinding::bind)
    private val viewModel by viewModels<HomeViewModel> {
        Factory {
            App.appComponent
                .getHomeComponent()
                .viewModel()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.text.setOnClickListener {
            viewModel.getMatches()
        }
    }

    companion object {
        fun newInstance() = HomeFragment()
    }
}