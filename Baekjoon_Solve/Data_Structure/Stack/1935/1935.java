import java.io.*;
import java.util.*;


public class Main {

    static HashMap<Character, Integer> hashMap;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 피연산자의 개수
        String postOrder = br.readLine(); // 후위 표기식
        int M = postOrder.length();
        hashMap = new HashMap<>();

        for (int i = 0; i < N; i++) {
            char s = (char) (65 + i);
            int n = Integer.parseInt(br.readLine());
            hashMap.put(s, n);
        }

        Stack<Double> stack = new Stack<>();
        for (int i = 0; i < M; i++) {
            char s = postOrder.charAt(i);
            if ('A' <= s && s <= 'Z') stack.push((double) hashMap.get(s)); // 스택에 아무 요소도 없으면 숫자로 변환해서 삽입
            else {
                double ret = 0;
                double b = stack.pop();
                double a = stack.pop();
                switch (s) { // 연산자가 들어오면 스택에서 숫자를 2개 뽑아서 연산하여 스택에 삽입함
                    case '*': ret = a * b; break;
                    case '+': ret = a + b; break;
                    case '/': ret = a / b; break;
                    case '-': ret = a - b; break;
                }
                stack.push(ret);
            }
        }
        double ans = stack.pop();
        System.out.printf("%.2f", ans);
    }
}