import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.util.*
import kotlin.math.*
import java.io.InputStreamReader as InputStreamReader

// 창고지기 (31844번)
fun main(args: Array<String>) {
    val br: BufferedReader = BufferedReader(InputStreamReader(System.`in`))
    val bw: BufferedWriter = BufferedWriter(OutputStreamWriter(System.out))

    val line: String = br.readLine()
    var rIdx: Int = 0
    var bIdx: Int = 0
    var gIdx: Int = 0
    for (i in 0 until line.length) {
        if (line[i] == '@') {
            rIdx = i
        } else if (line[i] == '#') {
            bIdx = i
        } else if (line[i] == '!') {
            gIdx = i
        }
    }

    if (!(bIdx in rIdx..gIdx) && !(bIdx in gIdx .. rIdx) ) {
        println(-1)
    } else {
        println(abs(gIdx - bIdx) + abs(rIdx - bIdx) - 1)
    }
}

