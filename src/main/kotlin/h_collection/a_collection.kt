package h_collection

fun main() {
    // immutable list
    val list = listOf(1,2,3,4,5)
    val mutableList = mutableListOf<Int>(1,2,3,4,5)

    mutableList.addLast(0)
    println(list)
    println(mutableList)

    println("======================")
    val set = setOf(1,2,3,4,5,6)
    val mutableSet = mutableSetOf(1,2,3,3,4)

    println(set)
    println(mutableSet) // 중복 값 3이 하나만 포함됨
    println("======================")

    val map = mapOf(Pair("name", "cdj"), Pair("age", "100"))
    println(map)
    val ageMap = mutableMapOf("cdj" to 26, "hmd" to 30)
    println(ageMap)
    println(map["name"]) // map 의 get 메서드를 대체
}