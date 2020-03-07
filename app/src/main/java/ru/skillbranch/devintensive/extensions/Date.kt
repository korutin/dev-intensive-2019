package ru.skillbranch.devintensive.extensions

import java.text.SimpleDateFormat
import java.util.*

const val SECOND = 1000L
const val MINUTE = 60 * SECOND
const val HOUR = 60 * MINUTE
const val DAY = 24 * HOUR

fun Date.format(pattern:String="HH:mm:ss dd.MM.yy"):String {
    val dateFormat = SimpleDateFormat(pattern, Locale("ru"))
    return dateFormat.format(this)
}

fun Date.humanizeDiff(date: Date = Date()): String {
    var r:String
    val df = (date.time - this.time) / 1000L
    when (df) {
            in 0L..1L ->  r = "только что"
            in 1L..45L -> r = "несколько секунд назад" //1с - 45с "несколько секунд назад"
            in 45L..75L -> r = "минуту назад"
            in 75L..45*60L -> r = when(df/60L){
                                    in 5L..19L -> "${df/60L} минут назад"
                                    else -> when (df/60L % 10) {
                                        1L -> "${df / 60L} минуту назад"
                                        in 2L..4L -> "${df / 60L} минуты назад"
                                        else -> "${df/60L} минут назад"
                                    }
                                }
            in 45*60L..75*60L -> r = "час назад"
            in 75*60L..22*60*60L -> r = when (df/3600L){
                                        in 5L..19L -> "${df/3600L} часов назад"
                                        else -> when (df/3600L % 10) {
                                            1L -> "${df / 3600L} час назад"
                                            in 2L..4L -> "${df / 3600L} часа назад"
                                            else -> "${df/3600L} часов назад"
                                            }    
                                        }
            in 22*60*60L..26*60*60L -> r = "день назад"
            in 26*60*30L..360*24*60*60L -> r = when (df/86400L) {
                in 5L..19L -> "${df/86400L} дней назад"
                else -> when (df/86400L % 10) {
                    1L -> "${df / 86400L} день назад"
                    in 2L..4L -> "${df / 86400L} дня назад"
                    else -> "${df/86400L} дней назад"
                }
            }
            else -> r = "более года назад"
        }
    return r
}

fun Date.add(value:Int, units: TimeUnits = TimeUnits.SECOND) : Date {
    var time = this.time
    time += when(units){
        TimeUnits.SECOND->value * SECOND
        TimeUnits.MINUTE->value * MINUTE
        TimeUnits.HOUR->value * HOUR
        TimeUnits.DAY->value * DAY
    }
    this.time = time
    return this
}

enum class TimeUnits{SECOND, MINUTE, HOUR, DAY}