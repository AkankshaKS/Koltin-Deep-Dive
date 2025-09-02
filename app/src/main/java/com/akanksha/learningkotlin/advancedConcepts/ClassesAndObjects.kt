package com.akanksha.learningkotlin.advancedConcepts

fun main() {

    println("=== 1. Basic Class ===")
    val person = Person("John", 25)
    println(person.introduce())

    println("\n=== 2. Secondary Constructor ===")
    val student = Student("Jamie")
    println("Student : ${student.name}, age : ${student.age}")

    println("\n=== 3. Inheritance ===")
    val dog = Dog("max")
    dog.speak()

    println("\n=== 4. Abstract Class ===") //Abstract → is-a + can hold state.
    val circle = Circle(5.0)
    println("circle area: ${circle.area()}") //polymorphism with abstraction

    println("\n=== 5. Interface ===") //Interface → can-do + no real state.
    val car = Car()
    car.stop()
    car.start()

    println("\n=== 6. Data Class ===")
    val user1 = User("Claire", "ak@example.com")
    val user2 = user1.copy(email = "new@ex.com")
    println("User1=$user1")
    println("User2=$user2")
    println("Equals? : ${user1 == user2}")

    println("\n=== 7. Object Singleton ===")
    Database.connect()
    Database.disconnect()

    println("\n=== 8. Companion Object ===")
    println("PI = ${MathUtil.PI}")
    println("Square(4) = ${MathUtil.square(4)}")

    println("\n=== 9. Nested vs Inner Class ===")
    val outer = Outer()
    val nested = Outer.Nested()
    val inner = outer.Inner()
    println("Nested: ${nested.greet()}")
    println("Inner: ${inner.greet()}")

    println("\n=== 10. Sealed Class ===")
    val response: ApiResponse = ApiResponse.Failure("Data loaded Fail")
    when (response) {
        is ApiResponse.Failure -> println("Success: ${response.message}")
        is ApiResponse.Success -> println("Success: ${response.data}")
        ApiResponse.Loading -> println("Loading...")
    }
}

class Person(val name: String, var age: Int) {
    fun introduce() = "Hi my name is $name, and age is $age"
}

class Student(val name: String) {
    var age: Int = 0

    constructor(name: String, age: Int) : this(name) {
        this.age = age
    }
}

open class Animal(val name: String) {
    open fun speak() = println("$name makes a sound")
}

class Dog(name: String) : Animal(name) {

    override fun speak() {
        super.speak()
        println("$name barks")
    }
}

abstract class Shape {
    abstract fun area(): Double
}

class Circle(val radius: Double) : Shape() {
    override fun area(): Double = 5 * 10.0
}

interface Engine {
    fun stop()
    fun start()
}

class Car : Engine {
    override fun stop() = println("Car stopping...")

    override fun start() = println("Car starting...")
}

data class User(var name: String, val email: String)

object Database {
    fun connect() = println("Connected to DB")
    fun disconnect() = println("Disconnected from DB")
}

class MathUtil {

    companion object {
        const val PI = 3.14159
        fun square(x: Int) = x * x
    }
}

class Outer {
    class Nested {
        fun greet() = "Hello from Nested"
    }

    inner class Inner {
        fun greet() = "Hello from Inner (can access Outer)"
    }

}

sealed class ApiResponse {

    data class Success(var data: String) : ApiResponse()
    data class Failure(var message: String) : ApiResponse()
    object Loading : ApiResponse()
}
