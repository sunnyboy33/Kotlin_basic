package e_oop.i_delegating

sealed class Topping(val name: String, val price: Int){
    data object Milk:Topping("Milk", 300)
    data object JavaChip:Topping("JavaChip", 500)
    data object Whipping:Topping("Whipping", 1000)
}
// Drink by coffee
// 직접 override 하지 않는 Drink 인터페이스의 메서드는 coffee 에게 위임
class CustomCoffee(val coffee: Drink, val topping: Topping): Drink by coffee {
    override fun getPrice(): Int {
        return coffee.getPrice() + topping.price
    }

    override fun getDesc(): String {
        return "${coffee.getDesc()}, ${topping.name}"
    }
}

// 코틀린에서 기본적으로 class 가 final인 이유. 상속 계층은 냅두고 확장함수를 지원하기 때문이다.