import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.util.StringTokenizer
import java.io.InputStreamReader as InputStreamReader

// 장신구 명장 임스 (25496번)
fun main(args: Array<String>) {
    val br: BufferedReader = BufferedReader(InputStreamReader(System.`in`))
    val bw: BufferedWriter = BufferedWriter(OutputStreamWriter(System.out))

    var st: StringTokenizer = StringTokenizer(br.readLine())
    var p: Int = st.nextToken().toInt()
    val n: Int = st.nextToken().toInt()

    val arr: Array<Int> = Array(n) {0}
    st = StringTokenizer(br.readLine())
    for (i in 0 until n) {
        arr[i] = st.nextToken().toInt()
    }

    arr.sort()

    var cnt = 0;
    for (i in 0 until n) {
        if (p < 200) { // 체력이 200 미만일 경우에만
            cnt += 1;
            p += arr[i]
        } else {
            break
        }
    }

    println(cnt)
}
