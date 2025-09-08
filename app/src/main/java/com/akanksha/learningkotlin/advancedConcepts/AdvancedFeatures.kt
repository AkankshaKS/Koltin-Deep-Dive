package com.akanksha.learningkotlin.advancedConcepts

fun main(){

    println("=== 1. Extension Function ===")
    fun String.isPalindrome() : Boolean{
        return this == this.reversed()
    }
    println("madam".isPalindrome())
    println("hello".isPalindrome())

    println("=== 2. Infix Function ===")
    infix fun Int.times(str : String) = str.repeat(this)
    println(3 times " Hi ")

    println("\n=== 3. Operator Overloading ===")
    data class Point(val x: Int, val y : Int){
        operator fun plus(other : Point) = Point(x + other.x, y + other.y)
    }
    val p1 = Point(2,4)
    val p2 = Point(12,4)
    println("p1+p2 = ${p1+p2}")

    println("\n=== 4. Generics ===")
    class Box<T>(val value: T) {
        fun get(): T = value
    }
    val intBox = Box(123)
    val strBox = Box("Kotlin")
    println("IntBox=${intBox.get()}, StrBox=${strBox.get()}")

    println("\n=== 5. Generic Constraints ===")
    fun <T : Number> mySum(a : T, b : T) : Double{
        return a.toDouble() + b.toDouble()
    }
    println(mySum(5, 10))        // Ints
    println(mySum(5.5, 2.3))     // Doubles
    println(mySum(3L, 7L))

/*    println("\n=== 7. Reified Type Parameters ===")
    inline fun <reified T> isType(value: Any): Boolean {
        return value is T
    }
    println("Is 123 Int? ${isType<Int>(123)}")
    println("Is 'Hello' String? ${isType<String>("Hello")}")*/



}