package com.example.epoxyapp.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.epoxyapp.data.entity.categories.Categories
import com.example.epoxyapp.data.entity.opportunities.Opportunities
import com.example.epoxyapp.repository.HomeRepository
import com.example.epoxyapp.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import java.util.ArrayList
import javax.inject.Inject

@HiltViewModel
class HomeEpoxyViewModel @Inject constructor(

    val savedStateHandle: SavedStateHandle,
    val homeRepository: HomeRepository
) : ViewModel() {

    fun fetchOpportunityList(): LiveData<Resource<ArrayList<Opportunities>>> =
        homeRepository.getOpportunityList()

    fun fetchCategoryList(): LiveData<Resource<ArrayList<Categories>>> =
        homeRepository.getCategoryList()
}