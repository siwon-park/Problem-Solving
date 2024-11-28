import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.util.*
import java.io.InputStreamReader as InputStreamReader

// 드높은 남산 위에 우뚝 선 (21965번)
fun main(args: Array<String>) {
    val br: BufferedReader = BufferedReader(InputStreamReader(System.`in`))
    val bw: BufferedWriter = BufferedWriter(OutputStreamWriter(System.out))


    val n: Int = br.readLine().toInt()
    val arr: Array<Int> = Array(n, { 0 })
    var maxVal: Int = 0
    var maxIdx: Int = 0
    val st: StringTokenizer = StringTokenizer(br.readLine())
    for (i in 0 until n) {
        arr[i] = st.nextToken().toInt()
        if (arr[i] >= maxVal) {
            maxVal = arr[i]
            maxIdx = i // 최댓값의 위치
        }
    }

    // 산인 경우: 처음부터 감소, 처음부터 증가, 증가하다가 감소
    var ans: String = "YES"
    if (n >= 2) {
        for (i in 0 until maxIdx) {
            if (arr[i] >= arr[i + 1]) {
                ans = "NO";
            }
        }
        for (i in maxIdx until n - 1) {
            if (arr[i] <= arr[i + 1]) {
                ans = "NO"
            }
        }
    }

    println(ans)
}

