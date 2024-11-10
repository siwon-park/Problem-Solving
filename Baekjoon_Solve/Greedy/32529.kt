import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.util.*
import java.io.InputStreamReader as InputStreamReader

// 래환이의 여자친구 사귀기 대작전 (32529번)
fun main(args: Array<String>) {
    val br: BufferedReader = BufferedReader(InputStreamReader(System.`in`))
    val bw: BufferedWriter = BufferedWriter(OutputStreamWriter(System.out))

    var st: StringTokenizer = StringTokenizer(br.readLine())
    val n: Int = st.nextToken().toInt()
    val m: Int = st.nextToken().toInt()

    st = StringTokenizer(br.readLine())
    val arr: Array<Int> = Array(n) {i -> st.nextToken().toInt()}
    var ans: Int = -1
    if (arr[n - 1] >= m) {
        ans = n
    } else {
        for (i in n - 2 downTo 0) {
            arr[i] += arr[i + 1]
            if (arr[i] >= m) {
                ans = i + 1
                break
            }
        }
    }

    println(ans)
}

