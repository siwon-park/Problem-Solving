import java.io.*;
import java.util.StringTokenizer;


public class Main {

    static void recur(int k, int cnt, long bit) {
        if (k == N) {
            int songs = countOne(bit);
            if (songs > MAX) {
                MAX = songs;
                ans = cnt;
            } else if (songs == MAX) ans = Math.min(ans, cnt);
            return;
        }
        recur(k + 1, cnt, bit); // 고르지 않고 넘어감
        recur(k + 1, cnt + 1, bit | arr[k]); // 현재 기타를 고름
    }

    static int countOne(long bit) {
        int cnt = 0;
        for (int i = 0; i < M; i++) {
            if ((bit & (1L << i)) != 0) cnt += 1;
        }
        return cnt;
    }

    static int N, M; // 기타의 개수, 곡의 개수
    static int ans = -1;
    static int MAX = 0; // 현재 연주할 수 있는 곡
    static long[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new long[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            st.nextToken(); // 기타 이름
            String line = st.nextToken();
            for (int j = 0; j < M; j++) {
                if (line.charAt(j) == 'Y') arr[i] |= (1L << j); // 비트연산 결과 저장
            }
        }

        recur(0, 0, 0);
        System.out.println(ans);
    }
}