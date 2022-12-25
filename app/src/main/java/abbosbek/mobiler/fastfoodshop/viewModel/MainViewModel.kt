package abbosbek.mobiler.fastfoodshop.viewModel

import abbosbek.mobiler.fastfoodshop.models.Category
import abbosbek.mobiler.fastfoodshop.models.CouponsModel
import abbosbek.mobiler.fastfoodshop.models.ItemModel
import abbosbek.mobiler.fastfoodshop.models.TopModel
import abbosbek.mobiler.fastfoodshop.repository.FoodRepository
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    var repository = FoodRepository()


    private var _progress = MutableLiveData<Boolean>()
    val progress : LiveData<Boolean> get() {return _progress}

    private var _error = MutableLiveData<String>()
    val error : LiveData<String> get() {return _error}

    private var  _categoryFood = MutableLiveData<List<Category>>()
    val categoryFood : LiveData<List<Category>> get() {return _categoryFood}

    private var  _topFood = MutableLiveData<List<TopModel>>()
    val topFood : LiveData<List<TopModel>> get() {return _topFood}

    private var  _breakFast = MutableLiveData<List<TopModel>>()
    val breakFast : LiveData<List<TopModel>> get() {return _breakFast}

    private var  _categoryFoodItem = MutableLiveData<List<TopModel>>()
    val categoryFoodItem : LiveData<List<TopModel>> get() {return _categoryFoodItem}

    private var  _coupons = MutableLiveData<List<CouponsModel>>()
    val coupons : LiveData<List<CouponsModel>> get() {return _coupons}

    private var _items = MutableLiveData<List<ItemModel>>()
    val items : LiveData<List<ItemModel>> get() {return _items}

    fun getCategory(){
        repository.getCategory( _progress,_error,_categoryFood)
    }
    fun getTopMeal(){
        repository.getTopMeal(_error,_topFood)
    }
    fun getBreakfast(){
        repository.getBreakFast(_error,_breakFast)
    }

    fun getCoupons(){
        repository.getCoupons(_error,_coupons)
    }

    fun getCategoryFood(a : String){
        repository.getCategoryFood(a,_error,_categoryFoodItem)
    }

    fun getItemFood(i : String){
        repository.getItemFood(i,_error,_items)
    }

}