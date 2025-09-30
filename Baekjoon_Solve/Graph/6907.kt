import java.io.*;
import java.util.*;

// Floor Plan (6907번)
val dy = arrayOf(-1, 0, 1, 0)
val dx = arrayOf(0, 1, 0, -1)

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))


    var squares: Int = br.readLine().toInt()
    val r: Int = br.readLine().toInt()
    val c: Int = br.readLine().toInt()

    val graph: Array<String> = Array(r) { "" }
    for (i in 0 until r) graph[i] = br.readLine()

    val visited = Array(r) { BooleanArray(c) { false } }


    val list: MutableList<Int> = mutableListOf()
    for (i in 0 until r) {
        for (j in 0 until c) {
            if (graph[i][j] == '.' && !visited[i][j]) {
                list.add(bfs(i, j, graph, visited))
            }
        }
    }

    var rooms: Int = 0
    list.sortDescending()
    for (num in list) {
        if (squares - num < 0) break
        squares -= num
        rooms += 1
    }

    println("$rooms ${if (rooms == 1) "room" else "rooms"}, $squares square metre(s) left over")

}

fun bfs(y: Int, x: Int, graph: Array<String>, visited: Array<BooleanArray>): Int {
    val queue: Queue<Pair<Int, Int>> = LinkedList()
    queue.add(Pair(y, x))
    visited[y][x] = true
    var cnt = 1
    while (!queue.isEmpty()) {
        val (cy, cx) = queue.poll()
        for (k in 0 until 4) {
            val ny = cy + dy[k]
            val nx = cx + dx[k]
            if (ny < 0 || ny >= visited.size || nx < 0 || nx >= visited[0].size || visited[ny][nx] || graph[ny][nx] == 'I') continue
            visited[ny][nx] = true
            queue.add(Pair(ny, nx))
            cnt += 1
        }
    }
    return cnt;
}

