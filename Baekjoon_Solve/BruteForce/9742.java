import java.io.*;
import java.util.*;

// 순열 (9742번)
public class Main {

    static String noAns = "No permutation";
    static int N, M, cnt;
    static String ans;
    static boolean[] visited;

    // 자리 바꾸기 방식으로 하니 사전순으로 나오지 않아서 방문 배열 사용
    static void permute(String target, int idx, char[] arr) {
        if (idx == M) {
            cnt += 1;
            if (cnt == N) {
                ans = String.valueOf(arr);
            }
            return;
        }

        for (int i = 0; i < M; i++) {
            if (!visited[i]) {
                visited[i] = true;
                arr[idx] = target.charAt(i);
                permute(target, idx + 1, arr);
                arr[idx] = ' ';
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        String line;
        while ((line = br.readLine()) != null) {
            st = new StringTokenizer(line);
            String word = st.nextToken();
            N = Integer.parseInt(st.nextToken());
            cnt = 0;
            M = word.length();
            ans = noAns;
            visited = new boolean[M];
            permute(word, 0, new char[M]);
            System.out.println(word + " " + N + " = " + ans); // EOFException 떨어지면 bw.flush() 불가하므로 바로 출력
        }
    }
}

