import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.lang.StringBuilder
import java.util.StringTokenizer
import java.io.InputStreamReader as InputStreamReader

// 진짜 공간 (1350번)
fun main(args: Array<String>) {
    val br: BufferedReader = BufferedReader(InputStreamReader(System.`in`))
    val bw: BufferedWriter = BufferedWriter(OutputStreamWriter(System.out))

    val n: Int = br.readLine().toInt()
    val st: StringTokenizer = StringTokenizer(br.readLine())
    val cluster: Int = br.readLine().toInt()

    var totalSize: Long = 0
    while (st.hasMoreTokens()) {
        val size: Int = st.nextToken().toInt()
        if (cluster >= size && size != 0) {
            totalSize += cluster
        } else if (cluster < size) {
            if (size % cluster == 0) {
                totalSize += (size / cluster).toLong() * cluster
            } else {
                totalSize += ((size / cluster) + 1).toLong() * cluster
            }
        }
    }

    bw.write(totalSize.toString())
    bw.flush()
    bw.close()
}
