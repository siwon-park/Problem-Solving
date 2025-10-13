import java.io.*;
import java.util.*;

val dy: IntArray = intArrayOf(-1, 0, 1, 0, 1, -1, 1, -1)
val dx: IntArray = intArrayOf(0, 1, 0, -1, 1, -1, -1, 1)

// Guarding the Farm (6067번)
fun main(args: Array<String>) {
    val br: BufferedReader = BufferedReader(InputStreamReader(System.`in`))
    val bw: BufferedWriter = BufferedWriter(OutputStreamWriter(System.out))
    var st: StringTokenizer = StringTokenizer(br.readLine())
    val n: Int = st.nextToken().toInt()
    val m: Int = st.nextToken().toInt()
    val graph: Array<IntArray> = Array(n) { IntArray(m) { 0 } }
    val visited: Array<BooleanArray> = Array(n) { BooleanArray(m) { false } }

    for (i in 0 until n) {
        st = StringTokenizer(br.readLine())
        for (j in 0 until m) graph[i][j] = st.nextToken().toInt()
    }

    val list: MutableList<Pair<Int, Int>> = mutableListOf() // 꼭대기 후보 리스트
    for (i in 0 until n) {
        for (j in 0 until m) {
            var flag: Boolean = true
            for (k in 0 until 8) {
                val ni = i + dy[k]
                val nj = j + dx[k]
                if (ni !in 0 until n || nj !in 0 until m) continue
                if (graph[ni][nj] > graph[i][j]) {
                    flag = false
                    break
                }
            }
            if (flag) list.add(Pair(i, j))
        }
    }

    var cnt: Int = 0
    for ((y, x) in list) {
        if (!visited[y][x]) {
            if (bfs(y, x, graph[y][x], graph, visited)) {
                cnt++
//                println("($y, $x) is peak, graph[y][x]: ${graph[y][x]}")
            }
        }
    }

    println(cnt)
}

fun bfs(r: Int, c: Int, h: Int, graph: Array<IntArray>, visited: Array<BooleanArray>): Boolean {
    val n: Int = graph.size
    val m: Int = graph[0].size
    val queue: Queue<Pair<Int, Int>> = LinkedList()
    queue.add(Pair(r, c))
    visited[r][c] = true
    var flag = true
    while (!queue.isEmpty()) {
        val (y, x) = queue.poll()
        for (k in 0 until 8) {
            val ny: Int = y + dy[k]
            val nx: Int = x + dx[k]
            if (ny !in 0 until n || nx !in 0 until m) continue
            if (graph[ny][nx] > h) flag = false
            if (graph[ny][nx] == h && !visited[ny][nx]) {
                visited[ny][nx] = true
                queue.add(Pair(ny, nx));
            }
        }
    }
    return flag
}
