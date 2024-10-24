import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.util.*
import java.io.InputStreamReader as InputStreamReader

// 첨탑 밀어서 부수기 (28014번)
fun main(args: Array<String>) {
    val br: BufferedReader = BufferedReader(InputStreamReader(System.`in`))
    val bw: BufferedWriter = BufferedWriter(OutputStreamWriter(System.out))

    val n: Int = br.readLine().toInt()
    val st: StringTokenizer = StringTokenizer(br.readLine())
    var ans: Int = 0
    var cur: Int = 0
    for (i in 0 until n) {
        val h: Int = st.nextToken().toInt()
        if (cur <= h) {
            ans += 1
        }
        cur = h
    }

    println(ans)
}
