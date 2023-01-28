// CCW (11758번)
/*
  문제: https://www.acmicpc.net/problem/11758
  기하학, CCW
  CCW 알고리즘에 의해 시계방향을 판단하면 된다.
  반시계 방향이면 CCW의 계산 결과가 0보다 크고, 시계 방향이면 0보다 작고, 평행이면 0이다.
  CCW = (x2 - x1) * (y3 - y1) - (y2 - y1) * (x3 - x1)이다.
*/

import java.io.BufferedReader
import java.util.StringTokenizer
import java.io.InputStreamReader as InputStreamReader

fun main(args: Array<String>) {
    val br: BufferedReader = BufferedReader(InputStreamReader(System.`in`))
    var st: StringTokenizer = StringTokenizer(br.readLine());
    val x1: Int = st.nextToken().toInt()
    val y1: Int = st.nextToken().toInt()

    st = StringTokenizer(br.readLine())
    val x2: Int = st.nextToken().toInt()
    val y2: Int = st.nextToken().toInt()

    st = StringTokenizer(br.readLine())
    val x3: Int = st.nextToken().toInt()
    val y3: Int = st.nextToken().toInt()


    val ret: Int = (x2 - x1) * (y3 - y1) - (y2 - y1) * (x3 - x1)
    if (ret > 0) {
        println(1)
    } else if (ret < 0) {
        println(-1)
    } else {
        println(0)
    }

}
