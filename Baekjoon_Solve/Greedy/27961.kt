import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.util.*
import java.io.InputStreamReader as InputStreamReader

// 고양이는 많을수록 좋다 (30700번)
fun main(args: Array<String>) {
    val br: BufferedReader = BufferedReader(InputStreamReader(System.`in`))
    val bw: BufferedWriter = BufferedWriter(OutputStreamWriter(System.out))
    /*
    * 현재 k마리의 고양이라고 할 때
    * 0 ~ k마리를 복사할 수 있으니
    * n이 0이 아닐 경우 1을 2의 지수승으로 곱해서 n보다 커질 때까지 곱한 횟수가 정답임
    * n이 0일 경우에는 0
    * */
    var n: Long = br.readLine().toLong()
    var ans: Int = 0
    var cur: Long = 1L
    while (cur < n) {
        cur *= 2
        ans += 1
    }

    if (n != 0L) ans += 1
    println(ans)
}

