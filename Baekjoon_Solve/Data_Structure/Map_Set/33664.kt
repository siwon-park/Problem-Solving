import java.io.*;
import java.util.*;

fun main(args: Array<String>){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    var st: StringTokenizer = StringTokenizer(br.readLine())
    val b: Long = st.nextToken().toLong()
    val n: Int = st.nextToken().toInt()
    val m: Int = st.nextToken().toInt()
    val map: MutableMap<String, Long> = HashMap()
    for (i in 0..n - 1) {
        st = StringTokenizer(br.readLine())
        val item: String = st.nextToken()
        val price: Long = st.nextToken().toLong()
        map[item] = price
    }

    var total: Long = 0
    for (i in 0..m - 1) {
        val target: String = br.readLine()
        total += map[target] ?: 0
    }

    if (total > b) println("unacceptable")
    else println("acceptable")
}
