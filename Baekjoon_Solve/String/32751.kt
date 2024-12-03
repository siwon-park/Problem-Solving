import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.util.*
import java.io.InputStreamReader as InputStreamReader

// 햄버거 (32751번)
fun main(args: Array<String>) {
    val br: BufferedReader = BufferedReader(InputStreamReader(System.`in`))
    val bw: BufferedWriter = BufferedWriter(OutputStreamWriter(System.out))

    val n: Int = br.readLine().toInt()
    val st: StringTokenizer = StringTokenizer(br.readLine())
    var a: Int = st.nextToken().toInt()
    var b: Int = st.nextToken().toInt()
    var c: Int = st.nextToken().toInt()
    var d: Int = st.nextToken().toInt()

    val s: String = br.readLine()
    var flag = true

    // 가장 위, 아래 재료가 빵인지 확인
    if (s[0] != 'a' || s[n - 1] != 'a') {
        flag = false
    }

    // 인접한 재료가 같은지 확인
    for (i in 1 until n) {
        if (s[i - 1] == s[i]) {
            flag = false
        }
        // 재료를 제대로 사용했는지 확인
        if (s[i] == 'a') {
            a -= 1
        } else if (s[i] == 'b') {
            b -= 1
        } else if (s[i] == 'c') {
            c -= 1
        } else if (s[i] == 'd') {
            d -= 1
        }
    }

    // 0번 인덱스에 대해 확인
    if (s[0] == 'a') {
        a -= 1
    } else if (s[0] == 'b') {
        b -= 1
    } else if (s[0] == 'c') {
        c -= 1
    } else if (s[0] == 'd') {
        d -= 1
    }

    if (a < 0 || b < 0 || c < 0 || d < 0) {
        flag = false
    }

    if (flag) {
        println("Yes")
    } else {
        println("No")
    }
}

