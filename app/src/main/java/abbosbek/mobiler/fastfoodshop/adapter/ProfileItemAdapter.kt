package abbosbek.mobiler.fastfoodshop.adapter

import abbosbek.mobiler.fastfoodshop.databinding.ProfileItemLayoutBinding
import abbosbek.mobiler.fastfoodshop.models.ProfileItemModel
import abbosbek.mobiler.fastfoodshop.models.ProfileModel
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ItemDecoration
import androidx.recyclerview.widget.SnapHelper

class ProfileItemAdapter(val items : List<ProfileModel>) : RecyclerView.Adapter<ProfileItemAdapter.ItemHolder>() {

    inner class ItemHolder(val binding : ProfileItemLayoutBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        return ItemHolder(
            ProfileItemLayoutBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,false
            )
        )
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        val item = items[position]

        holder.binding.tvTitle.text = item.title
        holder.binding.recyclerProfileItem.adapter = ProfileAdapter(item.itemList)
        val itemDecoration = DividerItemDecoration(holder.itemView.context,RecyclerView.VERTICAL)
        holder.binding.recyclerProfileItem.addItemDecoration(itemDecoration)


    }

    override fun getItemCount(): Int {
        return items.size
    }

}