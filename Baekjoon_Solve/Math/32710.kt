import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.util.*
import java.io.InputStreamReader as InputStreamReader

// 구구단표 (32710번)
fun main(args: Array<String>) {
    val br: BufferedReader = BufferedReader(InputStreamReader(System.`in`))
    val bw: BufferedWriter = BufferedWriter(OutputStreamWriter(System.out))

    var n: Int = br.readLine().toInt()
    var flag = false
    if (n in 1..9) {
        flag = true
    } else {
        for (a in 2 .. 9) {
            val b = n / a
            if (b * a == n && b in 1..9) {
                flag = true
            }
        }
    }

    if (!flag) {
        println(0)
    } else {
        println(1)
    }
}

