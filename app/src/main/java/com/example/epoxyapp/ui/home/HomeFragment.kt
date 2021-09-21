package com.example.epoxyapp.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.epoxyapp.databinding.FragmentHomeBinding
import com.example.epoxyapp.ui.home.epoxy.HomeController
import com.example.epoxyapp.util.Resource
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private lateinit var _binding: FragmentHomeBinding
    private val epoxyViewModel: HomeEpoxyViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return _binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val controller = HomeController()
        _binding.categoryView.setControllerAndBuildModels(controller)

        epoxyViewModel.fetchOpportunityList().observe(viewLifecycleOwner, {
            //it.status bizim için bir state
            when (it.status) {
                //Bu 3 farklı state de artık ui'ı yönetebilir hale geldik
                Resource.Status.LOADING -> {
                }
                Resource.Status.SUCCESS -> {
                }
                Resource.Status.ERROR -> {
                }
            }
        })

    }

    companion object {
        @JvmStatic
        fun newInstance(): HomeFragment {
            return HomeFragment()
        }
    }
}




