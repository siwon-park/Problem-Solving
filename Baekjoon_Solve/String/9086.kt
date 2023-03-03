import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.io.InputStreamReader as InputStreamReader


fun main(args: Array<String>) {
    val br: BufferedReader = BufferedReader(InputStreamReader(System.`in`))
    val bw: BufferedWriter = BufferedWriter(OutputStreamWriter(System.out))

    val t: Int = br.readLine().toInt()
    for (i in 1..t) {
        val s: String = br.readLine()
        val n: Int = s.length
        val w1: String = s.get(0) + ""
        val w2: String = s.get(n - 1) + ""
        bw.write(w1 + w2 + "\n")
    }

    bw.flush()
    bw.close()
    br.close()
}