package com.example.adminwaveoffood.adapter

import android.content.res.ColorStateList
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.adminwaveoffood.databinding.DeliveryitemBinding

class DeliveryAdapter(
    private val customerNames: MutableList<String>,
    private val moneyStatus: MutableList<Boolean>
) : RecyclerView.Adapter<DeliveryAdapter.DeliveryViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): DeliveryAdapter.DeliveryViewHolder {
        val binding =
            DeliveryitemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DeliveryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DeliveryAdapter.DeliveryViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int {
        return customerNames.size
    }

    inner class DeliveryViewHolder(private val binding: DeliveryitemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int) {
            binding.apply {
                customerName.text = customerNames[position]

                if (moneyStatus[position] == true){
                    statusMoney.text = "Received"
                }else {
                    statusMoney.text = "NotReceived"
                }

                val colorMap = mapOf(
                    true to Color.GREEN, false to Color.RED
                )

                statusMoney.setTextColor(colorMap[moneyStatus[position]] ?: Color.BLACK)
                statusColor.backgroundTintList =
                    ColorStateList.valueOf(colorMap[moneyStatus[position]] ?: Color.BLACK)

            }
        }
    }
}