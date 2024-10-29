import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.util.*
import kotlin.math.*
import java.io.InputStreamReader as InputStreamReader

// ZOAC 2 (18238번)
fun main(args: Array<String>) {
    val br: BufferedReader = BufferedReader(InputStreamReader(System.`in`))
    val bw: BufferedWriter = BufferedWriter(OutputStreamWriter(System.out))

    val line: String = br.readLine()
    var ans: Int = 0
    var cur: Int = 0
    for (w in line) {
        val target: Int = w - 'A'
        ans += min(abs(cur - target), abs(26 - abs(cur - target)))
        cur = target
    }

    println(ans)
}

