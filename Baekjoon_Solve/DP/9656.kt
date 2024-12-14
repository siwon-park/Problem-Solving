import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.util.*
import java.io.InputStreamReader as InputStreamReader

// 돌 게임 2 (9656번)
fun main(args: Array<String>) {
    val br: BufferedReader = BufferedReader(InputStreamReader(System.`in`))
    val bw: BufferedWriter = BufferedWriter(OutputStreamWriter(System.out))
    val SK: String = "SK"
    val CY: String = "CY"
    // dp[i] = 돌이 i개일 때 i번째 돌을 집는 사람
    val dp: Array<String?> = Array(1001) { null }
    dp[1] = SK
    dp[2] = CY
    for (i in 3 until 1001) {
        if (dp[i - 1] == CY) dp[i] = SK
        else if (dp[i - 1] == SK) dp[i] = CY
    }

    val n: Int = br.readLine().toInt()
    if (dp[n] == CY) println(SK)
    else println(CY)
}

