package e_oop.g_sealed


enum class OrderFail(code: String, msg: String){
    SOLD_OUT("0000", "재고부족으로 주문이 취소되었습니다."),
    INVALID_SEASON("0001", "판매 시즌이 아닙니다.")
}

// sealed class 들을 상속받는 다른 클래스들
sealed class OrderState {
    data object Pending : OrderState()
    data class OK(val data: String): OrderState()
    data class Fail(val status: OrderFail) : OrderState()
}

// 공통적인 부분은 sealed class 에서, 세분화된 부분은 data object 에서 처리 ??
// data class 와 data object 의 차이?
sealed class Error(val msg:String, val code:String){
    data object StompFail: Error("Stomp 에러입니다.", "2000"){
        val status:String = "DISCONNECT"
    }
    data object HttpFail:Error("Http 에러입니다.", "2000"){
        val statusCode:String = "400"
        val statusMessage:String = "잘못된 요청입니다."
    }
}

fun main() {
    println(OrderState.Pending)
    println(OrderState.OK("아메리카노"))
    println(OrderState.Fail(OrderFail.SOLD_OUT))
    sealedWhen(Error.StompFail)
}

private fun sealedWhen(error: Error) {
    when (error) {
        is Error.HttpFail -> println("Http Error")
        is Error.StompFail -> println("Stomp Error")

    }
}
