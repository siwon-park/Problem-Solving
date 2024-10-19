import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.util.*
import java.io.InputStreamReader as InputStreamReader

// 준석이의 사탕 사기 (28062번)
fun main(args: Array<String>) {
    val br: BufferedReader = BufferedReader(InputStreamReader(System.`in`))
    val bw: BufferedWriter = BufferedWriter(OutputStreamWriter(System.out))

    val n: Int = br.readLine().toInt()
    val arr: Array<Int> = Array(n) {0}
    val st: StringTokenizer = StringTokenizer(br.readLine())
    var total: Int = 0;
    for (i in 0 until n) {
        arr[i] = st.nextToken().toInt()
        total += arr[i]
    }

    var ans: Int = 0
    if (total % 2 == 0) {
        ans = total
    } else {
        arr.sort()
        for (i in 0 until n) {
            // 홀수 - 홀수 = 짝수
            if (arr[i] % 2 != 0) {
                total -= arr[i]
                ans = total
                break
            }
        }
    }

    println(ans)
}
