package ru.skillbranch.devintensive.utils

object Utils {
    val trLit:Map<String,String> = mapOf(
        "а" to "a",
        "б" to "b",
        "в" to "v",
        "г" to "g",
        "д" to "d",
        "е" to "e",
        "ё" to "e",
        "ж" to "zh",
        "з" to "z",
        "и" to "i",
        "й" to "i",
        "к" to "k",
        "л" to "l",
        "м" to "m",
        "н" to "n",
        "о" to "o",
        "п" to "p",
        "р" to "r",
        "с" to "s",
        "т" to "t",
        "у" to "u",
        "ф" to "f",
        "х" to "h",
        "ц" to "c",
        "ч" to "ch",
        "ш" to "sh",
        "щ" to "sh'",
        "ъ" to "",
        "ы" to "i",
        "ь" to "",
        "э" to "e",
        "ю" to "yu",
        "я" to "ya"
    )
    fun transliteration(payload:String, divider:String =" "):String{
        var s:String =""
        var sym:Char
        var key:String
        var f:Int
        var trSym:String?
        for (sym in payload)
        {
            if (sym.isUpperCase())
            {
                f = 1
                key = sym.toLowerCase().toString()
            } else {
                f = 0
                key = sym.toString()
            }
            trSym = trLit.get(key)
            if (trSym.isNullOrBlank())
                s = s + divider
            else
                if (f==1)
                    s = s + trSym.toUpperCase()
                else
                    s = s + trSym
        }
        return s
    }
    fun parseFullName(fullName:String?):Pair<String?, String?> {
        var firstName:String?
        var lastName:String?

        if (fullName.isNullOrBlank())
        {
            firstName = null
            lastName = null
        }
        else
        {
        val parts: List<String>? = fullName?.split(" ")
        firstName = parts?.getOrNull(0)
        lastName = parts?.getOrNull(1)
        }
        return Pair(firstName, lastName)
    }

    fun toInitials(firstName:String?, lastName:String?):String? {
        val A: String? = if (firstName.isNullOrBlank()) "" else ""+(firstName.trimStart()).get(0)
        val B: String? = if (lastName.isNullOrBlank()) "" else ""+(lastName.trimStart()).get(0)

        return A+B
    }
}