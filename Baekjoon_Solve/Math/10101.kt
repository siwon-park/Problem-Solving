import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.io.InputStreamReader as InputStreamReader

fun main(args: Array<String>) {
    val br: BufferedReader = BufferedReader(InputStreamReader(System.`in`))
    val bw: BufferedWriter = BufferedWriter(OutputStreamWriter(System.out))

    val a: Int = br.readLine().toInt()
    val b: Int = br.readLine().toInt()
    val c: Int = br.readLine().toInt()

    if (a == 60 && b == 60 && c == 60) {
        bw.write("Equilateral")
    } else if (a + b + c == 180 && (a == b || a == c || b == c)) {
        bw.write("Isosceles")
    } else if (a + b + c == 180 && a != b && a != c && b != c) {
        bw.write("Scalene")
    } else {
        bw.write("Error")
    }

    bw.flush()
    br.close()
    bw.close()
}
