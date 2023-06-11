import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static class Pair implements Comparable<Pair>{
        int p;
        int q;

        Pair(int p, int q) {
            this.p = p;
            this.q = q;
        }

        @Override
        public int compareTo(Pair o) {
            if (this.p > o.p) {
                return 1;
            } else if (this.p < o.p) {
                return -1;
            }
            return 0;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Pair> pq1 = new PriorityQueue<>();

        for (int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int P = Integer.parseInt(st.nextToken());
            int Q = Integer.parseInt(st.nextToken());
            pq1.add(new Pair(P, Q));
        }

        int size = 1;
        int[] cpu = new int[N]; // 끝나는 시간 기록
        int[] count = new int[N];

        Pair pair = pq1.poll();
        cpu[0] = pair.q;
        count[0] += 1;

        while(!pq1.isEmpty()) {
            pair = pq1.poll();
            for (int i=0; i<N; i++) {
                if (cpu[i] < pair.p) {
                    if (cpu[i] == 0) {
                        size += 1;
                    }
                    cpu[i] = pair.q;
                    count[i] += 1;
                    break;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i=0; i<N; i++) {
            if (count[i] == 0) {
                break;
            }
            sb.append(count[i]);
            sb.append(" ");
        }

        System.out.println(size);
        System.out.println(sb);

    }
}