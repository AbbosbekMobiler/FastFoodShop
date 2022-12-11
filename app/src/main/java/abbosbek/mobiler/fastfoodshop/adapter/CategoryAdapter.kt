package abbosbek.mobiler.fastfoodshop.adapter

import abbosbek.mobiler.fastfoodshop.databinding.CategoryItemBinding
import abbosbek.mobiler.fastfoodshop.models.Category
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class CategoryAdapter(val items : List<Category>) : RecyclerView.Adapter<CategoryAdapter.ItemHolder>() {
    inner class ItemHolder(val binding : CategoryItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        return ItemHolder(
            CategoryItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,false
            )
        )
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {

        val item = items[position]

        holder.binding.tvCategoryName.text = item.strCategory
        Glide.with(holder.itemView)
            .load(item.strCategoryThumb)
            .into(holder.binding.imgCategory)

    }

    override fun getItemCount(): Int {
        return items.size
    }
}