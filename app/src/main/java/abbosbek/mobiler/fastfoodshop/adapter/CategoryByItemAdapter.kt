package abbosbek.mobiler.fastfoodshop.adapter

import abbosbek.mobiler.fastfoodshop.databinding.CategoryByItemLayoutBinding
import abbosbek.mobiler.fastfoodshop.databinding.CategoryItemBinding
import abbosbek.mobiler.fastfoodshop.databinding.TopItemBinding
import abbosbek.mobiler.fastfoodshop.models.Category
import abbosbek.mobiler.fastfoodshop.models.TopModel
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class CategoryByItemAdapter(val items : List<TopModel>) : RecyclerView.Adapter<CategoryByItemAdapter.ItemHolder>() {
    inner class ItemHolder(val binding : CategoryByItemLayoutBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        return ItemHolder(
            CategoryByItemLayoutBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,false
            )
        )
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {

        val item = items[position]

        holder.binding.tvFoodName.text = item.strMeal
        Glide.with(holder.itemView)
            .load(item.strMealThumb)
            .into(holder.binding.imgFood)

    }

    override fun getItemCount(): Int {
        return items.size
    }
}