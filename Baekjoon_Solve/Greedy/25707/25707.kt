import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.util.StringTokenizer
import java.io.InputStreamReader as InputStreamReader

// 팔찌 만들기 (25707번)
fun main(args: Array<String>) {
    val br: BufferedReader = BufferedReader(InputStreamReader(System.`in`))
    val bw: BufferedWriter = BufferedWriter(OutputStreamWriter(System.out))

    val n: Int = br.readLine().toInt()
    var arr: Array<Int> = Array(n) {0}
    val st: StringTokenizer = StringTokenizer(br.readLine())
    for (i in 0 until n) {
        arr[i] = st.nextToken().toInt()
    }

    arr.sort()
    var ans: Int = 0
    for (i in 1 until n) {
        ans += arr[i] - arr[i - 1]
    }
    ans += arr[n - 1] - arr[0]

    println(ans)

}
