package com.nexis.ders25_evtapsirigi

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.nexis.ders25_evtapsirigi.Adapter.ServiceAdapter
import com.nexis.ders25_evtapsirigi.databinding.FragmentListBinding
import com.nexis.ders_25_webserivce.Helper.RetrofitHelper
import com.nexis.ders_25_webserivce.remote.UserResponseModel
import com.nexis.ders_25_webserivce.service.UserService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ListFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    lateinit var binding: FragmentListBinding

    lateinit var adapter: ServiceAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListBinding.inflate(inflater, container, false);
        return binding.root;
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = ServiceAdapter(
            arrayListOf(),
            { model ->
                navigateToService(model)
            }


        )

        binding.RVService.adapter = adapter

        val list = getUserlist()
    }


    fun navigateToService(model: UserResponseModel) {
        val bundle = Bundle()
        bundle.putString("data", model.name)
        bundle.putString("data1", model.username)
        bundle.putString("data2", model.email)

        findNavController().navigate(
            R.id.action_listFragment_to_detailsFragment,
            bundle
        )
    }


    private fun getUserlist() {
        var userList = arrayListOf<UserResponseModel>()
        val retrofit = RetrofitHelper.retrofitBuilder()
        val userApi = retrofit.create(UserService::class.java)
        val call = userApi.getFriends()
        call.enqueue(object : Callback<List<UserResponseModel?>> {

            override fun onResponse(
                call: Call<List<UserResponseModel?>>,
                response: Response<List<UserResponseModel?>>
            ) {
                if (response.isSuccessful) {
                    val body = response.body()
                    userList = body as ArrayList<UserResponseModel>
                    adapter.updateList(userList)

                }
            }

            override fun onFailure(call: Call<List<UserResponseModel?>>, t: Throwable) {
                t.printStackTrace()
            }


        })
    }


}