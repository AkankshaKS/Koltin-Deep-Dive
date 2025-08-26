package com.akanksha.learningkotlin.basics



fun main(){

    var name : String = "Akanksha"
    name = "JJ"
    println(name)

    var count = 0
    val increment = {count++}
    increment()
    println(count)

    val age = 27
    println(age)

    val list = mutableListOf<Int>(1,2,3)
    list.add(4)
    println(list)


    var place : String? = "Tokyo"
    place = null
    println(place)

    val user = User()
    user.initName("Ria")
    println(user.name)
    println("init lazyConfig 1st {$user.lazyConfig}")
    println("init lazyConfig 2nd {$user.lazyConfig}")


}

class User{

    lateinit var name: String

    val lazyConfig : String by lazy {
        println("Lazyconfig init once")
        "This lazy is initialzed"
    }

    fun initName( newName : String){
        name = newName

    }
}