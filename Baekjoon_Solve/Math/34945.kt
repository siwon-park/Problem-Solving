import java.io.*;
import java.util.*;

// 채플이 너무해 (34945번)
fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
//    var st: StringTokenizer = StringTokenizer(br.readLine())
    val n: Int = br.readLine().toInt()
    if (n + 2 >= 8) {
        bw.write("Success!")
    } else {
        bw.write("Oh My God!")
    }

    bw.flush()
    bw.close()
    br.close()
}

