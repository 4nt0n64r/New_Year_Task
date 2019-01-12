package com.ant0n64r.newyeartask

import android.graphics.Bitmap

data class ProgrammingLanguage(
    val name:String,
    val authors:String,
    val year:Int,
    var paradigms:List<String>,
    val logo:Bitmap,
    val indexTIOBE:Int,
    val link:String) {

}