package com.example.epoxyapp.ui.home.epoxy

import android.view.View
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyHolder
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.bumptech.glide.Glide
import com.example.epoxyapp.R
import com.example.epoxyapp.databinding.ItemCategoryBinding

@EpoxyModelClass(layout = R.layout.item_category)
abstract class CategoryEpoxyModel : EpoxyModelWithHolder<CategoryEpoxyModel.CategoryHolder>() {

    @field:EpoxyAttribute
    open var name: CharSequence? = null

    @field:EpoxyAttribute
    open var imageUrl: String? = null

    override fun bind(categoryHolder: CategoryHolder) {
        categoryHolder.binding.apply {
            categoryNameTextView.text = name
            Glide.with(categoryImageView)
                .load(imageUrl)
                .placeholder(R.drawable.ic_launcher_background)
                .fitCenter().centerCrop()
                .into(categoryImageView)
            root.setOnClickListener { }
        }
        }

    class CategoryHolder : EpoxyHolder() {

        lateinit var binding: ItemCategoryBinding
            private set

        override fun bindView(itemView: View) {
            binding = ItemCategoryBinding.bind(itemView)
        }
    }
}