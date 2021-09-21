package com.example.epoxyapp.data.entity.opportunities

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Opportunities(
    @SerialName("id")
    val id: String,
    @SerialName("imageUrl")
    val imageUrl: String,
    @SerialName("name")
    val name: String,
    @SerialName("price")
    val price: String
)