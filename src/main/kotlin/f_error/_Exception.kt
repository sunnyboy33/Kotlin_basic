package f_error

// Kotlin 에는 unchecked Exception 만 존재
class CommonException(val code:String, val msg: String) : Exception(msg)
class DataAccessException(val code: String, val msg: String) : RuntimeException(msg)

fun main() {
    // throwEx()

    val isSuccess = try {
        throw DataAccessException("1111", "fail")
        true
    }catch (ex: DataAccessException) {
        println(ex.msg)
        ex.printStackTrace()
        false
    }finally {
        println("final Block")
    }
    println(isSuccess)
}

fun throwEx(){
    throw CommonException("0000", "fail")

}