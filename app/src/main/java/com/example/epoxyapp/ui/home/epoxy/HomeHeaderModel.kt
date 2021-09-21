package com.example.epoxyapp.ui.home.epoxy

import android.view.View
import android.view.ViewParent
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyHolder
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.example.epoxyapp.R
import com.example.epoxyapp.databinding.ItemHeaderBinding

@EpoxyModelClass()
abstract class HomeHeaderModel : EpoxyModelWithHolder<HomeHeaderModel.HeaderHolder>() {

    @field:EpoxyAttribute
    open var value: CharSequence? = null

    override fun bind(holder: HeaderHolder) {
        holder.binding.headerTextView.text = value
    }

    class HeaderHolder : EpoxyHolder() {
        lateinit var binding: ItemHeaderBinding
            private set

        override fun bindView(itemView: View) {
            binding = ItemHeaderBinding.bind(itemView)
        }
    }
}