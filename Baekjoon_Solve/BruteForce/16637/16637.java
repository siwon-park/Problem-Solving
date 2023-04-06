import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static void dfs(int k, int total) {
        if (k >= M) {
            ans = Math.max(ans, total);
            return;
        }

        // 괄호를 치지 않음(현재 합과 더함)
        int sum1 = calculate(total, arr[op[k] + 1], line.charAt(op[k]));
        dfs(k + 1, sum1);

        // 괄호를 침(다음 연산자의 위치 인덱스가 M보다 작아야함)
        if (k + 1 < M) {
            int tmp = calculate(arr[op[k + 1] - 1], arr[op[k + 1] + 1], line.charAt(op[k + 1]));
            int sum2 = calculate(total, tmp, line.charAt(op[k]));
            dfs(k + 2, sum2);
        }
    }

    // 계산을 위한 함수
    static int calculate(int a, int b, char o) {
        if (o == '+') return a + b;
        else if (o == '-') return a - b;
        else return a * b;
    }

    static int N, M, ans;
    static int[] arr, op;
    static String line;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        line = br.readLine();
        ans = Integer.MIN_VALUE;
        arr = new int[N]; // 길이를 N으로 선언 후, 각 위치의 숫자를 그대로 담음(연산자는 0)
        M = N / 2;
        op = new int[M]; // 연산자의 인덱스를 담은 배열
        int j = 0;
        for (int i = 0; i < N; i++) {
            if (i % 2 == 0) arr[i] = Integer.parseInt(line.charAt(i) + "");
            else op[j++] = i;
        }

        dfs(0, arr[0]);
        System.out.println(ans);
    }
}