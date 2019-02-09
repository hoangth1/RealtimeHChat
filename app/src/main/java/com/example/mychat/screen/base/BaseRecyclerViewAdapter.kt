package com.example.mychat.screen.base

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.AsyncDifferConfig
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import java.util.concurrent.Executors

abstract class BaseRecyclerViewAdapter<Item, ItemDatabinding : ViewDataBinding>(
    callback: DiffUtil.ItemCallback<Item>
) : ListAdapter<Item, ViewHolder<ItemDatabinding>>(
    AsyncDifferConfig.Builder<Item>(callback)
        .setBackgroundThreadExecutor(Executors.newSingleThreadExecutor())
        .build()
) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder<ItemDatabinding> {
        return ViewHolder(
            DataBindingUtil.inflate<ItemDatabinding>(
                LayoutInflater.from(parent.context),
                getItemRes(), parent, false
            ).apply {
                root.setOnClickListener {
                    onClickItem(this)
                }
                bindFirstTime(this)
            }
        )
    }

    private fun onClickItem(itemDatabinding: ItemDatabinding) {

    }

    fun bindFirstTime(itemBinding: ItemDatabinding) {

    }

    override fun onBindViewHolder(holder: ViewHolder<ItemDatabinding>, position: Int) {
        bindView(holder.itemBinding, getItem(position))
    }

    fun bindView(itemBinding: ItemDatabinding, item: Item) {
        itemBinding.setVariable(getItemVar(), item)
    }

    abstract fun getItemVar(): Int

    abstract fun getItemRes(): Int
}
