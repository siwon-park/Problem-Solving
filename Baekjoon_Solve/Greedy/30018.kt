import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.util.*
import java.io.InputStreamReader as InputStreamReader

// 타슈 (30018번)
fun main(args: Array<String>) {
    val br: BufferedReader = BufferedReader(InputStreamReader(System.`in`))
    val bw: BufferedWriter = BufferedWriter(OutputStreamWriter(System.out))


    val n: Int = br.readLine().toInt()
    val st1: StringTokenizer = StringTokenizer(br.readLine())
    val st2: StringTokenizer = StringTokenizer(br.readLine())
    var ans: Int = 0
    for (i in 0 until n) {
        val a: Int = st1.nextToken().toInt()
        val b: Int = st2.nextToken().toInt()
        if (a > b) {
            ans += a - b
        }
    }

    println(ans)
}
