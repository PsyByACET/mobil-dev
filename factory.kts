package com.example.myapplication
//главный класс человек
interface People {
    public fun goShop() {
        println("I go shop")
    }
}
//Классы наследники Человек покупающий молоко и человек покупающий шоколад, они наследуются от класса родителя и использюет его свойства.
class PeopleBuyMilk: People {
    override fun buy() {
        println("I buy milk")
    }
}
class PeopleBuyChocolate: People {
    override fun buy() {
        println("I buy chocolate")
    }
}
class PeopleFactory {
    fun makePeople(type: PeopleType): People? {
        return when(type) {
            People.BuyMilk -> MilkBuyPeople()
            PeopleType.BuyChocolate -> ChocolateBuyPeople()
            else -> null
        }
    }
}
fun main() {
    val factory = PeopleFactory()
    val people = factory.makePeople(PeopleType.BuyMilk)
    people?.goShop()
    people?.buy()
}
//набор классов
enum class StudentType {
    BuyMilk,
    BuyChocolate
}

// Паттерн фабрика это порождающий паттерн. В нём создается один класс или интерфейс, 
//от которого после наследуются подклассы с расширенными им свойствами.
