package com.mcoc.fsent.fragments

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.mcoc.fsent.R
import com.mcoc.fsent.databinding.FragmentBankItemBinding
import com.mcoc.fsent.fragments.placeholder.BankHolder

import com.mcoc.fsent.fragments.placeholder.BankPlaceholderContent.PlaceholderItem

/**
 * [RecyclerView.Adapter] that can display a [PlaceholderItem].
 * TODO: Replace the implementation with code for your data type.
 */
class BankItemRecyclerViewAdapter() : RecyclerView.Adapter<BankItemRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(FragmentBankItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values[position]
//        holder.icon.text = item.bankname
        holder.imageView.setImageResource(getImageResourceID(item.code))
        holder.titleView.text = item.bankname
        holder.noteView.text = item.note
    }

    var values: List<BankHolder.BankItem> = ArrayList<BankHolder.BankItem>()

    fun setItemList(list: List<BankHolder.BankItem> ) {
        values = list
    }

    override fun getItemCount(): Int = values.size

    inner class ViewHolder(binding: FragmentBankItemBinding) : RecyclerView.ViewHolder(binding.root) {

        val imageView: ImageView = binding.itemImage
        val titleView: TextView = binding.itemTitle
        val noteView: TextView = binding.itemNote

        override fun toString(): String {
            return super.toString() + " '" + noteView.text + "'"
        }
    }

    fun getImageResourceID(code: String): Int {
        when (code) {
            "zsyh" -> return R.drawable.logo_zhaoshang
            "yayh" -> return R.drawable.logo_pingan
            "jsyh" -> return R.drawable.logo_jd
            "xyyh" -> return R.drawable.logo_xingye
            "zgyh" -> return R.drawable.logo_boc
            "msyh" -> return R.drawable.logo_mingshen
            "alipay" -> return R.drawable.logo_alipay
            "jdbt" -> return R.drawable.logo_jd
        }
        return  R.drawable.logo_jd
    }

}