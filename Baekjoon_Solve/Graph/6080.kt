import java.io.*;
import java.util.*;

// Bad Grass (6080번)
val dy = arrayOf(-1, -1, 0, 1, 1, 1, 0, -1)
val dx = arrayOf(0, 1, 1, 1, 0, -1, -1, -1)

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    var st: StringTokenizer = StringTokenizer(br.readLine())
    val r = st.nextToken().toInt()
    val c = st.nextToken().toInt()
    val graph = Array(r) { IntArray(c) }
    for (i in 0 until r) {
        st = StringTokenizer(br.readLine())
        for (j in 0 until c) {
            graph[i][j] = st.nextToken().toInt()
        }
    }

    val visited = Array(r) { BooleanArray(c) }
    var ans = 0
    for (i in 0 until r) {
        for (j in 0 until c) {
            if (graph[i][j] != 0 && !visited[i][j]) {
                ans += 1
                visited[i][j] = true
                val queue: Queue<Pair<Int, Int>> = LinkedList()
                queue.add(Pair(i, j))
                while (!queue.isEmpty()) {
                    val (y, x) = queue.poll()
                    for (k in 0 until 8) {
                        val ny = y + dy[k];
                        val nx = x + dx[k];
                        if (ny < 0 || ny >= r || nx < 0 || nx >= c || visited[ny][nx] || graph[ny][nx] == 0) continue
                        visited[ny][nx] = true
                        queue.add(Pair(ny, nx))
                    }
                }
            }
        }
    }

    println(ans)
}

