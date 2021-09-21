package com.example.epoxyapp.ui.home.epoxy

import android.view.View
import android.widget.ImageView
import androidx.appcompat.widget.AppCompatTextView
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyHolder
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.example.epoxyapp.R
import com.example.epoxyapp.data.entity.categories.Categories
import com.example.epoxyapp.databinding.ItemHeaderBinding

@EpoxyModelClass(layout = R.layout.item_category)
abstract class HomeCategoryModel : EpoxyModelWithHolder<HomeCategoryModel.Holder>() {

    @EpoxyAttribute
    lateinit var category: Categories

    override fun bind(holder: Holder) {
        super.bind(holder)
        with(category) {
            //holder.categoryImage = imageUrl
            holder.binding.headerTextView.text = name
        }
    }

    class Holder : EpoxyHolder() {

        lateinit var binding: ItemHeaderBinding
            private set

        override fun bindView(itemView: View) {
            binding = ItemHeaderBinding.bind(itemView)
        }
    }
}