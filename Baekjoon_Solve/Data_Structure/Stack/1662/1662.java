import java.io.*;
import java.util.Stack;


public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        int N = S.length();
        
        // 문자열 S를 변환시킴 -> "(" 앞의 숫자는 그대로 두고 나머지 숫자는 전부 1로 변환
        String[] strArr = S.split("");
        for (int i = 0; i < N - 1; i++) {
            if (!strArr[i + 1].equals("(")) {
                if (!strArr[i].equals("(") && !strArr[i].equals(")")) {
                    strArr[i] = "1";
                }
            }
        }
        strArr[N - 1] = !strArr[N - 1].equals(")") ? "1" : ")";

        Stack<String> stack = new Stack<>();
        for (int i = 0; i < N; i++) {
            String s = strArr[i];
            if (s.equals(")")) { // ")"가 들어오면 스택에서 요소를 뽑아서 계산을 시작함
                int tmpLen = 0; // 괄호 안의 문자열 길이
                while (!stack.peek().equals("(")) { // 스택의 마지막 요소가 "("가 나올 때까지 스택에서 뽑음
                    tmpLen += Integer.parseInt(stack.pop());
                }
                stack.pop(); // "("를 뽑음
                int num = Integer.parseInt(stack.pop()); // "(" 앞의 숫자
                stack.push(String.valueOf(num * tmpLen)); // 계산한 길이를 문자열로 변환해서 스택에 삽입
            } else {
                stack.push(s);
            }
        }

        int ans = 0;
        // 스택에서 요소를 뽑아 ans에 더함
        while (!stack.isEmpty()) {
            ans += Integer.parseInt(stack.pop());
        }

        System.out.println(ans);
    }
}