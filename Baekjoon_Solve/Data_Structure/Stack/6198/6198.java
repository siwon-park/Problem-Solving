// 옥상 정원 꾸미기 (6198번)
import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(br.readLine());

        long ans = 0;
        Stack<Pair> stack = new Stack<>();
        // stack의 마지막 요소가 자신보다 크면 넣고, 작으면 큰 것이 나올 때까지 뽑아서 넣음
        for (int i = N - 1; i > -1; i--) {
            int curHeight = arr[i];
            if (!stack.isEmpty()) {
                long cnt = 1;
                if (stack.peek().h < curHeight) { // 현재 높이가 더 높다면
                    while (!stack.isEmpty() && stack.peek().h < curHeight) {
                        long n = stack.pop().cnt;
                        ans += n;
                        cnt += n;
                    }
                } else if (stack.peek().h == curHeight) { // 현재 높이와 같으면
                    while (!stack.isEmpty() && stack.peek().h == curHeight) {
                        cnt += stack.pop().cnt;
                    }
                }
                stack.push(new Pair(curHeight, cnt));
            } else {
                stack.push(new Pair(curHeight, 1)); // 자신의 높이와 자신까지 포함한 개수인 1을 스택에 삽입
            }
        }

        System.out.println(ans);
    }
}

class Pair {
    int h;
    long cnt;
    Pair(int h, long cnt) {
        this.h = h;
        this.cnt = cnt;
    }
}