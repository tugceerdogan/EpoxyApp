package com.example.epoxyapp.data.remote

import com.example.epoxyapp.network.service.HomeService
import com.example.epoxyapp.util.BaseDataSource
import javax.inject.Inject

class RemoteHomeDataSource @Inject constructor(private val apiService: HomeService) :
    BaseDataSource(){

    suspend fun fetchOpportunities() = getResult { apiService.getOpportunities() }

    suspend fun fetchCategories() = getResult { apiService.getCategories() }

}