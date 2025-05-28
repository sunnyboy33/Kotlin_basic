package d_function

import kotlin.time.times

fun main() {
//    println(add(100, 200))
//    println(sub(200, 100))
//    println(divide(30.5,10.3))
//    println(printNumber(1000)) // 아무것도 반환되지 않을 때 Unit 이 반환됨

    // 마지막 매개변수가 함수 타입일 경우
    //println(filter(listOf(1,2,3,4,5,6,7,8,9)) { e: Int -> e % 2 == 0 })
    // it : 람다의 매개변수가 1개일 경우 사용할 수 있는 암시적 이름
//    println(filter(listOf(1,2,3,4,5,6,7,8,9)) { it % 2 == 0 })
//    println(map(listOf(1,2,3,4,5,6,7,8,9)) {"$it 번!!"})
//    println(map(listOf(1,2,3,4,5,6,7,8,9)) {it * 100})
//    println(reduce(listOf(1,2,3,4,5,6,7,8,9)) {acc:Int, e:Int -> acc+e})
    println(reduce(listOf(1,2,3,4,5,6,7,8,9)) {acc:Int, e:Int -> acc * e})
}

fun add(a:Int, b:Int):Int {
    return a + b
}

// Kotlin 의 함수는 1급 객체
// First class Object : 다른 객체들에 일반적으로 적용 가능한 연산을 모두 지원하는 객체
// 즉, 함수를 데이터 다루듯이 쓸 수 있다는 것
val sub = fun (a:Int, b:Int):Int{
    return a - b
}

// 람다 표현식으로 표현한 함수
// 함수타입이 추론 가능한 경우
val divide = {a:Double, b:Double ->
    println(a)
    println(b)
    a/b
}

// 타입 추론이 불가능한 경우
// 내가 작성한 람다표현식이 어떤 값을 받아서 어떤 값을 출력하는지 표현
val divideType: (a: Double, b: Double) -> Double = {a, b -> a/b}

val printNumber = {a: Int ->
    println(a)
}

// filter 구현
fun <E> filter(list: List<E>, callback:(e:E) -> Boolean) : MutableList<E> {
    val res = mutableListOf<E>()
    //list.forEach {e: E -> if (callback(e)) res.addLast(e)}
    list.forEach {if (callback(it)) res.addLast(it)} // 여기에도 it 적용 가능
    return res
}

// map 구현. 입력 타입과 출력 타입이 다를 수 있기 때문에 2개의 제네릭 사용
fun <E, T> map(list: List<E>, callback: (e:E) -> T) : MutableList<T> {
    val res = mutableListOf<T>()
    list.forEach{e:E -> res.add(callback(e))}
    return res
}

// Reduce
fun <E> reduce(list: List<E>, operation: (acc:E, E) -> E) : E {
    var acc = list[0]
    list.drop(1).forEach { e:E -> acc = operation(acc, e) }
    return acc
}