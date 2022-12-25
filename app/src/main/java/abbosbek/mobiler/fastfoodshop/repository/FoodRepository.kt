package abbosbek.mobiler.fastfoodshop.repository

import abbosbek.mobiler.fastfoodshop.MyApp
import abbosbek.mobiler.fastfoodshop.api.NetworkManager
import abbosbek.mobiler.fastfoodshop.models.*
import androidx.lifecycle.MutableLiveData
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers

class FoodRepository {

    var api = NetworkManager.getApiInstance()
    var compositeDisposable = CompositeDisposable()
    var firestore = MyApp.firestore

    fun getCategory(
        progress : MutableLiveData<Boolean>,
        error : MutableLiveData<String>,
        success: MutableLiveData<List<Category>>
    ){
        compositeDisposable.add(
            api.getCategory()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe{
                    progress.value = true
                }
                .doFinally {
                    progress.value = false
                }
                .subscribeWith(object : DisposableObserver<BaseResponse<List<Category>>>(){
                    override fun onNext(t: BaseResponse<List<Category>>) {
                        success.value = t.categories
                    }

                    override fun onError(e: Throwable) {
                        error.value = e.localizedMessage
                    }

                    override fun onComplete() {
                        //
                    }
                })
        )
    }
 fun getTopMeal(
        error : MutableLiveData<String>,
        success: MutableLiveData<List<TopModel>>
    ){
        compositeDisposable.add(
            api.getTopMeal()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableObserver<BaseTopModel<List<TopModel>>>(){
                    override fun onNext(t: BaseTopModel<List<TopModel>>) {
                        success.value = t.meals
                    }

                    override fun onError(e: Throwable) {
                        error.value = e.localizedMessage
                    }

                    override fun onComplete() {
                        //
                    }
                })
        )
    }

 fun getBreakFast(
        error : MutableLiveData<String>,
        success: MutableLiveData<List<TopModel>>
    ){
        compositeDisposable.add(
            api.getBreakFast()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableObserver<BaseTopModel<List<TopModel>>>(){
                    override fun onNext(t: BaseTopModel<List<TopModel>>) {
                        success.value = t.meals
                    }

                    override fun onError(e: Throwable) {
                        error.value = e.localizedMessage
                    }

                    override fun onComplete() {
                        //
                    }
                })
        )
    }

 fun getCategoryFood(
     a : String,
     error : MutableLiveData<String>,
     success: MutableLiveData<List<TopModel>>
    ){
        compositeDisposable.add(
            api.getCategoryFood(a)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableObserver<BaseTopModel<List<TopModel>>>(){
                    override fun onNext(t: BaseTopModel<List<TopModel>>) {
                        success.value = t.meals
                    }

                    override fun onError(e: Throwable) {
                        error.value = e.localizedMessage
                    }

                    override fun onComplete() {
                        //
                    }
                })
        )
    }

 fun getItemFood(
     i : String,
     error : MutableLiveData<String>,
     success: MutableLiveData<List<ItemModel>>
    ){
        compositeDisposable.add(
            api.getItem(i)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableObserver<BaseTopModel<List<ItemModel>>>(){
                    override fun onNext(t: BaseTopModel<List<ItemModel>>) {
                        success.value = t.meals
                    }

                    override fun onError(e: Throwable) {
                        error.value = e.localizedMessage
                    }

                    override fun onComplete() {
                        //
                    }
                })
        )
    }

    fun getCoupons(
        error: MutableLiveData<String>,
        success: MutableLiveData<List<CouponsModel>>
    ){
        firestore.collection("coupons")
            .get()
            .addOnSuccessListener {
                for (document in it){
                    val item = it.toObjects(CouponsModel::class.java)
                    success.value = item
                }
            }
            .addOnFailureListener {
                error.value = it.localizedMessage
            }
    }

}