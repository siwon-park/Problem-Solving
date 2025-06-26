import java.io.*;
import java.util.*;

// /gg (34032번)
fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val n: Int = br.readLine().toInt()
    val s: String = br.readLine()
    var cnt: Int = 0
    for (i in 0 until n) {
        if (s[i] == 'O') {
            cnt++
        }
    }

    val half = if (n % 2 == 0) n / 2 else (n / 2) + 1

    if (cnt >= half) {
        bw.write("Yes")
    } else {
        bw.write("No")
    }

    bw.flush()
    br.close()
    bw.close()
}

