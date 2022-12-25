package abbosbek.mobiler.fastfoodshop

import abbosbek.mobiler.fastfoodshop.databinding.ActivityItemBinding
import abbosbek.mobiler.fastfoodshop.models.TopModel
import abbosbek.mobiler.fastfoodshop.utils.Constants
import abbosbek.mobiler.fastfoodshop.viewModel.MainViewModel
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide

class ItemActivity : AppCompatActivity() {

    private lateinit var binding : ActivityItemBinding

    private lateinit var item : TopModel

    private lateinit var viewModel : MainViewModel

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityItemBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        item = intent.getSerializableExtra(Constants.ITEM) as TopModel

        binding.btnBack.setOnClickListener {
            finish()
        }

        viewModel.items.observe(this){
            Glide.with(this).load(it[0].strMealThumb).into(binding.imgBreakFast)
        }
        viewModel.items.observe(this){
            binding.tvTitle.text = it[0].strMeal
            binding.tvDesc.text = it[0].strInstructions
        }

        loadData(item.idMeal)
    }

    private fun loadData(i : String){
        viewModel.getItemFood(i)
    }
}