package com.example.epoxyapp.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.epoxyapp.databinding.FragmentHomeBinding
import com.example.epoxyapp.ui.home.epoxy.HomeEpoxyController
import com.example.epoxyapp.util.Resource
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private lateinit var _binding: FragmentHomeBinding
    private val viewModel: HomeEpoxyViewModel by viewModels()
    private lateinit var homeEpoxyController: HomeEpoxyController


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return _binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.fetchOpportunityList().observe(viewLifecycleOwner, {

            when (it.status) {
                Resource.Status.LOADING -> {
                }
                Resource.Status.SUCCESS -> {

                    initEpoxyController()

                }
                Resource.Status.ERROR -> {
                }
            }
        })

    }
    private fun initEpoxyController() {
        homeEpoxyController = HomeEpoxyController()
        _binding.categoryView.setController(homeEpoxyController)
        }

    companion object {
        @JvmStatic
        fun newInstance(): HomeFragment {
            return HomeFragment()
        }
    }
}




