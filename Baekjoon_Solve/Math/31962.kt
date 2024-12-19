import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.util.*
import java.io.InputStreamReader as InputStreamReader

// 등교 (31962번)
fun main(args: Array<String>) {
    val br: BufferedReader = BufferedReader(InputStreamReader(System.`in`))
    val bw: BufferedWriter = BufferedWriter(OutputStreamWriter(System.out))

    var st: StringTokenizer = StringTokenizer(br.readLine())
    val n: Int = st.nextToken().toInt()
    val x: Int = st.nextToken().toInt()
    var ans = -1
    for (i in 0 until n) {
        st = StringTokenizer(br.readLine())
        val s = st.nextToken().toInt()
        val t = st.nextToken().toInt()
        if (s + t <= x) {
            if (ans < s) {
                ans = s
            }
        }
    }

    println(ans)
}

