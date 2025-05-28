package b_operator

data class User(
    val email: String,
    val password:String
){

    // 리턴타입으로 뭐가 올지 모르기 때문에 Any
    operator fun get(key: String):Any?{
        return User::class.members.find { it.name == key }?.call(this)
    }

}

fun main() {
    val user = User(email = "cdj@grepp.com", password = "1234")
    println(user["email"])
}