package com.akanksha.learningkotlin.advancedConcepts


fun main() {

    println("=== 1. Encapsulation ===")
    val account = BankAccount("Jerry", 1000)
    account.deposit(500)
    println("Account balance : ${account.balance}")

    println("\n=== 2. Polymorphism ===")
    val shapes : List<MyShape> = listOf(Rectangle(4.0,5.0), MyCircle(2.0))
    shapes.forEach { println("Area=${it.area()}") }

    println("\n=== 3. Inheritance vs Composition ===")
    val myCar = MyCar(MyEngine())
    myCar.start()

    println("\n=== 4. Abstract vs Interface ===")
    val cat : MyAnimal = Cat("Jenny")
    cat.speak()

    println("\n=== 5. Delegation ===")
    val printer = SmartPrinter(BasicPrinter())
    printer.print("hello there")

    println("\n=== 6. Open/Final/Override ===")
    val child = Child()
    child.sayHello()




}

/** 1. Encapsulation */
class BankAccount(private val owner: String, initialBalance: Int) {

    var balance: Int = initialBalance
        private set

    fun deposit(amount: Int) {
        balance += amount
    }

    fun withdraw(amount: Int) {
        if (balance >= amount) balance -= amount
    }
}

/* Polymorphism */

abstract class MyShape() {
    abstract fun area(): Double
}

class Rectangle(val w: Double, val h: Double) : MyShape() {
    override fun area() = w * h
}

class MyCircle(val r: Double) : MyShape() {
    override fun area() = Math.PI * r * r
}

/** 3. Inheritance vs Composition */
// Inheritance

open class Vehicle() {
    open fun start() = println("Vehicle starting")
}

class Bike : Vehicle() {
    override fun start() {
        println("Bike starting")
    }
}

// Composition
class MyEngine() {
    fun ignite() = println("Engine started")
}

class MyCar(private val engine: MyEngine) {
    fun start() = engine.ignite()

}

/** 4. Abstract vs Interface */
abstract class MyAnimal(val name: String) { // abstract class can have constructors
    abstract fun speak()

}

class Cat(name: String) : MyAnimal(name) {
    override fun speak() {
        println("$name meows")
    }
}

interface Movable{ //interface class cannot have constructors
    fun move()
}

class Bird() : Movable{
    override fun move() =  println("Bird flying...")

}

/** 5. Delegation */
interface Printer{
    fun print(msg : String)
}

class BasicPrinter : Printer{
    override fun print(msg: String) = println("Printing: $msg")
}

class SmartPrinter(val printer: Printer) : Printer by printer

/** 6. Open/Final/Override */
open class Parent(){
    open fun sayHello() = println("Hello from parent")
}

class Child() : Parent(){
    override fun sayHello() = println("Hello from Child")
}

