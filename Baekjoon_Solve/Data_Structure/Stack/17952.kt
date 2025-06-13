import java.io.*;
import java.util.*;

// 과제는 끝나지 않아! (17952번)
fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val n: Int = br.readLine().toInt()
    var st: StringTokenizer
    var score: Int = 0
    var stack: Stack<Pair> = Stack();
    for (i in 0 until n) {
        st = StringTokenizer(br.readLine())
        val x: Int = st.nextToken().toInt()
        if (x == 1) {
            val a: Int = st.nextToken().toInt()
            var t: Int = st.nextToken().toInt()
            if (t - 1 > 0) {
                stack.push(Pair(a, t - 1))
            } else {
                score += a
            }
        } else {
            if (stack.isEmpty()) continue
            var pair: Pair = stack.pop()
            if (pair.t - 1 > 0) {
                pair.t -= 1
                stack.push(pair)
            } else {
                score += pair.a
            }
        }
    }

    println(score)
}

class Pair(var a: Int, var t: Int) {
}
