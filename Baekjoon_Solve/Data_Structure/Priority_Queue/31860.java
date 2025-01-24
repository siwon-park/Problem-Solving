import java.io.*;
import java.util.*;

// 열심히 일하는 중 (31860번)
public class Main {

    static int N, M, K;

    static int floor(int y, int p) {
        return (y / 2) + p;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o2, o1));
        for (int i = 0; i < N; i++) {
            int d = Integer.parseInt(br.readLine());
            pq.add(d);
        }

        int curY = 0; // 현재 만족도
        int day = 0; // 날의 수
        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            day += 1;
            int curJob = pq.poll();
            curY = floor(curY, curJob);
            sb.append(curY).append("\n");
            curJob -= M;
            if (curJob > K) {
                pq.add(curJob);
            }
        }
        bw.write(day + "\n");
        bw.write(sb.toString());
        bw.flush();
        br.close();
    }
}
