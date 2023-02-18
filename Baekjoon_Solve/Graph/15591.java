// MooTube (Silver) (15591번)
///////////////////////////////////////////////////////////////////////////////////
  // 문제: https://www.acmicpc.net/problem/15591
  // BFS
  // 파이썬으로 푼 문제를 자바로 푼 코드
  // 매 쿼리마다 bfs를 돌려야하기 때문에 비효율적이지만, Pypy(1712ms)보다는 Java(1396ms)가 더 빠르다. (메모리는 Pypy가 훨씬 적게 사용하였다.) 
///////////////////////////////////////////////////////////////////////////////////
import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
  
    static class Pair {
        int x;
        int r;

        Pair(int x, int r) {
            this.x = x;
            this.r = r;
        }
    }
  
    static int bfs(int k, int v) {
        int cnt = 0;
        boolean[] visited = new boolean[N + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(v); // 현재 위치, 개수
        visited[v] = true;
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int i=0; i<graph.get(cur).size(); i++) {
                Pair pair = graph.get(cur).get(i);
                int nxt = pair.x;
                int usa = pair.r;
                if (!visited[nxt] && usa >= k) {
                    cnt ++;
                    visited[nxt] = true;
                    queue.add(nxt);
                }
            }
        }
        return cnt;
    }

    static int N, Q;
    static ArrayList<ArrayList<Pair>> graph = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        // 그래프 초기화
        for (int i=0; i<N+1; i++) {
            graph.add(new ArrayList<Pair>());
        }

        for (int i=0; i<N-1; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st2.nextToken());
            int q = Integer.parseInt(st2.nextToken());
            int r = Integer.parseInt(st2.nextToken());
            graph.get(p).add(new Pair(q, r));
            graph.get(q).add(new Pair(p, r));
        }

        // 쿼리
        for (int i=0; i<Q; i++) {
            StringTokenizer st3 = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st3.nextToken());
            int v = Integer.parseInt(st3.nextToken());
            int ret = bfs(k, v);
            bw.write(ret + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
