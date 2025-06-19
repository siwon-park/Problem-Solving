import java.io.*;
import java.util.*;

// Appearing Numbers (31609번)
fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val n = br.readLine().toInt()
    val st: StringTokenizer = StringTokenizer(br.readLine())
    val treeSet: TreeSet<Int> = TreeSet()
    for (i in 0 until n) {
        treeSet.add(st.nextToken().toInt())
    }

    for (num in treeSet) {
        bw.write(num.toString() + "\n")
    }

    bw.flush()
    bw.close()
    br.close()
}

