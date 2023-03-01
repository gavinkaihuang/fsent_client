package com.mcoc.fsent.fragments.placeholder

import java.util.ArrayList

object BankHolder {

    val ITEMS: MutableList<BankItem> = ArrayList()

    fun addItem(item: BankItem) {
        ITEMS.add(item)
    }

//    open data class BankItem() {
//        lateinit var id: String
//        lateinit var code: String
//        lateinit var content: String
//        lateinit var iconUrl: String
//        lateinit var note: String
//        override fun toString(): String = content
//    }

    data class BankItem(var id: Int, var code: String, var bankname: String, var iconUrl: String, var note: String) {
        override fun toString(): String = bankname
    }
}