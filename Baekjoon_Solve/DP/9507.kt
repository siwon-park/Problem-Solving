import java.io.*;
import java.util.*;

// Generations of Tribbles (9507번)
fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val dp: Array<Long> = Array(68) { 0L }
    dp[0] = 1L
    dp[1] = 1L
    dp[2] = 2L
    dp[3] = 4L
    for (i in 4 until 68) {
        dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3] + dp[i - 4]
    }

    val t = br.readLine().toInt()
    for (i in 0 until t) {
        val n = br.readLine().toInt()
        bw.write("${dp[n]}\n")
    }

    bw.flush()
    bw.close()
    br.close()
}

