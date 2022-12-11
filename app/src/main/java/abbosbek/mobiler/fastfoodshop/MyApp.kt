package abbosbek.mobiler.fastfoodshop

import android.annotation.SuppressLint
import android.app.Application
import com.google.firebase.firestore.FirebaseFirestore

class MyApp : Application() {

    @SuppressLint("StaticFieldLeak")
    companion object{
        lateinit var app : MyApp
        lateinit var firestore: FirebaseFirestore
    }

    override fun onCreate() {
        super.onCreate()
        app = this
        firestore = FirebaseFirestore.getInstance()
    }
}