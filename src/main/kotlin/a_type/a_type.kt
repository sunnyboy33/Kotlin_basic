package a_type

// 코틀린은 순수 객체지향 프로그래밍 언어 : primitive type 없음.
// 1. Any : 최상위 부모 클래스 (java 에서 Object 에 해당)
// 2. Nothing : 최하위 타입. 절대로 발생할 수 없는 값을 표현
//              Nothing 을 반환하는 함수는 무조건 예외를 던지거나, 영원히 멈추지 않음.
// 3. Unit : void, 리턴값이 없는 함수는 Unit 을 반환
fun main(){
    // val (value) : 수정이 불가능한 변수
    // var (variable) : 변수

    // 숫자형 : Byte, Short, Int, Long, Float, Double
    val xByte: Byte = 1
    val xShort: Short = 10
    val xInt: Int = 100
    val xLong: Long = 10000000000000
    val xFloat: Float = 11.11f
    var xDouble: Double = 110.11
    xDouble = 1000.111 // var 로 선언하면 재할당 가능

    // 문자형 : Char, String
    val xChar: Char = 'A'
    val xString: String = "Hello Kotlin"

    // 논리형 : Boolean
    val xBoolean = true // 타입 지정을 하지 않아도 자동으로 지정
    println(xBoolean::class.simpleName) // 타입명 출력

    // nullable
    // 코틀린의 타입은 기본으로 none null type
    val nullable:String? = null
    // nullable 의 속성에 접근할 때는 .이 아닌 ?.을 써야 한다.
    println(nullable?.length) // ?. : npe 가 아닌 null 을 반환해준다.
    //println(nullable!!.length) // 이렇게 하면 npe 가 터지지만 권장하지 않음.

    // nullable smart cast
//    if (nullable == null) {
//        println(nullable.length) // null 체크를 했기 때문에 length 사용 가능
//    }
}