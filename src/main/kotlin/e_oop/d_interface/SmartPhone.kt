package e_oop.d_interface

class SmartPhone: HTTPS, SMTP {
    override fun request() {
        println("HTTPS Request")
    }

    override fun response() {
        println("HTTPS Response")
    }

    override fun process() {
        //super<HTTPS>.process()
        super<SMTP>.process() // 둘 중 하나 선택 혹은 둘다 가능.
        //println("HTTPS 통신 진행 중 입니다.")
    }

    override fun encrypt() {
        println("암호화")
    }

}