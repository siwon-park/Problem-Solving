import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.util.StringTokenizer
import java.io.InputStreamReader as InputStreamReader

// 카우버거 (15720번)
fun main(args: Array<String>) {
    val br: BufferedReader = BufferedReader(InputStreamReader(System.`in`))
    val bw: BufferedWriter = BufferedWriter(OutputStreamWriter(System.out))

    var st: StringTokenizer = StringTokenizer(br.readLine());

    var b: Int = st.nextToken().toInt() // 버거의 개수
    var c: Int = st.nextToken().toInt() // 사이드 메뉴의 수
    var d: Int = st.nextToken().toInt() // 음료의 개수

    var arr1: Array<Int> = Array(b) { 0 }
    var arr2: Array<Int> = Array(c) { 0 }
    var arr3: Array<Int> = Array(d) { 0 }

    var beforePrice = 0
    st = StringTokenizer(br.readLine())
    for (i in 0 until b) {
        val p = st.nextToken().toInt()
        beforePrice += p
        arr1[i] = p
    }

    st = StringTokenizer(br.readLine())
    for (i in 0 until c) {
        val p = st.nextToken().toInt()
        beforePrice += p
        arr2[i] = p
    }

    st = StringTokenizer(br.readLine())
    for (i in 0 until d) {
        val p = st.nextToken().toInt()
        beforePrice += p
        arr3[i] = p
    }

    bw.write(beforePrice.toString() + "\n")

    arr1.sortDescending()
    arr2.sortDescending()
    arr3.sortDescending()

    // 할인 적용
    var n: Int = minOf(b, c, d)
    var afterPrice = beforePrice
    for (i in 0 until n) {
        afterPrice -= (arr1[i] / 10)
        afterPrice -= (arr2[i] / 10)
        afterPrice -= (arr3[i] / 10)
    }

    bw.write(afterPrice.toString())
    bw.flush()
    bw.close()
    br.close()
}
