package e_oop.b_properties

class Coffee(
    // 매개변수
    name:String,
    var price:Int,
    var stock:Int = 0,
    // private : getter/setter 생성하지 않음
    // getter 는 열고 setter 는 닫지만 값을 수정하기 위한 함수는 필요
    private var _totalSalesCnt:Int = 0
) {

    // field : backing field 에 접근하기 위한 키워드
    var name:String? = null
        //get() = name // recursive property accessor. name 에서 name 을 호출하기 때문
        get() = "$field[커피]" // getter
        set(value) {
            // setter 에 예외처리 추가
            if (value.isNullOrBlank()){
                throw IllegalArgumentException()
            }
            field = value
        }

    val totalSalesCnt: Int
        get() = this._totalSalesCnt

    val addTotalSalesCnt = {cnt: Int ->
        this._totalSalesCnt += cnt
    }

    // name 의 getter/setter 를 만들어보자
    init {
        this.name = name
    }

    override fun toString(): String {
        return "Coffee(name='$name', price=$price, stock=$stock, totalSalesCnt=$totalSalesCnt)"
    }

}

fun main() {
    var americano = Coffee("아메리카노", 1000, 0, 100)
    println(americano.name)
    americano.name = "americano"
    println(americano.name)
    americano.addTotalSalesCnt(10)
    println(americano.totalSalesCnt)

}