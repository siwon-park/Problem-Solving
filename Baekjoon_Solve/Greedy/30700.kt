import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.util.*
import java.io.InputStreamReader as InputStreamReader

// KOREA 문자열 만들기 (30700번)
fun main(args: Array<String>) {
    val br: BufferedReader = BufferedReader(InputStreamReader(System.`in`))
    val bw: BufferedWriter = BufferedWriter(OutputStreamWriter(System.out))

    val line: String = br.readLine()
    var ans: Int = 0
    var sb: StringBuilder = StringBuilder()

    var last: Char = ' '
    for (w in line) {
        if (last == ' ' && w == 'K') {
            sb.append(w)
            last = w
        } else if (last == 'K' && w == 'O') {
            sb.append(w)
            last = w
        } else if (last == 'O' && w == 'R') {
            sb.append(w)
            last = w
        } else if (last == 'R' && w == 'E') {
            sb.append(w)
            last = w
        } else if (last == 'E' && w == 'A') {
            sb.append(w)
            last = ' '
        }
    }

    ans = sb.toString().length
    println(ans)
}
