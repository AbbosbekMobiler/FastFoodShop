package abbosbek.mobiler.fastfoodshop

import abbosbek.mobiler.fastfoodshop.databinding.ActivityMainBinding
import abbosbek.mobiler.fastfoodshop.fragments.cartFragment.CartFragment
import abbosbek.mobiler.fastfoodshop.fragments.homeFragment.HomeFragment
import abbosbek.mobiler.fastfoodshop.fragments.profileFragment.ProfileFragment
import abbosbek.mobiler.fastfoodshop.fragments.searchFragment.SearchFragment
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val homeFragment = HomeFragment()
    private val searchFragment = SearchFragment()
    private val cartFragment = CartFragment()
    private val profileFragment = ProfileFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setFragment(homeFragment)

        binding.bottomNav.setItemSelected(R.id.actionHome,true)
        binding.bottomNav.setOnItemSelectedListener {
            when(it){
                R.id.actionHome -> setFragment(homeFragment)
                R.id.actionSearch -> setFragment(searchFragment)
                R.id.actionCart -> setFragment(cartFragment)
                R.id.actionProfile -> setFragment(profileFragment)
            }
        }

    }

    private fun setFragment(fragment: Fragment){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fl_Container,fragment)
        transaction.commit()
    }
}