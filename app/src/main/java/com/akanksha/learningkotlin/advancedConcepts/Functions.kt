package com.akanksha.learningkotlin.advancedConcepts

import kotlinx.coroutines.delay
import kotlin.math.sqrt

inline fun measureTime(block: () -> Unit) {
    val start = System.nanoTime()
    block()
    val end = System.nanoTime()
    println("Time taken: ${end - start} ns")
}

fun main() {

    fun greet(name: String): String {
        return "Hello $name"
    }
    println(greet("Akanksha"))

    fun square(x: Int) = x * x
    println(square(2))

    fun printUser(name: String, age: Int = 25, location: String) {
        println("Name=$name, Age=$age, City=$location")
    }
    printUser("Akanksha", location = "Tokyo")
    printUser("Riya", age = 10, location = "Tokyo")

    fun sumAll(vararg nums: Int): Int {
        return nums.sum()
    }
    println("sum of ${sumAll(1, 2, 3, 4)}")

    fun operate(a: Int, b: Int, op: (Int, Int) -> Int): Int {
        return op(a, b)
    }

    val add = operate(5, 6) { x, y -> x + y }
    val minus = operate(90, 7) { x, y -> y - x }
    println("add $add")
    println("minus $minus")

    fun isEven(a: Int) = a % 2 == 0
    val numbers = listOf<Int>(1, 2, 3, 4, 55, 34, 56)
    val evenNo = numbers.filter(::isEven)
    println("isEven $evenNo")


    measureTime {
        repeat(1000) { _ ->
            sqrt(2431.5)
        }
    }

    fun outer(msg: String) {
        fun inner() = println("hello from inner : $msg")
        inner()
    }
    outer("Helo from outer")

    fun String.isPalindrome(): Boolean {
        return this == this.reversed()

    }
    println("sees".isPalindrome())

    var counter = 0
    val increment = {counter++}
    increment(); increment
    println("Counter : $counter")


}