package abbosbek.mobiler.fastfoodshop.adapter

import abbosbek.mobiler.fastfoodshop.databinding.BreakfastItemBinding
import abbosbek.mobiler.fastfoodshop.databinding.CouponsItemBinding
import abbosbek.mobiler.fastfoodshop.databinding.TopItemBinding
import abbosbek.mobiler.fastfoodshop.models.Category
import abbosbek.mobiler.fastfoodshop.models.CouponsModel
import abbosbek.mobiler.fastfoodshop.models.TopModel
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class CouponsAdapter(val items : List<CouponsModel>) : RecyclerView.Adapter<CouponsAdapter.ItemHolder>() {
    inner class ItemHolder(val binding : CouponsItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        return ItemHolder(
            CouponsItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,false
            )
        )
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {

        val item = items[position]

        Glide.with(holder.itemView)
            .load(item.img_url)
            .into(holder.binding.imgBreakFast)

    }

    override fun getItemCount(): Int {
        return items.size
    }
}