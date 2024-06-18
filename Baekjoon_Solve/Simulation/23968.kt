import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.util.StringTokenizer
import java.io.InputStreamReader as InputStreamReader

// 알고리즘 수업 - 버블 정렬 1 (23968번)
fun main(args: Array<String>) {
    val br: BufferedReader = BufferedReader(InputStreamReader(System.`in`))
    val bw: BufferedWriter = BufferedWriter(OutputStreamWriter(System.out))

    var st = StringTokenizer(br.readLine())
    val N: Int = st.nextToken().toInt()
    val K: Int = st.nextToken().toInt()

    var intArr = br.readLine().split(" ").map { it.toInt() }.toIntArray()

    var k: Int = 0
    for (i in N downTo 1 ) {
        for (j in 0 until i - 1) {
            if (intArr[j] > intArr[j + 1]) {
                var tmp: Int = intArr[j]
                intArr[j] = intArr[j + 1]
                intArr[j + 1] = tmp
                k += 1
                if (k == K) {
                    bw.write("${intArr[j]} ${intArr[j + 1]}")
                }
            }
        }
    }

    if (k < K) {
        bw.write("${-1}")
    }

    bw.flush()
    bw.close()
    br.close()
}
