import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.util.*
import java.io.InputStreamReader as InputStreamReader

// 강의실 예약 시스템 (30091번)
fun main(args: Array<String>) {
    val br: BufferedReader = BufferedReader(InputStreamReader(System.`in`))
    val bw: BufferedWriter = BufferedWriter(OutputStreamWriter(System.out))

    var st : StringTokenizer = StringTokenizer(br.readLine())
    val n: Int = st.nextToken().toInt()
    val m: Int = st.nextToken().toInt()
    val arr: Array<Int> = Array(n + 1) {0}
    for (i in 0 until m) {
        st = StringTokenizer(br.readLine())
        val k: Int = st.nextToken().toInt()
        val s: Int = st.nextToken().toInt()
        val e: Int = st.nextToken().toInt()
        if (arr[k] <= s) {
            arr[k] = e
            bw.write("YES\n")
        } else {
            bw.write("NO\n")
        }
    }
    bw.flush()
    bw.close()
    br.close()
}
