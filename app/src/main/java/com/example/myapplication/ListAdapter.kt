package com.example.myapplication

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.myapplication.databinding.ListitemBinding

class ListAdapter(list: List<Result>) : RecyclerView.Adapter<MyViewHolder>() {
     val mlist = list
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = ListitemBinding.inflate(LayoutInflater.from(parent.context))

        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return mlist.count()
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        Glide.with(holder.itemView.context).load(mlist.get(position).url).into(holder.mBinding.ivUserImg)
        holder.mBinding.tvAbstract.setText(mlist.get(position).abstract_)
        holder.mBinding.tvItemDesc.setText(mlist.get(position).title)
        holder.mBinding.tvPublishedDate.setText(mlist.get(position).published_date)
    }
}

class MyViewHolder(binding: ListitemBinding) : RecyclerView.ViewHolder(binding.root) {
    val mBinding = binding
}
