// 게임 개발(1516번)
/////////////////////////////////////////////////////////////////////////////////////////////////
  // 문제: https://www.acmicpc.net/problem/1516
  // 위상정렬
  // 파이썬으로 먼저 코드를 다 짜고나서 자바로 옮겨서 풀어보았다.
  // 아무래도 자바가 파이썬에 비해 그래프나 다른 자료형을 다루기에 아직 익숙치 않다.
  // 일반적인 위상 정렬 문제이다. 정렬 결과를 출력하는 문제가 아니라, 해당 노드까지 걸리는 최소 시간을 구하는 문제이다.
  // 따라서 해당 노드에 이르기까지 누적 시간 합을 담을 테이블이 필요하고 거기에 값을 기록하는 식으로 위상 정렬을 진행하면 된다.
/////////////////////////////////////////////////////////////////////////////////////////////////
import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static class Pair {
        long total;
        int cur;

        Pair(long total, int cur) {
            this.total = total;
            this.cur = cur;
        }
    }

    static int N;
    static int[] indegree;
    static int[] C;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        indegree = new int[N + 1];
        C = new int[N + 1];

        for (int i=0; i<N+1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int a=1; a<N+1; a++) {
            String[] tmp = br.readLine().split(" ");
            int n = tmp.length;
            C[a] = Integer.parseInt(tmp[0]);
            for (int i=1; i<n; i++) {
                int b = Integer.parseInt(tmp[i]);
                if (b == -1) {
                    break;
                }
                indegree[a] += 1;
                graph.get(b).add(a);
            }
        }

        Queue<Pair> queue = new LinkedList<>();
        long[] T = new long[N + 1];

        for (int i=1; i<N+1; i++) {
            T[i] = C[i];
            if (indegree[i] == 0) {
                queue.add(new Pair(C[i], i));
            }
        }

        while (!queue.isEmpty()) {
            Pair curPair = queue.poll();
            long cost = curPair.total;
            int cur = curPair.cur;

            for (int i=0; i<graph.get(cur).size(); i++) {
                int nxt = graph.get(cur).get(i);
                indegree[nxt] -= 1;
                T[nxt] = Math.max(T[nxt], cost + C[nxt]);
                if (indegree[nxt] == 0) {
                    queue.add(new Pair(T[nxt], nxt));
                }
            }
        }

        for (int i=1; i<N+1; i++) {
            bw.write(T[i] + "\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }
}
