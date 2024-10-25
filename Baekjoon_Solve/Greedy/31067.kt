import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.util.*
import java.io.InputStreamReader as InputStreamReader

// 다오의 경주 대회 (31067번)
fun main(args: Array<String>) {
    val br: BufferedReader = BufferedReader(InputStreamReader(System.`in`))
    val bw: BufferedWriter = BufferedWriter(OutputStreamWriter(System.out))

    var st: StringTokenizer = StringTokenizer(br.readLine())
    val n: Int = st.nextToken().toInt()
    val k: Int = st.nextToken().toInt()

    st = StringTokenizer(br.readLine())
    var ans: Int = 0
    var last: Int = st.nextToken().toInt()
    for (i in 1 until n) {
        val a: Int = st.nextToken().toInt()
        if (last >= a) {
            if (a + k > last) {
                last = a + k
                ans += 1
            } else {
                ans = -1
                break
            }
        } else {
            last = a
        }
    }

    println(ans)
}
