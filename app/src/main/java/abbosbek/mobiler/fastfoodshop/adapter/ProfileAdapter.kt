package abbosbek.mobiler.fastfoodshop.adapter

import abbosbek.mobiler.fastfoodshop.databinding.ProfileItemBinding
import abbosbek.mobiler.fastfoodshop.databinding.ProfileItemLayoutBinding
import abbosbek.mobiler.fastfoodshop.models.ProfileItemModel
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class ProfileAdapter(val items : List<ProfileItemModel>) : RecyclerView.Adapter<ProfileAdapter.ItemHolder>() {

    inner class ItemHolder(val binding : ProfileItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        return ItemHolder(
            ProfileItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,false
            )
        )
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        val item = items[position]

        holder.binding.tvTitle.text = item.title
        item.icon?.let { holder.binding.imgIcon.setImageResource(it) }
    }

    override fun getItemCount(): Int {
        return items.size
    }

}