package com.akanksha.learningkotlin.advancedConcepts

fun main() {

    val person = MyPerson("Joey", 22)

    println("=== 1. let ===")
    val length = person.name.let {
        println("name = $it")
        it.length
    }
    println("Name length=$length")

    println("\n=== 2. run ===")
    val intro = person.name.run {
        println("Inside run, name=${person.name}, age=${person.age}")
        "Intro: ${person.name}, ${person.age}"
    }
    println(intro)

    println("\n=== 3. apply ===")
    val newP = MyPerson("", 0).apply {
        name = "Sia"
        age = 8
    }
    println("Apply created: $newP")

    println("\n=== 4. also ===")
    val updatedPerson = person.also {
        println("Logging in also: $it")
    }
    println("Also returned: $updatedPerson")

    val res = with(person) {
        println("Inside with: $name, $age")
        "Result=$name-$age"
    }
    println(res)

}

data class MyPerson(var name: String, var age: Int)