package com.example.epoxyapp.ui.home.epoxy

import android.view.View
import android.view.ViewParent
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyHolder
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.bumptech.glide.Glide
import com.example.epoxyapp.R
import com.example.epoxyapp.data.entity.opportunities.Opportunities
import com.example.epoxyapp.databinding.ItemOpportunityBinding

@EpoxyModelClass()
abstract class HomeOpportunityModel : EpoxyModelWithHolder<HomeOpportunityModel.OpportunityHolder>() {

    @EpoxyAttribute
    lateinit var opportunity: Opportunities

    override fun bind(holder: OpportunityHolder) {
        holder.binding.apply {
            productNameTextView.text = opportunity.name
            productPriceTextView.text = opportunity.price
            Glide.with(productImageView)
                .load(opportunity.imageUrl)
                .placeholder(R.drawable.ic_launcher_background)
                .fitCenter().centerCrop()
                .into(productImageView)
            root.setOnClickListener { }
        }
    }

    class OpportunityHolder : EpoxyHolder() {

        lateinit var binding: ItemOpportunityBinding
            private set

        override fun bindView(itemView: View) {
            binding = ItemOpportunityBinding.bind(itemView)
        }
    }
}
