import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.util.*
import java.io.InputStreamReader as InputStreamReader

// Intuitive Elements (32795번)
fun main(args: Array<String>) {
    val br: BufferedReader = BufferedReader(InputStreamReader(System.`in`))
    val bw: BufferedWriter = BufferedWriter(OutputStreamWriter(System.out))

    val t: Int = br.readLine().toInt()
    for (i in 0 until t) {
        val elmt: String = br.readLine()
        val abbr: String = br.readLine()
        var flag: Boolean = true
        for (w in abbr) {
            if (!elmt.contains(w)) {
                flag = false
                break
            }
        }

        if (flag) {
            println("YES")
        } else {
            println("NO")
        }
    }
}

