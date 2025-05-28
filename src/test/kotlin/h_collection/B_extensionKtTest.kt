package h_collection

import g_nullcheck.name
import org.junit.jupiter.api.Assertions.*
import kotlin.test.Test

class ExtensionKtTest{
    @Test
    fun testFilter(){
        val numbers = listOf(1,2,3,4,null,8,9,null)
        println("null 제거 : ${numbers.filterNotNull()}")
        println("짝수만 출력 : ${numbers.filterNotNull().filter { it % 2 == 0 }}")
        println("홀수만 출력 : ${numbers.filterNotNull().filterNot { it % 2 == 0 }}")
    }

    @Test
    fun testMap(){
        val names = listOf("홍길동", "신사임당", null, "트럼프")
        val listOfList = mutableListOf(mutableListOf(1,2,3,4), mutableListOf(1,2,3,4))

        println("null 이 아닌 문자열의 길이 ${names.mapNotNull{ it?.length }}")
        println("flat map ${listOfList.flatten()}")
        println("flat map ${listOfList.flatMap {
            it.addLast(10000)
            it
        }}")
    }

    @Test
    fun testFind(){
        val numbers = listOf(1,2,3,4,5)
        println("첫 번째 짝수 : ${numbers.find { it % 2 == 0 }}")
        println("마지막 홀수 : ${numbers.last { it % 2 == 1 }}")
        println("100 보다 큰 수 : ${numbers.firstOrNull { it > 100 } }}")
    }

    @Test
    fun testAggregate(){
        val numbers = listOf(1,2,3,4,5)
        println("짝수의 개수 : ${numbers.count { it % 2 == 0 }}")
        println("합계 : ${numbers.sum()}")
        println("평균 : ${numbers.average()}")
        println("최댓값 : ${numbers.maxOrNull()}")
        println("최솟값 : ${numbers.min()}")
    }

    @Test
    fun testSort(){
        val numbers = listOf(2,7,4,1,8,5)
        data class Coffee(val name:String, val price:Int)
        val coffees = listOf(Coffee("아메리카노", 1000),
            Coffee("모카", 2000),
            Coffee("라떼", 3000))

        println("오름차순 정렬 : ${numbers.sorted()}")
        println("내림차순 정렬 : ${numbers.sortedDescending()}")
        println("이름 순으로 정렬 : ${coffees.sortedBy { it.name }}")
        println("가격 순으로 정렬 : ${coffees.sortedBy { it.price }}")
        println("이름 순으로  오름차순 정렬, 가격으로 내림차순 정렬 : ${coffees.sortedWith{a, b ->
            if (a.name == b.name){
                return@sortedWith b.price.compareTo(a.price)
            }
            a.name.compareTo(b.name)
        }}")
    }

    @Test
    fun testGroupBy(){
        data class Student(val name: String, val grade:String)
        val students = listOf(
            Student("신사임당", "A"),
            Student("홍길동", "B"),
            Student("율곡이이", "B"),
            Student("세종대왕", "A"),
        )

        println("등급별 학생 : ${students.groupBy { it.grade }}")
    }

    @Test
    fun studyCheck(){
        val numbers = listOf(2,4,6,8,10)
        println("모든 숫자가 짝수인가 ? : ${numbers.all { it % 2 == 0 }}")
        println("홀수가 하나라도 있는가 ? : ${numbers.any { it % 2 == 1 }}")
        println("음수가 하나도 없는가 ? : ${numbers.none { it < 0 }}")
    }

    @Test
    fun studyTransform(){
        val numbers = listOf(1,2,3)
        val letters = listOf("A", "B", "C")
        println(numbers.zip(letters)) // 두 리스트를 pair 로 묶어줌

        data class Student(val name: String, val gender: String, val grade:String)
        val students = listOf(
            Student("신사임당", "F", "A"),
            Student("홍길동", "M", "B"),
            Student("율곡이이", "M","B"),
            Student("세종대왕", "M","A"),
        )
        println("이름-등급 : ${students.associate { it.name to it.grade }}")
        println("등급-학생 : ${students.groupBy { it.grade }}")
        println("이름-등급 : ${students.map { it.name }.associateWith { it.length }}")
    }


}