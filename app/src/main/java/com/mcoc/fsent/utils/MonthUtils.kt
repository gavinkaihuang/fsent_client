package com.mcoc.fsent.utils

object MonthUtils {

    fun getMonthPrompt(month: Int): String {
        when(month) {
            1 -> return "January"
            2 -> return "February"
            3 -> return "March"
            4 -> return "April"
            5 -> return "May"
            6 -> return "June"
            7 -> return "July"
            8 -> return "August"
            9 -> return "September"
            10 -> return "October"
            11 -> return "November"
            else -> return "December"
        }
    }
}