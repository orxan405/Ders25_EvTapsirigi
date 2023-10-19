package com.nexis.ders25_evtapsirigi.Adapter

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nexis.ders_25_webserivce.remote.UserResponseModel

class ServiceAdapter(
    val list_V: ArrayList<UserResponseModel>,
    val navigateToService: (UserResponseModel) -> Unit
) : RecyclerView.Adapter<ServiceViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ServiceViewHolder {
        return ServiceViewHolder(parent)
    }

    override fun getItemCount() = list_V.size

    override fun onBindViewHolder(holder: ServiceViewHolder, position: Int) {
        holder.bind(list_V[position], navigateToService)

        Log.i("onBindViewHolder", list_V[position].toString())

        holder.binding.btnEtrafli.setOnClickListener {
          //  holder.binding.btnEtrafli.setBackgroundColor(Color.DKGRAY)

            if (!holder.binding.txtAd.toString().isEmpty() && !holder.binding.txtSoyadi.toString()
                    .isEmpty()
            ) {
                val bundle = Bundle()
                bundle.putString("data", holder.binding.txtAd.toString())

                holder.binding.btnEtrafli.text = holder.binding.txtAd.text.toString()
            }
        }


//
    }

    fun updateList(userList: ArrayList<UserResponseModel>) {
        list_V.clear()
        list_V.addAll(userList)
        notifyDataSetChanged()
    }
}