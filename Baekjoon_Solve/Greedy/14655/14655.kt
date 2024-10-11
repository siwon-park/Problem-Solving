import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.util.StringTokenizer
import kotlin.math.abs
import java.io.InputStreamReader as InputStreamReader

// 욱제는 도박쟁이야!! (14655번)
fun main(args: Array<String>) {
    val br: BufferedReader = BufferedReader(InputStreamReader(System.`in`))
    val bw: BufferedWriter = BufferedWriter(OutputStreamWriter(System.out))

    val n: Int = br.readLine().toInt() // 동전의 개수
    // val arr1: Array<Int> = emptyArray<Int>() // 빈 배열1 선언

    var st: StringTokenizer = StringTokenizer(br.readLine());
    var st2: StringTokenizer = StringTokenizer(br.readLine());
    var ans: Int = 0
    for (i in 0 until n) {
        ans += abs(st.nextToken().toInt());
        ans += abs(st2.nextToken().toInt());
    }

    println(ans)
}
