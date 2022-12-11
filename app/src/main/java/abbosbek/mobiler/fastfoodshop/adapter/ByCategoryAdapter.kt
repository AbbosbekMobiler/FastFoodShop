package abbosbek.mobiler.fastfoodshop.adapter

import abbosbek.mobiler.fastfoodshop.R
import abbosbek.mobiler.fastfoodshop.databinding.ByCategoryItemBinding
import abbosbek.mobiler.fastfoodshop.databinding.CategoryItemBinding
import abbosbek.mobiler.fastfoodshop.models.Category
import abbosbek.mobiler.fastfoodshop.models.CategoryByNameModel
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

interface OnClickListener{
    fun onClick(item : CategoryByNameModel)
}

class ByCategoryAdapter(val items : List<CategoryByNameModel>,val listener: OnClickListener) : RecyclerView.Adapter<ByCategoryAdapter.ItemHolder>() {
    inner class ItemHolder(val binding : ByCategoryItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        return ItemHolder(
            ByCategoryItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,false
            )
        )
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {

        val item = items[position]


        holder.itemView.setOnClickListener {
            items.forEach{
                it.checked = false
            }
            item.checked = true
            listener.onClick(item)
            notifyDataSetChanged()
        }

        holder.binding.tvCategoryName.text = item.title

        if (item.checked){
            holder.binding.cardCategoryName.
            setCardBackgroundColor(ContextCompat
                .getColor(holder.itemView.context, R.color.colorPrimary)
            )
        }else{
            holder.binding.cardCategoryName.
            setCardBackgroundColor(ContextCompat
                .getColor(holder.itemView.context, R.color.white)
            )
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }
}