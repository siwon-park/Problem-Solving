import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.util.*
import java.io.InputStreamReader as InputStreamReader

// Adding Trouble (31654번)
fun main(args: Array<String>) {
    val br: BufferedReader = BufferedReader(InputStreamReader(System.`in`))
    val bw: BufferedWriter = BufferedWriter(OutputStreamWriter(System.out))

    val st: StringTokenizer = StringTokenizer(br.readLine())
    val a: Int = st.nextToken().toInt()
    val b: Int = st.nextToken().toInt()
    val c: Int = st.nextToken().toInt()
    if (a + b == c) {
        println("correct!")
    } else {
        println("wrong!")
    }
}

