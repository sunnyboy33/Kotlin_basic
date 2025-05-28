package g_nullcheck

var name:String? = "cdj"
var cdj:Student? = Student(name)

class Student(
    var name:String? = null,
    var age:Int? = 10
) {

}

fun main() {
    //studySafeCall()
    //studyNonNull() // NPE 발생
    //orElseGet()
    orElseThrow()
//    ifPresent()
//    map()
}

fun studySafeCall(){
    name = "cdj"
    println(name?.length)
    println(cdj?.name)

    name = null
    cdj = null

    println(name?.length)
    println(cdj?.name)
}

// 절대 null 이 아님을 확신할 수 있는 상황에서만 사용
fun studyNonNull(){
    //name = null
    println(name!!.length)

}

// Optional.orElseGet
fun orElseGet(){
    //name = null
    println(name?.length ?: 0)
}

// Optional.orElseThrow
fun orElseThrow(){
    println(name?.length ?: throw NoSuchElementException())
}

// Optional.ifPresent
fun ifPresent(){
    name = "최동준"
    name?.let { println(it) }
}

// Optional.map
fun map(){
    println(name?.map {it.uppercase()})
}