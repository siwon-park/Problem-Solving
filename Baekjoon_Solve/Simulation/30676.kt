import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.util.*
import java.io.InputStreamReader as InputStreamReader

// 이 별은 무슨 색일까 (30676번)
fun main(args: Array<String>) {
    val br: BufferedReader = BufferedReader(InputStreamReader(System.`in`))
    val bw: BufferedWriter = BufferedWriter(OutputStreamWriter(System.out))

    val n: Int = br.readLine().toInt()
    if (n in 380..424) {
        println("Violet")
    } else if (n in 425..449) {
        println("Indigo")
    } else if (n in 450..494) {
        println("Blue")
    } else if (n in 495..569) {
        println("Green")
    } else if (n in 570..589) {
        println("Yellow")
    } else if (n in 590..619) {
        println("Orange")
    } else if (n in 620..780) {
        println("Red")
    }
}

