import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.util.*
import kotlin.math.min
import java.io.InputStreamReader as InputStreamReader

// 온데간데없을뿐더러 (31833번)
fun main(args: Array<String>) {
    val br: BufferedReader = BufferedReader(InputStreamReader(System.`in`))
    val bw: BufferedWriter = BufferedWriter(OutputStreamWriter(System.out))

    var n: Int = br.readLine().toInt()
    val st1: StringTokenizer = StringTokenizer(br.readLine())
    val st2: StringTokenizer = StringTokenizer(br.readLine())

    var a: StringBuilder = StringBuilder()
    var b: StringBuilder = StringBuilder()
    for (i in 0 until n) {
        a.append(st1.nextToken())
        b.append(st2.nextToken())
    }

    println(min(a.toString().toLong(), b.toString().toLong()))

}

