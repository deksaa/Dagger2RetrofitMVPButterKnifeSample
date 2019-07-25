package co.destanerik.mvpsample.util.dateutil

import java.text.SimpleDateFormat
import java.util.*

class DateTimeHelper {

    private val date = Date()

    private val simpleDateFormat = SimpleDateFormat("dd/MM/yyyy")
    private val simpleDateTimeFormat = SimpleDateFormat("dd/MM/yyyy HH:mm:ss")

    fun getCurrentDay() : String
    {
        val cal = Calendar.getInstance()
        cal.time = date
        return (cal.get(Calendar.DAY_OF_MONTH)).toString()
    }

    fun getCurrentMonth() : String
    {
        val cal = Calendar.getInstance()
        cal.time = date
        return (cal.get(Calendar.MONTH) + 1).toString()
    }

    fun getCurrentDate() : String = simpleDateFormat.format(date)

    fun getCurrentDateTime() : String = simpleDateTimeFormat.format(date)

}