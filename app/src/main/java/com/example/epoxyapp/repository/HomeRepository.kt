package com.example.epoxyapp.repository

import com.example.epoxyapp.data.remote.RemoteHomeDataSource
import com.example.epoxyapp.util.performNetworkOperation
import javax.inject.Inject

class HomeRepository @Inject constructor(
    private var remoteDataSource: RemoteHomeDataSource,
){

    fun getOpportunityList() = performNetworkOperation {
        remoteDataSource.fetchOpportunities()
    }

    fun getCategoryList() = performNetworkOperation {
        remoteDataSource.fetchCategories()
    }
}