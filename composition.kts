
/** "Composite" */
class Composite (name: String) : Equipment(price: 0) {
    val equipments = ArrayList<Equipment>()

    fun add(equipment: Equipment) {
        this.equipments.add(equipment)
    }
    override fun getPrice(): Int {
        this.equipments.map { it.getPrice() }.sum()
    }
}

//leafs
class ShopPyaterochka : Composite(name: "pyaterochka")
class Milk : Composite(name: "Milk", price 55)
class Chocolate : Composite(name: "Chocolate", price 69)
class Chicken : Composite(name: "Chicken", price 200)
class Bread : Composite(name: "Bread", price 29)
class Salt : Composite(name: "Salt", price 33)

val pyaterochka = ShopPyaterochka()
pyaterochka.add(Milk())
pyaterochka.add(Chocolate())
pyaterochka.add(Chicken())
pyaterochka.add(Bread())
pyaterochka.add(Salt())

//Компоновщик это структурный паттерн проектирования, который позволяет сгруппировать множество объектов в древовидную структуру, 
//а затем работать с ней так, как будто это единичный объект.