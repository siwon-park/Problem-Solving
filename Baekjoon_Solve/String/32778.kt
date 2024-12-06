import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.util.*
import java.io.InputStreamReader as InputStreamReader

// 가희와 부역명 (32778번)
fun main(args: Array<String>) {
    val br: BufferedReader = BufferedReader(InputStreamReader(System.`in`))
    val bw: BufferedWriter = BufferedWriter(OutputStreamWriter(System.out))

    val str: String = br.readLine()
    val list: List<String> = str.split(" (")
    if (list.size <= 1) {
        println(list[0])
        println("-")
    } else {
        println(list[0])
        println(list[1].substring(0, list[1].length - 1))
    }
}

