package e_oop.c_inheritance

fun main() {
    val rectangle = Rectangle(10.0, 20.0)
    println(rectangle.calArea())

    // abstract class 를 상속받는 open class 를 상속받는 foursquare
    val fourSquare = FourSquare(1000.0)
    println(fourSquare.calArea())
}