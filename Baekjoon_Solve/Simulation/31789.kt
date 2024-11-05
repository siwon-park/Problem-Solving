import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.util.*
import kotlin.math.*
import java.io.InputStreamReader as InputStreamReader

// 모험의 시작 (31789번)
fun main(args: Array<String>) {
    val br: BufferedReader = BufferedReader(InputStreamReader(System.`in`))
    val bw: BufferedWriter = BufferedWriter(OutputStreamWriter(System.out))

    val n: Int = br.readLine().toInt()
    var st: StringTokenizer = StringTokenizer(br.readLine())
    val x: Int = st.nextToken().toInt()
    val s: Int = st.nextToken().toInt()

    var ans: String = "NO"
    for (i in 0 until n) {
        st = StringTokenizer(br.readLine())
        val c: Int = st.nextToken().toInt()
        val p: Int = st.nextToken().toInt()
        if (c <= x && p > s) {
            ans = "YES"
        }
    }

    println(ans)
}

