import java.io.*;
import java.util.*;


public class Main {

    static long calculate(String s) {
        long ans = 0L;
        int N = s.length();

        Stack<String> stack = new Stack<>();
        for (int i = 0; i < N; i++) {
            char c = s.charAt(i);
            if (stack.isEmpty()) {
                stack.push(c + "");
            } else { // 닫는 괄호일 경우
                if (c == ')') {
                    if (stack.peek().equals("(")) { // 바로 여는 괄호면
                        stack.pop(); // 스택의 마지막 요소를 뽑고
                        stack.push("2"); // 2를 스택에 삽입
                    }
                    else {
                        long ret = 0L;
                        boolean flag = false; // 괄호가 잘 닫혔는지 유무
                        while (!stack.isEmpty()) {
                            String cur = stack.pop();
                            if (cur.equals("[") || cur.equals("]") || cur.equals(")")) return 0L; // 잘못된 괄호면 0 반환
                            if (cur.equals("(")) {
                                ret *= 2L;
                                flag = true; // 괄호가 잘 닫힘
                                stack.push(ret + "");
                                break;
                            } else {
                                ret += Long.parseLong(cur);
                            }
                        }
                        if (!flag) return 0L; // 괄호가 잘 닫히지 않았으면 0 반환
                    }
                } else if (c == ']') {
                    if (stack.peek().equals("[")) { // 바로 여는 괄호면
                        stack.pop(); // 스택의 마지막 요소를 뽑고
                        stack.push("3"); // 3을 스택에 삽입
                    } else {
                        long ret = 0L;
                        boolean flag = false;
                        while (!stack.isEmpty()) {
                            String cur = stack.pop();
                            if (cur.equals("(") || cur.equals(")") || cur.equals("]")) return 0L; // 잘못된 괄호면 0 반환
                            if (cur.equals("[")) {
                                ret *= 3L;
                                stack.push(ret + "");
                                flag = true;
                                break;
                            } else {
                                ret += Long.parseLong(cur);
                            }
                        }
                        if (!flag) return 0L;
                    }
                } else {
                    stack.push(c + "");
                }
            }
        }
        // 스택의 요소를 전부 뽑아서 합산함
        while (!stack.isEmpty()) {
            String c = stack.peek();
            if (c.equals("(") || c.equals(")") || c.equals("[") || c.equals("]")) return 0L;
            ans += Long.parseLong(stack.pop());
        }
        return ans;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        System.out.println(calculate(s));
    }
}