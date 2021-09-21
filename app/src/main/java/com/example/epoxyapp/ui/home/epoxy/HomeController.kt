package com.example.epoxyapp.ui.home.epoxy

import com.airbnb.epoxy.AsyncEpoxyController
import com.airbnb.epoxy.Typed2EpoxyController
import com.airbnb.epoxy.TypedEpoxyController
import com.example.epoxyapp.data.entity.categories.Categories
import com.example.epoxyapp.data.entity.opportunities.Opportunities

class HomeController : Typed2EpoxyController<List<Opportunities>, List<Categories>>(){

    var opportunities: List<Opportunities> = emptyList()
        set(value) {
            field = value
            requestModelBuild()
        }

    override fun buildModels(opportunity: List<Opportunities>, category: List<Categories>) {

        /*HeaderModel().also{
            it.id("categories")
            it.value
            ("Categories")
        }

        headerModel{
            id("recently_active")
            value("Recently Active")
        }

        opportunity.forEach {
            opportunityItem {
                id(it.id)
                opportunity(it)
            }
        }

    } */
}

}



