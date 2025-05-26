package e_oop.a_constructor

// Kotlin 의 Class 는 final class
// 주 생성자 : 클래스 이름 뒤 선언
// getter / setter 자동 생성

// val : getter 만 생성
// var : getter / setter 모두 생성
class Coffee(
    // 매개변수
    name:String,
    price:Int,

    // 클래스 속성 선언
    var stock:Int = 0,
    var totalSalesCnt:Int = 0
) {

    // 매개변수를 사용하고 싶다면 속성 선언을 해주면 된다.
    val name: String
    val price: Int

    // 주 생성자 초기화 블록
    init {
        println("주 생성자 호출")
        println("name : $name")
        println("price : $price")

        this.name = "$name 님"
        this.price = price * 100
    }

    // 부 생성자
    constructor(name:String) : this(name, 0){
        println("부생성자 호출")
    }

    override fun toString(): String {
        return "Coffee(name='$name', price=$price, stock=$stock, totalSalesCnt=$totalSalesCnt)"
    }

}

// java record에서는 기본값 지정이 안되어 불편했는데 kotlin에서는 그 부분이 개선되었음

fun main() {
//    val americano = Coffee("아메리카노", 1000)
    //val americano = Coffee("아메리카노", 1000, 100)
    //val americano = Coffee("아메리카노", 1000, totalSalesCnt = 100)
    val americano = Coffee("아메리카노") // 부 생성자가 있으면 매개변수 한개라도 ok
    println(americano)
    // tool - kotlin - show kotlin bytecode 를 누르면 getter setter 가 생긴 것을 확인가능
}