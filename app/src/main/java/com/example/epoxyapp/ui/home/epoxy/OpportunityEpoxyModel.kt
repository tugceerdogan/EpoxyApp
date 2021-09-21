package com.example.epoxyapp.ui.home.epoxy

import android.view.View
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyHolder
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.bumptech.glide.Glide
import com.example.epoxyapp.R
import com.example.epoxyapp.databinding.ItemOpportunityBinding

@EpoxyModelClass(layout = R.layout.item_opportunity)
abstract class OpportunityEpoxyModel : EpoxyModelWithHolder<OpportunityEpoxyModel.OpportunityHolder>() {


    @field:EpoxyAttribute
    open var name: CharSequence? = null

    @field:EpoxyAttribute
    open var price: CharSequence? = null

    @field:EpoxyAttribute
    open var imageUrl: String? = null


    override fun bind(holder: OpportunityHolder) {
        holder.binding.apply {
            productNameTextView.text = name
            productPriceTextView.text = price
            Glide.with(productImageView)
                .load(imageUrl)
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
