import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.lang.Integer.max
import java.util.StringTokenizer
import java.io.InputStreamReader as InputStreamReader

// 항해 (32200번)
fun main(args: Array<String>) {
    val br: BufferedReader = BufferedReader(InputStreamReader(System.`in`))
    val bw: BufferedWriter = BufferedWriter(OutputStreamWriter(System.out))

    var st: StringTokenizer = StringTokenizer(br.readLine())
    val n: Int = st.nextToken().toInt()
    val x: Int = st.nextToken().toInt()
    val y: Int = st.nextToken().toInt()

    var ans1: Int = 0 // 끼니수의 최댓값
    var ans2: Int = 0 // 버리는 크기의 합의 최솟값
    val diff: Int = y - x
    st = StringTokenizer(br.readLine())
    for (i in 0 until n) {
        val a: Int = st.nextToken().toInt()
        val q = a / x
        ans1 += q
        val left: Int = a % x
        ans2 += max(0, left - (q * diff))
    }

    println(ans1)
    println(ans2)
}
