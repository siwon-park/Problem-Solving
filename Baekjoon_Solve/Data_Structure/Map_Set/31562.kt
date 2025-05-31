import java.io.*;
import java.util.*;

// 전주 듣고 노래 맞히기
fun main(args: Array<String>){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    var st = StringTokenizer(br.readLine())
    val countMap: MutableMap<String, Int> = mutableMapOf()
    val songMap: MutableMap<String, String> = mutableMapOf()
    val n: Int = st.nextToken().toInt()
    val m: Int = st.nextToken().toInt()

    for (i in 0 until n) {
        st = StringTokenizer(br.readLine())
        val t: Int = st.nextToken().toInt()
        val songName: String = st.nextToken()
        val prefix: StringBuilder = StringBuilder()
        for (j in 0 until 3) {
            prefix.append(st.nextToken())
        }
        val headerText = prefix.toString()
        countMap[headerText] = countMap.getOrDefault(headerText, 0) + 1
        songMap[headerText] = songName
    }

    for (i in 0 until m) {
        val headerText: String = br.readLine().split(" ").joinToString("") { it.toString() }
        if (countMap.containsKey(headerText)) {
            val cnt = countMap[headerText]
            if (cnt == 1) {
                bw.write(songMap[headerText] + "\n")
            } else {
                bw.write("?\n")
            }
        } else {
            bw.write("!\n")
        }
    }

    bw.flush()
    bw.close()
    br.close()
}
