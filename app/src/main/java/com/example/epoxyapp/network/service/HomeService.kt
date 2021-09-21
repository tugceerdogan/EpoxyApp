package com.example.epoxyapp.network.service

import com.example.epoxyapp.data.entity.categories.Categories
import com.example.epoxyapp.data.entity.opportunities.Opportunities
import retrofit2.Response
import retrofit2.http.GET

interface HomeService {

    @GET("opportunities")
    suspend fun getOpportunities(): Response<ArrayList<Opportunities>>

    @GET("categories")
    suspend fun getCategories(): Response<ArrayList<Categories>>
}