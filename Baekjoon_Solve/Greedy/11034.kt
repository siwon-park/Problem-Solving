import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.util.*
import java.io.InputStreamReader as InputStreamReader

// 캥거루 세마리2 (11034번)
fun main(args: Array<String>) {
    val br: BufferedReader = BufferedReader(InputStreamReader(System.`in`))
    val bw: BufferedWriter = BufferedWriter(OutputStreamWriter(System.out))

    while (true) {
        val line: String = br.readLine() ?: break
        val st: StringTokenizer = StringTokenizer(line)
        val a: Int = st.nextToken().toInt()
        val b: Int = st.nextToken().toInt()
        val c: Int = st.nextToken().toInt()
        val ans: Int = maxOf(0, b - a - 1, c - b - 1)
        bw.write(ans.toString() + "\n")
    }
    bw.flush()
    bw.close()
    br.close()
}
