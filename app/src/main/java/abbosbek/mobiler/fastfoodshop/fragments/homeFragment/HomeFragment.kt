package abbosbek.mobiler.fastfoodshop.fragments.homeFragment

import abbosbek.mobiler.fastfoodshop.R
import abbosbek.mobiler.fastfoodshop.adapter.*
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import abbosbek.mobiler.fastfoodshop.databinding.FragmentHomeBinding
import abbosbek.mobiler.fastfoodshop.models.Category
import abbosbek.mobiler.fastfoodshop.models.CategoryByNameModel
import abbosbek.mobiler.fastfoodshop.viewModel.MainViewModel
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.denzcoskun.imageslider.ImageSlider
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.models.SlideModel

class HomeFragment : Fragment() {

    lateinit var binding: FragmentHomeBinding
    lateinit var viewModel : MainViewModel
    lateinit var imageSlider: ImageSlider

    val imageList = ArrayList<SlideModel>()

    val categoryList = ArrayList<CategoryByNameModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        imageSlider = binding.imgSlide
        viewModel.progress.observe(viewLifecycleOwner){
            binding.progress.isVisible = it
        }

        viewModel.error.observe(viewLifecycleOwner){
            Toast.makeText(requireActivity(), it, Toast.LENGTH_SHORT).show()
        }

        viewModel.categoryFood.observe(viewLifecycleOwner){
            setAdapter(it)
        }

        viewModel.topFood.observe(viewLifecycleOwner){
            binding.recyclerTop.adapter = TopMealAdapter(it)
        }

        viewModel.breakFast.observe(viewLifecycleOwner){
            binding.recyclerBreak.adapter = BreakFastAdapter(it)
        }

        viewModel.coupons.observe(viewLifecycleOwner){
            binding.recyclerCoupons.adapter = CouponsAdapter(it)
        }

        viewModel.categoryFoodItem.observe(viewLifecycleOwner){
            binding.recyclerByCategoryItem.adapter = CategoryByItemAdapter(it)
        }

        imageList.add(SlideModel(R.drawable.discount2))
        imageList.add(SlideModel(R.drawable.discount3))
        imageList.add(SlideModel(R.drawable.discount4))
        imageSlider.setImageList(imageList,ScaleTypes.CENTER_CROP)

        loadData()
        loadByCategory("Canadian")

        categoryList.add(CategoryByNameModel("Canadian",true))
        categoryList.add(CategoryByNameModel("British"))
        categoryList.add(CategoryByNameModel("Spanish"))
        categoryList.add(CategoryByNameModel("Turkish"))
        categoryList.add(CategoryByNameModel("Japanese"))
        categoryList.add(CategoryByNameModel("Italian"))
        categoryList.add(CategoryByNameModel("American"))
        categoryList.add(CategoryByNameModel("Egyptian"))
        categoryList.add(CategoryByNameModel("French"))

        binding.recyclerByCategory.adapter = ByCategoryAdapter(categoryList,object : OnClickListener{
            override fun onClick(item: CategoryByNameModel) {
                loadByCategory(item.title)
            }
        })
    }

    private fun loadData(){
        viewModel.getCategory()
        viewModel.getTopMeal()
        viewModel.getBreakfast()
        viewModel.getCoupons()
    }

    private fun loadByCategory(a : String){
        viewModel.getCategoryFood(a)
    }
    private fun setAdapter(items : List<Category>){
        binding.recyclerCategory.layoutManager = GridLayoutManager(requireActivity(),2,GridLayoutManager.HORIZONTAL,false)
        binding.recyclerCategory.adapter = CategoryAdapter(items)
    }
}