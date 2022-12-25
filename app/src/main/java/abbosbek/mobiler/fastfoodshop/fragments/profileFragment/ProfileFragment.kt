package abbosbek.mobiler.fastfoodshop.fragments.profileFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import abbosbek.mobiler.fastfoodshop.R
import abbosbek.mobiler.fastfoodshop.adapter.ProfileItemAdapter
import abbosbek.mobiler.fastfoodshop.databinding.FragmentProfileBinding
import abbosbek.mobiler.fastfoodshop.models.ProfileItemModel
import abbosbek.mobiler.fastfoodshop.models.ProfileModel

class ProfileFragment : Fragment() {

    lateinit var binding : FragmentProfileBinding

    private val profileList = listOf(
        ProfileModel("Gifts and Bonuses",
            listOf(
                ProfileItemModel(R.drawable.ic_gift,"Share a code with a friend"),
                ProfileItemModel(R.drawable.ic_money,"Get a bonus")
            )
        ),
        ProfileModel("Payment and addresses",
            listOf(
                ProfileItemModel(R.drawable.ic_wallet,"Payment Cards"),
                ProfileItemModel(R.drawable.ic_location_map,"My Addresses")
            )
        ),
        ProfileModel("Settings",
            listOf(
                ProfileItemModel(R.drawable.ic_language,"Language"),
            )
        ),
        ProfileModel("Information",
            listOf(
                ProfileItemModel(R.drawable.ic_baseline_notifications_24,"Notification"),
                ProfileItemModel(R.drawable.ic_document,"Support"),
                ProfileItemModel(R.drawable.ic_doc,"Terms of use")
            )
        ),
        ProfileModel("",
            listOf(
                ProfileItemModel(R.drawable.ic_clock,"Sign Out"),
                ProfileItemModel(R.drawable.ic_person,"Account Delete")
            )
        )
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentProfileBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.profileRecycler.adapter = ProfileItemAdapter(profileList)

    }
}