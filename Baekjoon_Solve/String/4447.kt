import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.lang.StringBuilder
import java.util.StringTokenizer
import java.io.InputStreamReader as InputStreamReader

// 좋은놈 나쁜놈 (4447번)
fun main(args: Array<String>) {
    val br: BufferedReader = BufferedReader(InputStreamReader(System.`in`))
    val bw: BufferedWriter = BufferedWriter(OutputStreamWriter(System.out))

    val n: Int = br.readLine().toInt()
    for (i in 0 until n) {
        val name: String = br.readLine()
        var b: Int = 0
        var g: Int = 0
        for (j in 0 until name.length) {
            if (name[j] == 'g' || name[j] == 'G') g += 1
            else if (name[j] == 'b' || name[j] == 'B') b += 1
        }

        if (b == g) {
            bw.write("${name} is NEUTRAL\n")
        } else if (b > g) {
            bw.write("${name} is A BADDY\n")
        } else {
            bw.write("${name} is GOOD\n")
        }
    }

    bw.flush()
    bw.close()
    br.close()
}
