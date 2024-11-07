import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.util.*
import java.io.InputStreamReader as InputStreamReader

// 서울사이버대학을 다니고 (30958번)
fun main(args: Array<String>) {
    val br: BufferedReader = BufferedReader(InputStreamReader(System.`in`))
    val bw: BufferedWriter = BufferedWriter(OutputStreamWriter(System.out))

    val n: Int = br.readLine().toInt()
    val line: String = br.readLine()

    val hashMap: HashMap<Char, Int> = hashMapOf()
    var ans: Int = 0
    for (w in line) {
        if (w in 'a'..'z') {
            if (!hashMap.containsKey(w)) {
                hashMap[w] = 1
            } else {
                hashMap[w] = hashMap[w]!! + 1
            }
            if (hashMap[w]!! > ans) {
                ans = hashMap[w]!!
            }
        }
    }

    println(ans)
}

