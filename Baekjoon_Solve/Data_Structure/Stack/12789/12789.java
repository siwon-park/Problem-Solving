import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine()); // 현재 대기 라인

        Stack<Integer> waitStack = new Stack<>(); // 대기열 왼쪽 공간
        int cur = 1; // 시작 번호

        for (int i = 0; i < N; i++) {
            waitStack.add(Integer.parseInt(st.nextToken()));
            while (!waitStack.isEmpty() && waitStack.peek() == cur) { // 스택의 맨 마지막이 현재 번호라면
                waitStack.pop(); // 스택에서 뽑고
                cur ++; // 현재 번호를 증가시킴
            }
        }

        System.out.println(cur == N + 1 ? "Nice" : "Sad"); // 다음 번호가 N + 1이면 "Nice"
    }
}