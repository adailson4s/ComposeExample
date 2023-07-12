package com.pandanordico.composeexample.persistence

import androidx.room.TypeConverter
import java.math.BigDecimal

class DatabaseConverters {

    @TypeConverter
    fun xToY(bigDecimal: BigDecimal): String = bigDecimal.toString()
}