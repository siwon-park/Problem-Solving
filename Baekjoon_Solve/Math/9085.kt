import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.util.StringTokenizer
import java.io.InputStreamReader as InputStreamReader

// 더하기 (9085번)
fun main(args: Array<String>) {
    val br: BufferedReader = BufferedReader(InputStreamReader(System.`in`))
    val bw: BufferedWriter = BufferedWriter(OutputStreamWriter(System.out))

    val tc: Int = Integer.parseInt(br.readLine());
    for (i in 1..tc) {
        val n: Int = Integer.parseInt(br.readLine());
        val st: StringTokenizer = StringTokenizer(br.readLine())
        var sum: Int = 0
        while (st.hasMoreTokens()) {
            sum += Integer.parseInt(st.nextToken())
        }
        bw.write(sum.toString() + "\n")
    }

    bw.flush()
    bw.close()
    br.close()
}
