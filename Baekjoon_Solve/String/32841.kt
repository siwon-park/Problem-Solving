import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.util.*
import kotlin.math.abs
import java.io.InputStreamReader as InputStreamReader

// Welcome Sign (32841번)
fun main(args: Array<String>) {
    val br: BufferedReader = BufferedReader(InputStreamReader(System.`in`))
    val bw: BufferedWriter = BufferedWriter(OutputStreamWriter(System.out))

    val st: StringTokenizer = StringTokenizer(br.readLine())
    val r: Int = st.nextToken().toInt()
    val c: Int = st.nextToken().toInt()
    var row: Int = 0
    for (i in 0 until r) {
        val line: String = br.readLine()
        val len: Int = line.length // 문자의 길이
        val diff: Int = abs(len - c)
        if (diff % 2 == 0) {
            bw.write(".".repeat(diff / 2) + line + ".".repeat(diff / 2) + "\n")
        } else {
            row += 1
            if (row % 2 == 0) { // l이 r보다 더 많음
                bw.write(".".repeat((diff / 2) + 1) + line + ".".repeat(diff / 2) + "\n")
            } else {
                bw.write(".".repeat(diff / 2) + line + ".".repeat((diff / 2) + 1) + "\n")
            }
        }
    }

    bw.flush()
    bw.close()
    br.close()
}

