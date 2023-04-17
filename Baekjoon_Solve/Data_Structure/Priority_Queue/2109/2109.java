import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine()); // n개의 대학
        boolean[] visited = new boolean[10001]; // 방문 배열

        PriorityQueue<Pair> pq = new PriorityQueue<>((o1, o2) -> {
            if (o1.p < o2.p) return 1;
            else if (o1.p > o2.p) return -1;
            else return Integer.compare(o1.d, o2.d);
        });

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            pq.add(new Pair(p, d));
        }

        int total = 0;
        while (!pq.isEmpty()) {
            Pair pair = pq.poll();
            for (int i = pair.d; i > 0; i--) {
                if (!visited[i]) {
                    visited[i] = true;
                    total += pair.p;
                    break;
                }
            }
        }

        System.out.println(total);
    }

}

class Pair {
    int p;
    int d;

    Pair (int p, int d) {
        this.p = p;
        this.d = d;
    }
}