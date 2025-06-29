import java.io.*;
import java.util.*;

// Hamming Distance (31608번)
fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val n = br.readLine().toInt()
    val s = br.readLine()
    val t = br.readLine()
    var ans = 0

    for (i in 0 until n) {
        if (s[i] != t[i]) ans++
    }

    println(ans)

}

