package i_io

import java.io.File

fun main() {
    val fileName = "file/byteIO.txt"
    val byteData = "Hello Kotlin Byte IO".toByteArray()

    val file = File(fileName)
    file.writeBytes(byteData)
    println(file.readBytes().contentToString())
}