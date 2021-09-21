package com.example.epoxyapp.ui.home.epoxy

import com.airbnb.epoxy.Typed2EpoxyController
import com.example.epoxyapp.data.entity.categories.Categories
import com.example.epoxyapp.data.entity.opportunities.Opportunities

class HomeEpoxyController : Typed2EpoxyController<List<Opportunities>, List<Categories>>(){

    override fun buildModels(opportunitiesList: List<Opportunities>, categoriesList: List<Categories>) {

        header{
            id("categories")
            value("Categories")

        }
        opportunitiesList.forEach() {
            opportunity {
                id(it.id)
                name(it.name)
                price(it.price)

            }
        }

        categoriesList.forEach() {
            category {
                id(it.id)
                name(it.name)
            }
        }
}
}


