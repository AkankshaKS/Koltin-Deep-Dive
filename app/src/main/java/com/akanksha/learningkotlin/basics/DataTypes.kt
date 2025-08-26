package com.akanksha.learningkotlin.basics

fun main() {

    val intNum: Int? = 123
    val longNum: Long? = 22300 * 809
    val doubleNum: Double? = 240.24
    val floatNum: Float? = 2.56f
    val charValue: Char? = 'v'
    val boolValue: Boolean? = true
    val stringValue: String? = "hello"

    println("Int: $intNum, Long: $longNum, Double: $doubleNum, Float: $floatNum, Char: $charValue, Boolean: $boolValue, String: $stringValue")

    val x = 42
    val y = 34.78
    val z = "tick"

    println("x: ${x::class}, y: ${y::class.java} z: ${z::class.java}")

    val a  = 10
    val b : Long = a.toLong()
    println("Converted int to Long: $a , $b")

    val ch: Char = 'B'
    val ascii = ch.code
    println("ascii: $ascii")

    val rawString = """
        |This is a raw string
        |It preserves formatting
        |Tabs and newlines stay as is
    """.trimIndent()
    println(rawString)

    val numbers = arrayOf(1,2,3,4)
    val squares = Array(5) {i -> i * i}
    println("numbers: ${numbers.joinToString ()}")
    println("squares: ${squares.joinToString ()}")

    val any : Any = " hold any "
    println("Any : $any")

    fun fail() : Nothing{
        throw Exception("exception!!")
    }

    //fail()

}