package j_coroutine

import kotlinx.coroutines.*
import kotlinx.coroutines.sync.Semaphore
import kotlinx.coroutines.sync.withPermit

fun main() {
    println("main start")
//    studyCoroutine()
//    studyAsync()
//    studyDispatcher()
    studySemaphore()
    println("main end")
}

// runBlocking : 내부 비동기로 동작하는 coroutine 이 종료될 때 까지
// studyCoroutine 함수를 정지
fun studyCoroutine() = runBlocking {
    println("Coroutine 시작")

    val job = launch {
        delay(1000) // 1초 동안 코루틴 일시정지
        println("Coroutine 진행")
    }

    job.join()
    println("Coroutine 종료")
}

fun studyAsync() = runBlocking {

    val deferredSum1 = async {
        delay(1000)
        100 + 200
    }

    val deferredSum2 = async {
        delay(1000)
        200 + 200
    }

    val result1 = deferredSum1.await()
    println("100 + 200 = $result1")
    val result2 = deferredSum2.await()
    println("200 + 200 = $result2")
}

fun studyDispatcher() = runBlocking {
    // CPU 집약적 작업
    launch (Dispatchers.Default){
        println("Default Dispatcher : ${Thread.currentThread().name}")
    }
    // I/O 전용 작업
    launch (Dispatchers.IO){
        println("IO Dispatcher : ${Thread.currentThread().name}")
    }
    launch{
        println("withContext Default Dispatcher : ${Thread.currentThread().name}")
        withContext(Dispatchers.IO){
            println("Unconfined Dispatcher : ${Thread.currentThread().name}")
        }
    }
    // 현재 스레드 시작
    launch (Dispatchers.Unconfined){
        println("Unconfined Dispatcher : ${Thread.currentThread().name}")
        delay(1000)
        println("Unconfined Dispatcher : ${Thread.currentThread().name}")
    }
}

// suspend 키워드 : 사용하지 않으면 delay 사용 불가
suspend fun doWork(id: Int){
    println("worker $id")
    delay(1000)

}

fun studySemaphore() = runBlocking {
    val semaphore = Semaphore(3)
    listOf(1,2,3,4,5,6,7,8,9).forEach {
        launch{
            semaphore.withPermit {
                doWork(it)
            }
        }
    }
}