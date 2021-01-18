package com.cesar.hiberustest.presentation.home_activity.fragments.data_fragment.adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cesar.hiberustest.R
import com.cesar.hiberustest.databinding.MenuItemsBinding
import com.cesar.hiberustest.domain.entity.MyData
import com.cesar.hiberustest.utils.Consts
import com.cesar.hiberustest.utils.inflate
import kotlin.properties.Delegates

class DataAdapter (listItems: List<MyData> = emptyList(), private val listener: OnItemClickListener) : RecyclerView.Adapter<DataAdapter.ViewHolder>(){

    var listItems: List<MyData> by Delegates.observable(listItems){ _, _, _ ->
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(
            parent.inflate(
                R.layout.menu_items
            ), listener
        )


    override fun getItemCount(): Int {
        return listItems.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listItems[position])
    }

    interface OnItemClickListener {
        fun onClickItem(item: MyData, TAG: String)
    }

    class ViewHolder(private val view: View, private val listener: OnItemClickListener) : RecyclerView.ViewHolder(view){

        private val binding = MenuItemsBinding.bind(view)

        fun bind (item: MyData){
            with(binding){
                tvName.text= item.firstName.plus(" ").plus(item.lastName)
                tvType.text= item.email

                itemView.setOnClickListener{
                  listener.onClickItem(item, Consts.Adapters.ALL)
                }
            }
        }
    }
}