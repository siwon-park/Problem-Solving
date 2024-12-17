import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.util.*
import java.io.InputStreamReader as InputStreamReader

// 악수 (8394번)
fun main(args: Array<String>) {
    val br: BufferedReader = BufferedReader(InputStreamReader(System.`in`))
    val bw: BufferedWriter = BufferedWriter(OutputStreamWriter(System.out))

    val n: Int = br.readLine().toInt()
    val dp: Array<Int> = Array(10_000_001) {0}
    dp[1] = 1 // 악수를 안 하는 경우
    dp[2] = 2 // 악수를 안 하는 경우 + 악수를 하는 경우
    for (i in 3..n) {
        dp[i] = (dp[i - 1] + dp[i - 2]) % 10
    }
    println(dp[n])
}

