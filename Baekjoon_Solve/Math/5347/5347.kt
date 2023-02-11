import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.util.StringTokenizer
import java.io.InputStreamReader as InputStreamReader

// 최대 공약수
fun gcd(a: Long, b: Long): Long {
    var num1 = a
    var num2 = b
    while (num2 > 0) {
        var tmp = num1 % num2
        num1 = num2
        num2 = tmp
    }
    return num1
}

// 최소 공배수
fun lcm(a: Long, b: Long): Long {
    return a * b / gcd(a, b)
}

fun main(args: Array<String>) {
    val br: BufferedReader = BufferedReader(InputStreamReader(System.`in`))
    val bw: BufferedWriter = BufferedWriter(OutputStreamWriter(System.`out`))
    var st: StringTokenizer

    val t: Int = br.readLine().toInt() // 테스트 케이스
    for (tc in 1..t) {
        st = StringTokenizer(br.readLine())
        val a = st.nextToken().toLong()
        val b = st.nextToken().toLong()
        val ret = lcm(a, b)
        bw.write(ret.toString() + "\n")
    }
    bw.flush()
    bw.close()
    br.close()
}
