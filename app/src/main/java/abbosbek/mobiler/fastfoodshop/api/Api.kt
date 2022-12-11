package abbosbek.mobiler.fastfoodshop.api

import abbosbek.mobiler.fastfoodshop.models.BaseResponse
import abbosbek.mobiler.fastfoodshop.models.BaseTopModel
import abbosbek.mobiler.fastfoodshop.models.Category
import abbosbek.mobiler.fastfoodshop.models.TopModel
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {

    @GET("categories.php")
    fun getCategory() : Observable<BaseResponse<List<Category>>>

    @GET("filter.php?i=chicken_breast")
    fun getTopMeal() : Observable<BaseTopModel<List<TopModel>>>

    @GET("filter.php?a=Canadian")
    fun getBreakFast() : Observable<BaseTopModel<List<TopModel>>>


    @GET("filter.php")
    fun getCategoryFood(
        @Query("a") a : String = "Canadian"
    ) : Observable<BaseTopModel<List<TopModel>>>


}