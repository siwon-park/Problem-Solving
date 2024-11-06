import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.util.*
import java.io.InputStreamReader as InputStreamReader

// 핑크빈 레이드 (31712번)
fun main(args: Array<String>) {
    val br: BufferedReader = BufferedReader(InputStreamReader(System.`in`))
    val bw: BufferedWriter = BufferedWriter(OutputStreamWriter(System.out))

    var st: StringTokenizer = StringTokenizer(br.readLine())
    val c1: Int = st.nextToken().toInt()
    val p1: Int = st.nextToken().toInt()

    st = StringTokenizer(br.readLine())
    val c2: Int = st.nextToken().toInt()
    val p2: Int = st.nextToken().toInt()

    st = StringTokenizer(br.readLine())
    val c3: Int = st.nextToken().toInt()
    val p3: Int = st.nextToken().toInt()

    var h: Int = br.readLine().toInt()

    var ans: Int = 0;
    while (h > 0) {
        if (ans % c1 == 0) {
            h -= p1
        }
        if (ans % c2 == 0) {
            h -= p2
        }
        if (ans % c3 == 0) {
            h -= p3
        }
        ans += 1
    }

    println(ans - 1)
}

