import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.util.*
import kotlin.math.max
import java.io.InputStreamReader as InputStreamReader

// Tracks in the Snow (6292번)
fun main(args: Array<String>) {
    val br: BufferedReader = BufferedReader(InputStreamReader(System.`in`))
    val bw: BufferedWriter = BufferedWriter(OutputStreamWriter(System.out))

    val st: StringTokenizer = StringTokenizer(br.readLine())
    val h: Int = st.nextToken().toInt() // 높이
    val w: Int = st.nextToken().toInt() // 너비

    val graph: Array<String> = Array(h) { "" }
    for (i in 0 until h) {
        graph[i] = br.readLine()
    }

    val dy: IntArray = intArrayOf(-1, 0, 1, 0)
    val dx: IntArray = intArrayOf(0, 1, 0, -1)
    val deque: Deque<Array<Int>> = ArrayDeque()
    val visited: Array<Array<Int>> = Array(h) {Array(w) {0} }
    visited[0][0] = 1
    var tmp: Array<Int> = Array(2) {0}
    deque.add(tmp)
    var ans: Int = 0
    while (!deque.isEmpty()) {
        val pair: Array<Int> = deque.pollFirst()
        val y: Int = pair[0]
        val x: Int = pair[1]
        val cur: Char = graph[y][x]
        ans = max(ans, visited[y][x])
        for (k in 0 until 4) {
            val ny: Int = y + dy[k]
            val nx: Int = x + dx[k]
            if (ny < 0 || ny >= h || nx < 0 || nx >= w || graph[ny][nx] == '.' || visited[ny][nx] != 0) continue
            tmp = Array(2) { 0 }
            tmp[0] = ny
            tmp[1] = nx
            if (graph[ny][nx] == cur) { // 현재 동물과 같다면
                visited[ny][nx] = visited[y][x]
                deque.addFirst(tmp)
            } else { // 현재 동물과 다르다면
                visited[ny][nx] = visited[y][x] + 1
                deque.addLast(tmp)
            }
        }
    }

    print(ans)
}

