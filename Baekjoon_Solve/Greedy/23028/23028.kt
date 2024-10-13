import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.util.StringTokenizer
import kotlin.math.min
import java.io.InputStreamReader as InputStreamReader

// 5학년은 다니기 싫어요 (23028번)
fun main(args: Array<String>) {
    val br: BufferedReader = BufferedReader(InputStreamReader(System.`in`))
    val bw: BufferedWriter = BufferedWriter(OutputStreamWriter(System.out))

    var st: StringTokenizer = StringTokenizer(br.readLine())
    val n: Int = st.nextToken().toInt() // 학기
    var a: Int = st.nextToken().toInt() // 전공 점수
    var b: Int = st.nextToken().toInt() // 총 학점

    var ans: String = "Nae ga wae"
    for (i in 0 until 10) {
        st = StringTokenizer(br.readLine())
        val mjr: Int = min(st.nextToken().toInt(), 6) // 전공
        val mnr: Int = min(st.nextToken().toInt(), 6 - mjr) // 비전공
        a += mjr * 3
        b += (mjr + mnr) * 3
        if (n + i < 8 && a >= 66 && b >= 130) {
            ans = "Nice"
        }
    }

    println(ans)
}
