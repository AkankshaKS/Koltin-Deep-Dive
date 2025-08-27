package com.akanksha.learningkotlin.advancedConcepts

fun main() {

    println("=== 1. Basic Lambda ===")
    val greet: () -> Unit = { println("hello greet") }
    greet()

    println("\n=== 2. Lambda with Parameters ===")
    val add: (Int, Int) -> Int = { x, y -> x + y }
    println("add : ${add(4, 6)}")

    println("\n=== 3. Implicit 'it' ===")
    val lengths = listOf("a", "bb", "ccc").map { it.length }
    println("it length : $lengths")

    println("\n=== 4. Higher Order Function with Lambda ===")
    fun operate(a: Int, b: Int, op: (Int, Int) -> Int): Int {
        return op(a, b)
    }
    println("hof ${operate(2, 3) { x, y -> x + y }}")

    println("\n=== 5. Trailing Lambda ===")
    val nums = listOf(1, 2, 3)
    nums.forEach { println(it) }

    fun isEven(n: Int) = n % 2 == 0
    val evens = nums.filter(::isEven)
    println("is even : $evens")

    println("\n=== 7. Anonymous Function vs Lambda ===")
    val lambda = { x: Int, y: Int -> x + y }
    val anon = fun(x: Int, y: Int): Int { return x + y }
    println("lambda : ${lambda(2, 3)} and anon : ${anon(2, 3)}")

    println("\n=== 8. Local Return in Lambda ===")
    nums.forEach {
        if(it == 2) return@forEach
        println("Processed: $it")
    }

}