// 플로이드 (11404번)
/*
  문제: https://www.acmicpc.net/problem/11404
  오버 플로우 연산을 염두하지 않으면 어떻게 되는지 보여준 문제
  단일 최대 비용이 10만이지, 경유 결과 비용이 10만은 아님
  생각해보니 Long형으로 선언하지 않아도 됨. 단지 오버 플로우만 방지하면 됐음
*/


import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        long[][] graph = new long[n + 1][n + 1];

        for (int a=1; a<n+1; a++) {
            for (int b=1; b<n+1; b++) {
                graph[a][b] = Long.MAX_VALUE;
                graph[b][a] = Long.MAX_VALUE;
            }
            graph[a][a] = 0;
        }

        StringTokenizer st;
        for (int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph[a][b] = Math.min(graph[a][b], c);
        }

        for (int k=1; k<n+1; k++) {
            for (int a=1; a<n+1; a++) {
                for (int b=1; b<n+1; b++) {
                    if (graph[a][k] == Long.MAX_VALUE || graph[k][b] == Long.MAX_VALUE) { // 오버플로우 방지
                        continue;
                    }
                    if (graph[a][k] + graph[k][b] < graph[a][b]) {
                        graph[a][b] = graph[a][k] + graph[k][b];
                    }
                }
            }
        }

        for (int i=1; i<n+1; i++) {
            for (int j=1; j<n+1; j++) {
                long cost = (graph[i][j] == Long.MAX_VALUE) ? 0 : graph[i][j];
                bw.write(cost + " ");
            }
            bw.write("\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }
}
