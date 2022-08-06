// A+B-4(10951번)
///////////////////////////////////////////////////////
  // 문제: https://www.acmicpc.net/problem/10951
  // 수학
  // java에서의 예외처리를 배울 수 있었음. try {...} catch(예외명1) {...} 구문도 있겠지만,
  // 입력으로 Scanner를 받냐 BufferedReader를 받냐에 따라 처리할 수 있는 방법이 하나 더 있었음.
  // Scanner 사용 시, while 구문의 괄호에 sc.hasNextLine(), sc.hasNext() 또는 sc.hasNextInt()를 사용하면 되고,
  // BufferedReader 사용 시, (input=br.readLine()) != null 을 쓰면 됨.
///////////////////////////////////////////////////////
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int A = sc.nextInt();
            int B = sc.nextInt();
            System.out.println(A+B);
        }
    }
}
