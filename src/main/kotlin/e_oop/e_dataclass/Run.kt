package e_oop.e_dataclass

// data class 값을 저장하기 위한 class
// toString, equals, hashCode, 구조분해할당이 가능
// 반드시 주 생성자의 매개변수가 1개 이상 있어야 한다.
// final class 로만 사용 가능
// record 같은 용도로 사용. 그치만 자바랑은 다르다.

// 딴건 몰라도 Controller 만큼은 Kotlin 으로 할 때 쾌적함이 다르다.
data class User(
    val email: String,
    val password: String
)

fun main(){
    val test = User("test@grepp.com", "1234")
    // Kotlin 에서도 메모리를 더 차지하더라도 copy 를 사용해서
    // 원본 객체를 변하게 하지 말 것을 권장한다.
    val test2 = test.copy()
    val admin = test.copy(email = "admin@grepp.com")

    // toString
    println(test)

    // 값 기반 비교로 equals override
    println(test == test2)

    // 값 기반으로 hashCode override
    println(test.hashCode())
    println(test2.hashCode())

    // copy() : 불변성을 유지하며 값을 변경
    println(admin)

    // componentN() : 구조분해할당
    val (email, password) = admin // for 문에서도 사용했던 거랑 같음
    println("email: $email, password: $password")

}