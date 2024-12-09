import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.util.*
import java.io.InputStreamReader as InputStreamReader

// Snacks within 300 Yen (32046번)
fun main(args: Array<String>) {
    val br: BufferedReader = BufferedReader(InputStreamReader(System.`in`))
    val bw: BufferedWriter = BufferedWriter(OutputStreamWriter(System.out))

    while (true) {
        val n: Int = br.readLine().toInt()
        if (n == 0) {
            break;
        }
        val st: StringTokenizer = StringTokenizer(br.readLine())
        var sum: Int = 0
        for (i in 0 until n) {
            val a: Int = st.nextToken().toInt()
            if (sum + a <= 300) {
                sum += a;
            }
        }
        bw.write(sum.toString() + "\n");
    }

    bw.flush()
    bw.close()
    br.close()
}

