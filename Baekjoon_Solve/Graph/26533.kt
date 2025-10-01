import java.io.*;
import java.util.*;

// Tractor Path (26533번)
val dy = arrayOf(0, 1)
val dx = arrayOf(1, 0)

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val n = br.readLine().toInt()
    val graph: Array<String> = Array(n) { "" }
    for (i in 0 until n) graph[i] = br.readLine()
    val visited: Array<BooleanArray> = Array(n) { BooleanArray(n) { false } }

    val flag = bfs(graph, visited)
    if (flag) println("Yes")
    else println("No")
}


fun bfs(graph: Array<String>, visited: Array<BooleanArray>): Boolean {
    val n: Int = graph.size
    visited[0][0] = true
    val queue: Queue<Pair<Int, Int>> = LinkedList()
    queue.add(Pair(0, 0))
    while (!queue.isEmpty()) {
        val (y, x) = queue.poll()
        if (y == n - 1 && x == n - 1) return true
        for (k in 0 until 2) {
            val ny = y + dy[k]
            val nx = x + dx[k]
            if (ny < 0 || ny >= n || nx < 0 || nx >= n || visited[ny][nx] || graph[ny][nx] == 'x') continue
            visited[ny][nx] = true
            queue.add(Pair(ny, nx))
        }
    }
    return false
}
