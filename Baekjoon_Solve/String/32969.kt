import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.util.*
import java.io.InputStreamReader as InputStreamReader

// 학술대회 참가신청 (32969번)
fun main(args: Array<String>) {
    val br: BufferedReader = BufferedReader(InputStreamReader(System.`in`))
    val bw: BufferedWriter = BufferedWriter(OutputStreamWriter(System.out))

    val dh: String = "digital humanities"
    val bd: String = "public bigdata"

    val dhSet: HashSet<String> = HashSet()
    dhSet.add("social")
    dhSet.add("history")
    dhSet.add("language")
    dhSet.add("literacy")

    val bdSet: HashSet<String> = HashSet()
    bdSet.add("bigdata")
    bdSet.add("public")
    bdSet.add("society")

    val line = br.readLine()
    var ans = bd
    for (key in dhSet) {
        if (line.contains(key)) {
            ans = dh
        }
    }

    print(ans)

}

