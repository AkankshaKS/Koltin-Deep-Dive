package com.akanksha.learningkotlin.advancedConcepts

fun main() {

    println("=== 1. Lists (Ordered, Duplicates Allowed) ===")
    val mutableList = mutableListOf(1, 2, 3)
    val immutableList = listOf(10, 20, 30)
    mutableList.add(40)
    println("mutable : $mutableList + immutableList: $immutableList")

    println("\n=== 2. Sets (Unique Elements) ===")
    val mutableSet = mutableSetOf(1, 2, 2, 3)
    val set = setOf(1, 2, 3, 3)
    mutableSet.add(8)
    println("set : $set + mutableSet: $mutableSet")

    println("\n=== 3. Maps (Key-Value Pairs) ===")
    val map = mapOf(1 to "One", 2 to "Two")
    val mutableMap = mutableMapOf("a" to 1, "b" to 2)
    mutableMap["c"] = 3
    println("map : $map + mutableMap: $mutableMap")

    println("\n=== 4. Iteration ===")
    for (item in immutableList) println("iteration: $item")
    println()
    for ((k, v) in mutableMap) println("map iteration: $k -> $v")

    println("\n=== 5. Common List Operations ===")
    val myList = listOf(1, 2, 3, 4, 5, 6)
    println("First : ${myList.first()}")
    println("last : ${myList.last()}")
    println("Contains 3? : ${myList.contains(89)}")
    println("Index of 3 : ${myList.indexOf(11)}")

    println("\n=== 6. map & filter ===")
    val squares = myList.map { it * it }
    val even = myList.filter { it % 2 == 0 }
    println("Squares: $squares")
    println("Evens: $even")

    println("\n=== 7. reduce & fold ===")
    val sumReduce = myList.reduce { acc, value -> acc + value } // add all numbers in list
    val sumFold = myList.fold(100) { acc, value -> acc + value } //add all numbers but take initial value as given
    println("Reduce=$sumReduce, Fold(with init)= $sumFold")

    println("\n=== 8. groupBy & associateBy ===")
    val words = listOf("one", "two", "three", "fourth", "five")
    val grouped = words.groupBy{it.length} //group elements as per length
    val associated = words.associateBy{it.first()} //groups elements, but discard duplicates and keeps the last one
    println("GroupBy length: $grouped")
    println("AssociateBy first char: $associated")

    println("\n=== 9. zip & unzip ===")
    val listA = listOf("a", "b", "c")
    val listB = listOf(1,2,3)
    val zipped = listA.zip(listB) // map list a to list b, o/p as [(a, 1), (b, 2), (c, 3)]
    println("Zipped: $zipped")
    val (unzippedA, unzippedB) = zipped.unzip()
    println("UnzippedA=$unzippedA, B=$unzippedB")

    println("\n=== 10. chunked & windowed ===")
    val letters = ('a' .. 'h').toList()
    println("Chunked size=3: ${letters.chunked(3)}")
    println("Windowed size=3 step=2: ${letters.windowed(3, step=2)}")

    println("\n=== 11. flatten & flatMap ===")
    val nested = listOf(listOf(1,2), listOf(3,4), listOf(5,6), listOf(6))
    println("Flatten: ${nested.flatten()}") // merge multiple lists into one
    println("Flatmap: ${nested.flatMap { it.map { x -> x * 10 }}}") // merge multiple lists into one, but also transform them

    println("\n=== 12. distinct & sorted ===")
    val dupes = listOf(5,2,3,5,1,2)
    println("Distinct: ${dupes.distinct()}") // remove dupliactes
    println("Sorted: ${dupes.sorted()}") //Arrays.sort

    println("\n=== 13. partition ===")
    val (evenNums, oddNums) = myList.partition { it % 2 == 0 }
    println("Evens: $evenNums, Odds: $oddNums")

    println("\n=== 14. any, all, none ===")
    println("Any >4? ${myList.any { it > 4 }}")
    println("All >0? ${myList.all { it > 0 }}")
    println("None <0? ${myList.none { it < 0 }}")

    println("\n=== 15. maxBy/minBy ===")
    println("Longest word: ${words.maxByOrNull { it.length }}")
    println("Shortest word: ${words.minByOrNull { it.length }}")

    println("\n=== 16. associate ===")
    val assoc = myList.associate { it to it * it }
    println("Associate num->square: $assoc")

    println("\n=== 17. withIndex ===")
    for ((index, value) in myList.withIndex()) {
        println("Index=$index, Value=$value")
    }

    println("\n=== 18. Sequences (lazy eval) ===")
    val seqResult = myList.asSequence()
        .map { it * 2 }
        .filter { it > 5 }
        .toList()
    println("Sequence result: $seqResult")


}