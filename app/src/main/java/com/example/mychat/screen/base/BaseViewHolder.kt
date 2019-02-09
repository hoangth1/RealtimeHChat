package com.example.mychat.screen.base

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

 class ViewHolder<ItemDataBinding:ViewDataBinding>(
  val itemBinding:ItemDataBinding) :RecyclerView.ViewHolder(itemBinding.root)
