package ru.skillbranch.devintensive.extensions

fun String.truncate(nSym:Int?=null) : String {
    var S : String = this
    nSym?.let {S =this.substring(0, if (this.length>nSym) nSym else this.length)+"..." }
    return S
}