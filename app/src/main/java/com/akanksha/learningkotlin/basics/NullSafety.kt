package com.akanksha.learningkotlin.basics

fun main(){

    var name : String? = null
    name = null
    println(name) //  null allowed

    println(name?.length) // safe call

    val length = name?.length ?: 0
    println(length)

    /*try {
        println(name!!.length)
    } catch (e : Exception){
        println(e.toString())
    }*/

    val location : String? = "Tokyo"
    location?.let { println(location) }

    val myList = listOf("one", null, "three")
    for(item in myList){
        println(item)
    }


}

