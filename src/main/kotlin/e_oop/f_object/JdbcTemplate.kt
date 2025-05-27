package e_oop.f_object

// singleton 으로 생성되는 객체
// 생성자를 가질 수 없다.
object JdbcTemplate {
    const val user: String = "admin" // const : 변수를 public static final 로 열어줌
    val password: String = "1234"

    fun connect(){
        println("연결")
    }

    fun commit(){
        println("commit")
    }
}

// 이미 singleton 으로 생성되었기 때문에 인스턴스를 만들 필요가 없음.
fun main() {
    println(JdbcTemplate.user)
    println(JdbcTemplate.password)
    JdbcTemplate.connect()
    JdbcTemplate.commit()
}