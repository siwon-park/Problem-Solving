import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.util.*
import java.io.InputStreamReader as InputStreamReader

// 자작나무가 없소~ (31496번)
fun main(args: Array<String>) {
    val br: BufferedReader = BufferedReader(InputStreamReader(System.`in`))
    val bw: BufferedWriter = BufferedWriter(OutputStreamWriter(System.out))

    val st: StringTokenizer = StringTokenizer(br.readLine())
    val n: Int = st.nextToken().toInt()
    val s: String = st.nextToken()

    val arr: Array<String?> = arrayOfNulls<String>(n)
    for (i in 0 until n) {
        arr[i] = br.readLine()
    }

    var ans: Int = 0
    for (i in 0 until n) {
        // 코틀린의 split은 자바의 split과 달리 regex가 아니라 delimiters이다
        val tmp: List<String> = arr[i].toString().split(" ")
        val words: List<String> = tmp[0].split("_") // "\\_"로 넣으면 "\_"으로 파싱함
        val cnt: Int = tmp[1].toInt()
        for (word in words) {
            if (word.equals(s)) {
                ans += cnt
                break
            }
        }
    }
    println(ans)
}

