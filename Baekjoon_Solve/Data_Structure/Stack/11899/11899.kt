import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.util.*
import java.io.InputStreamReader as InputStreamReader

// 괄호 끼워넣기 (11899번)
fun main(args: Array<String>) {
    val br: BufferedReader = BufferedReader(InputStreamReader(System.`in`))
    val bw: BufferedWriter = BufferedWriter(OutputStreamWriter(System.out))

    val s: String = br.readLine()
    val stack: Stack<Char> = Stack() // 스택에 여는 괄호만 쌓는다고 가정
    var ans: Int = 0
    for (c in s) {
        if (c == ')') { // 닫는 괄호면
            if (stack.empty()) { // 스택이 비었으면 (를 앞에 추가하고 닫음
                ans += 1
            } else {
                stack.pop() // 여는 괄호 하나를 뺀다
            }
        } else { // 여는 괄호면
            stack.push(c)
        }
    }
    // 남은 여는 괄호만큼 닫는 괄호를 추가
    ans += stack.size
    println(ans)
}

