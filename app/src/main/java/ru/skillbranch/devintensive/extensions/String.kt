package ru.skillbranch.devintensive.extensions

fun String.truncate(nSym:Int?) : String {
    var S : String = ""
    nSym?.let {S =this.substring(0, if (this.length>nSym) nSym else this.length)+"..." }
    return S
}