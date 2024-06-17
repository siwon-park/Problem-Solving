import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.lang.StringBuilder
import java.util.HashSet
import java.io.InputStreamReader as InputStreamReader

// 줄임말 만들기 (3181번)
fun main(args: Array<String>) {
    val br: BufferedReader = BufferedReader(InputStreamReader(System.`in`))
    val bw: BufferedWriter = BufferedWriter(OutputStreamWriter(System.out))

    val hashSet: HashSet<String> = HashSet()
    hashSet.add("i")
    hashSet.add("pa")
    hashSet.add("te")
    hashSet.add("ni")
    hashSet.add("niti")
    hashSet.add("a")
    hashSet.add("ali")
    hashSet.add("nego")
    hashSet.add("no")
    hashSet.add("ili")

    val strArr:Array<String> = br.readLine().split(" ").toTypedArray()
    val n: Int = strArr.size;

    val sb: StringBuilder = StringBuilder()
    for (i in 0 .. n - 1) {
        if (hashSet.contains(strArr[i]) && i != 0) continue
        sb.append(strArr[i][0].uppercase())
    }

    bw.write(sb.toString())
    bw.flush()
    bw.close()
    br.close()
}
