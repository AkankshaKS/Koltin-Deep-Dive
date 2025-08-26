package com.akanksha.learningkotlin.basics

fun main() {

    val a = 20
    val b = 30

    val max = if (a > b) a else b
    println(" greater is  {$max}")

    val status = if (a > b) {
        println(" a is greater")
        a
    } else {
        println(" b is greater")
        b
    }

    println(" greater is  {$status}")


    val x = 2
    val result = when (x) {
        1 -> "One"
        2 -> "Two"
        3, 4 -> "3 or 4"
        in 5..10 -> "5 to 10"
        !in 11..20 -> "not between 11 to 20"
        else -> "unknown"
    }

    println("Result :  $result")

    fun check(obj: Any) = when (obj) {
        is Int -> "is integer"
        is String -> "is string"
        is Double -> "is double"
        else -> "unknown"
    }
    println(
        //  check(2)
        check("aaa")
        //check(2.3)
    )


    var count: Int = 0
    for (i in 1..5) {
        count = i
        println("count $count")
    }

    for (i in 1 until 5) {
        println("count2 $i")
    }

    for (i in 10 downTo 1 step 3) {
        println("count3 $i")
    }

    var z = 0
    do {
        println("D + $z")
        z++
    } while (z < 3)
    // println()


    loop@ for (i in 1..3) {
        for (j in 1..3) {
            if (i == 2 && j == 2)
                break@loop
            println("i $i j $j")
        }
    }

    val nums = (1..10).step(2)
    println("odd nos are ${nums.joinToString()}")

    println("Is 6 in range ${4 in 1..10}")

    val grade = 1000
    val category = when (grade) {

        in 1..40 -> "okay"
        in 41..60 -> "good"
        in 61..100 -> "best"
        else -> "not sure"
    }
    println("category is $category")

    val num = "123"
    val parsed = try {
        num.toInt()
    }catch (e : Exception){
        -1
    }

    println("value is $parsed")

}