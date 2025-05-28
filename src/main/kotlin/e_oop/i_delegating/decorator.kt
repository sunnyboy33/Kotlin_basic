package e_oop.i_delegating

abstract class CoffeeDecorator(val target: Drink) : Drink{
    override fun getPrice(): Int {
        return target.getPrice()
    }

    override fun getDesc(): String {
        return target.getDesc()
    }
}

class JavaChip(val decorated: Drink): CoffeeDecorator(decorated){

    // target 에 위임하면 안되는 메서드 : getPrice, getDesc
    override fun getPrice(): Int {
        return decorated.getPrice() + 500
    }

    override fun getDesc(): String {
        return decorated.getDesc() + ", JavaChip"
    }

    override fun addStock(cnt: Int) {
        decorated.addStock(cnt)
    }

    override fun deductStock(cnt: Int) {
        decorated.deductStock(cnt)
    }
}

class Whipping(val decorated: Drink): CoffeeDecorator(decorated){

    // target 에 위임하면 안되는 메서드 : getPrice, getDesc
    override fun getPrice(): Int {
        return decorated.getPrice() + 300
    }

    override fun getDesc(): String {
        return decorated.getDesc() + ", Whipping"
    }

    override fun addStock(cnt: Int) {
        decorated.addStock(cnt)
    }

    override fun deductStock(cnt: Int) {
        decorated.deductStock(cnt)
    }
}

class Milk(val decorated: Drink): CoffeeDecorator(decorated){

    // target 에 위임하면 안되는 메서드 : getPrice, getDesc
    override fun getPrice(): Int {
        return decorated.getPrice() + 1000
    }

    override fun getDesc(): String {
        return decorated.getDesc() + ", Milk"
    }

    override fun addStock(cnt: Int) {
        decorated.addStock(cnt)
    }

    override fun deductStock(cnt: Int) {
        decorated.deductStock(cnt)
    }
}

fun main() {
    var coffee: Drink = Coffee(1000, "아메리카노", 10)
    coffee = CustomCoffee(coffee, Topping.JavaChip)
    coffee = CustomCoffee(coffee, Topping.Milk)
    coffee = CustomCoffee(coffee, Topping.Whipping)
    println("결제 금액 : ${coffee.getPrice()}, ${coffee.getDesc()}")
}