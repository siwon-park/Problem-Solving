import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.lang.StringBuilder
import java.io.InputStreamReader as InputStreamReader

// 거울상 (4583번)
fun main(args: Array<String>) {
    val br: BufferedReader = BufferedReader(InputStreamReader(System.`in`))
    val bw: BufferedWriter = BufferedWriter(OutputStreamWriter(System.out))
    val INVALID: String = "INVALID"

    while (true) {
        val line = br.readLine();
        if ("#".equals(line)) {
            break
        }
        var n = line.length
        var sb: StringBuilder = StringBuilder()

        var flag: Boolean = true;
        for (i in n - 1 downTo 0) {
            if ('b'.equals(line[i])) sb.append("d")
            else if ('d'.equals(line[i])) sb.append("b")
            else if ('p'.equals(line[i])) sb.append("q")
            else if ('q'.equals(line[i])) sb.append("p")
            else {
                if ('i'.equals(line[i]) || 'o'.equals(line[i]) || 'v'.equals(line[i]) || 'w'.equals(line[i]) || 'x'.equals(line[i])) {
                    sb.append(line[i])
                } else {
                    flag = false
                    break
                }
            }
        }

        var reversed: String = sb.toString()
        if (!flag) reversed = INVALID
        bw.write(reversed + "\n")
    }

    bw.flush()
    bw.close()
    br.close()
}
