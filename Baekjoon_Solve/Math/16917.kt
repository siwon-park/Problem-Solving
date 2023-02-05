// 양념 반 후라이드 반 (16917번)
/*
  문제: https://www.acmicpc.net/problem/16917
  수학, 사칙연산
  반반 치킨을 최대로 일단 산다. (x와 y 중 큰 수 * 2 * 반반 치킨 가격)
  x와 y 중 작은 수만큼 반반 치킨을 사고 남은 치킨을 개별 구매한 경우와 반반 치킨을 최대로 샀을 경우 중 작은 것을 구한다.
  전부 개별 구매하는 경우와 비교하여 더 작은 것을 출력하면 된다.
*/

import java.io.BufferedReader
import java.util.StringTokenizer
import java.io.InputStreamReader as InputStreamReader

fun main(args: Array<String>) {
    val br: BufferedReader = BufferedReader(InputStreamReader(System.`in`))
    var st: StringTokenizer = StringTokenizer(br.readLine())

    val a: Int = st.nextToken().toInt()
    val b: Int = st.nextToken().toInt()
    val c: Int = st.nextToken().toInt()
    val x: Int = st.nextToken().toInt()
    val y: Int = st.nextToken().toInt()

    var banban: Int = c * Math.max(x, y) * 2 // 반반 치킨을 최대로 사는 경우
    if (x > y) { // x와 y의 개수 중 작은 수만큼 반반 치킨을 사고 나머지를 개별 구매하는 경우
        banban = Math.min(banban,  c * Math.min(x, y) * 2 + a * (x - y)) 
    } else if (x < y) {
        banban =  Math.min(banban,  c * Math.min(x, y) * 2 + b * (y - x))
    }

    val normal: Int = a * x + b * y // 전부 개별 구매하는 경우

    println(Math.min(normal, banban))
}
