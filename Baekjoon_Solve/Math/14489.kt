import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.util.StringTokenizer
import java.io.InputStreamReader as InputStreamReader

// 치킨 두 마리 (...) (14489번)
fun main(args: Array<String>) {
    val br: BufferedReader = BufferedReader(InputStreamReader(System.`in`))
    val bw: BufferedWriter = BufferedWriter(OutputStreamWriter(System.out))

    val st: StringTokenizer = StringTokenizer(br.readLine());
    val a: Int = st.nextToken().toInt()
    val b: Int = st.nextToken().toInt()
    val c: Int = br.readLine().toInt()

    if (a + b >= 2 * c) {
        bw.write((a + b - 2 * c).toString())
    } else {
        bw.write((a + b).toString())
    }

    bw.flush()
    br.close()
    bw.close()
}
