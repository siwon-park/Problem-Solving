import java.io.*;
import java.util.*;

// PLAYERJINAH’S BOTTLEGROUNDS (15803번)

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    var st = StringTokenizer(br.readLine())
    val xa = st.nextToken().toInt()
    val ya = st.nextToken().toInt()

    st = StringTokenizer(br.readLine())
    val xb = st.nextToken().toInt()
    val yb = st.nextToken().toInt()

    st = StringTokenizer(br.readLine())
    val xc = st.nextToken().toInt()
    val yc = st.nextToken().toInt()

    val ccw = (xb - xa) * (yc - ya) - (xc - xa) * (yb - ya)
    if (ccw == 0) {
        println("WHERE IS MY CHICKEN?")
    } else {
        println("WINNER WINNER CHICKEN DINNER!")
    }
}

