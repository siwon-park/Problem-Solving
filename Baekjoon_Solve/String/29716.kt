import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.util.*
import java.io.InputStreamReader as InputStreamReader

// 풀만한문제 (29716번)
fun main(args: Array<String>) {
    val br: BufferedReader = BufferedReader(InputStreamReader(System.`in`))
    val bw: BufferedWriter = BufferedWriter(OutputStreamWriter(System.out))

    val st: StringTokenizer = StringTokenizer(br.readLine())
    val j: Int = st.nextToken().toInt()
    val n: Int = st.nextToken().toInt()
    var ans: Int = 0
    for (i in 0 until n) {
        var score: Int = 0
        val line: String = br.readLine()
        for (w in line) {
            if (w in 'A'..'Z') {
                score += 4
            } else if (w in 'a'..'z' || w in '0'..'9') {
                score += 2
            } else if (w == ' ') {
                score += 1
            }
        }
        if (score <= j) {
            ans += 1
        }
    }

    println(ans)
}

