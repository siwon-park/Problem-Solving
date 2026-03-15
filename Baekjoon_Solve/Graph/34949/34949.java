// 이대로 가면 되나요? (34949번)
import java.io.*;
import java.util.*;

public class Main {

    static final int MAX = Integer.MAX_VALUE;
    static int N;
    static int[] distance;
    static ArrayList<Integer>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        graph = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) graph[i] = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            int nxt = Integer.parseInt(st.nextToken());
            graph[nxt].add(i);
        }

        distance = new int[N + 1];
        Arrays.fill(distance, MAX);
        distance[N] = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(N);
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int nxt : graph[cur]) {
                if (distance[nxt] > distance[cur] + 1) {
                    distance[nxt] = distance[cur] + 1;
                    queue.add(nxt);
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            if (distance[i] == MAX) {
                bw.write(-1 + "\n");
            } else {
                bw.write(distance[i] + "\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}

