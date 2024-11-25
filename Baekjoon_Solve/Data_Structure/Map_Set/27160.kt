import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.util.*
import kotlin.collections.HashMap
import java.io.InputStreamReader as InputStreamReader

// 할리갈리 (27160번)
fun main(args: Array<String>) {
    val br: BufferedReader = BufferedReader(InputStreamReader(System.`in`))
    val bw: BufferedWriter = BufferedWriter(OutputStreamWriter(System.out))

    val n: Int = br.readLine().toInt()
    val hashMap: HashMap<String, Int> = HashMap()
    for (i in 0 until n) {
        val st: StringTokenizer = StringTokenizer(br.readLine())
        val s: String = st.nextToken()
        val x: Int = st.nextToken().toInt()
        hashMap.computeIfPresent(s) { _, v -> v + x }
        hashMap.putIfAbsent(s, x)
    }

    var flag: Boolean = false
    for (k in hashMap.keys) {
        if (hashMap[k] == 5) {
            flag = true
        }
    }

    if (flag) {
        println("YES")
    } else {
        println("NO")
    }
}

