import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int MOD = 1_000_000_007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine()); // 테스트케이스
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine()); // 슬라임의 수
            st = new StringTokenizer(br.readLine());

            PriorityQueue<Long> pq = new PriorityQueue<>();
            for (int j = 0; j < N; j++) {
                pq.add(Long.parseLong(st.nextToken()));
            }

            long cost = 1L;
            while (pq.size() >= 2) {
                long a = pq.poll();
                long b = pq.poll();
                long ret = a * b;
                pq.add(ret);
                cost *= (ret % MOD);
                cost %= MOD;
            }

            bw.write(cost + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}