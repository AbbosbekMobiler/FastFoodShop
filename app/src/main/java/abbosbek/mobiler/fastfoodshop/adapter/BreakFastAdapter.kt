package abbosbek.mobiler.fastfoodshop.adapter

import abbosbek.mobiler.fastfoodshop.databinding.BreakfastItemBinding
import abbosbek.mobiler.fastfoodshop.databinding.TopItemBinding
import abbosbek.mobiler.fastfoodshop.models.Category
import abbosbek.mobiler.fastfoodshop.models.TopModel
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class BreakFastAdapter(val items : List<TopModel>) : RecyclerView.Adapter<BreakFastAdapter.ItemHolder>() {
    inner class ItemHolder(val binding : BreakfastItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        return ItemHolder(
            BreakfastItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,false
            )
        )
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {

        val item = items[position]

        holder.binding.tvBreakFastName.text = item.strMeal
        Glide.with(holder.itemView)
            .load(item.strMealThumb)
            .into(holder.binding.imgBreakFast)

    }

    override fun getItemCount(): Int {
        return items.size
    }
}