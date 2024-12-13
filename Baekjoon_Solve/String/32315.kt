import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.util.*
import java.io.InputStreamReader as InputStreamReader

// Cool Phone Numbers (32315번)
fun main(args: Array<String>) {
    val br: BufferedReader = BufferedReader(InputStreamReader(System.`in`))
    val bw: BufferedWriter = BufferedWriter(OutputStreamWriter(System.out))

    val numbers: List<String> = br.readLine().split("-")
    val hashMap: HashMap<Int, Int> = HashMap()
    for (num in numbers) {
        for (n in num) {
            val digit = n.toString().toInt()
            hashMap[digit] = (hashMap[digit] ?: 0) + 1
        }
    }

    println(hashMap.size)
}

