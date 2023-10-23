package com.nexis.ders25_evtapsirigi.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.nexis.ders25_evtapsirigi.databinding.CardServiceBinding
import com.nexis.ders_25_webserivce.remote.UserResponseModel

class ServiceViewHolder(
    val parent: ViewGroup,
    val binding: CardServiceBinding = CardServiceBinding.inflate(
        LayoutInflater.from(
            parent.context
        ), parent, false
    )
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(
        dataService: UserResponseModel,
        navigateToService: (UserResponseModel) -> Unit
    ) {

        binding.txtAd.text = dataService.name
        binding.txtSoyadi.text = dataService.username
        binding.txtMail.text = dataService.email

//        binding.txtVB.text = dataVerticalKino.basliqVertical
//        binding.txtVI.text = dataVerticalKino.icerikVertical
//        Glide.with(parent.context).load(dataVerticalKino.sekilVertical).centerCrop()
//            .into(binding.IVVertical)

        itemView.setOnClickListener{
            navigateToService(dataService)
        }

//        binding.cView.setOnClickListener {
//            navigateToService(dataService)
//        }



    }



//    val basliqVertical = itemView.findViewById<TextView>(R.id.txtVB)
//    val icerikVertical = itemView.findViewById<TextView>(R.id.txtVI)
//    val sekilVertical = itemView.findViewById<ImageView>(R.id.IVVertical)
//    val btnVertikal = itemView.findViewById<Button>(R.id.btnVertikal)
}