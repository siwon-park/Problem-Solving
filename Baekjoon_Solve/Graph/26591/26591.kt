import java.io.*;
import java.util.*;

// Rain Boots (26591번)
val dy = intArrayOf(-1, 0, 1, 0)
val dx = intArrayOf(0, 1, 0, -1)

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    var flag = true
    var line: String?
    while (flag) {
        var sy = 0
        var sx = 0
        var ey = 0
        var ex = 0
        val graph = Array(8) { "" }
        for (i in 0 until 8) {
            line = br.readLine()
            if (line.isNullOrEmpty()) {
                flag = false
                break
            }
            graph[i] = line
            for (j in 0 until 8) {
                if (graph[i][j] == 'S') {
                    sy = i
                    sx = j
                } else if (graph[i][j] == 'E') {
                    ey = i
                    ex = j
                }
            }
        }

        val ans: Int = bfs(sy, sx, ey, ex, graph)
        bw.write(ans.toString() + "\n")
        line = br.readLine()
        if (line == "-") continue
        if (line.isNullOrEmpty()) {
            flag = false
            break
        }
    }

    bw.flush()
    bw.close()
    br.close()
}

fun bfs(sy: Int, sx: Int, ey: Int, ex: Int, graph: Array<String>): Int {
    val deque: Deque<Pair<Int, Int>> = LinkedList()
    val visited = Array(8) { IntArray(8) }
    deque.addFirst(Pair(sy, sx))
    visited[sy][sx] = 1 // 시작 위치 방문 처리; 1로 표시하고 최종결과 - 1로 계산해서 반환
    while (!deque.isEmpty()) {
        val (y, x) = deque.pollFirst()
        if (y == ey && x == ex) return visited[y][x] - 1
        for (k in 0 until 4) {
            val ny = y + dy[k]
            val nx = x + dx[k]
            if (ny < 0 || ny >= 8 || nx < 0 || nx >= 8 || visited[ny][nx] != 0) continue
            if (graph[ny][nx] == 'M') {
                deque.addLast(Pair(ny, nx))
                visited[ny][nx] = visited[y][x] + 1
            } else {
                visited[ny][nx] = visited[y][x]
                deque.addFirst(Pair(ny, nx))
            }
        }
    }
    return -1;
}

