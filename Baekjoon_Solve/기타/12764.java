// 싸지방에 간 준하 (12764번)
/*
  문제: https://www.acmicpc.net/problem/12764
  우선순위 큐
  시작 시간을 기준으로 우선순위 큐를 구성한 다음
  우선 순위 큐에서 요소를 뽑았을 때 시작 시간이 컴퓨터 배열을 0부터 N까지 반복했을 때,
  배열에 기록된 값보다 크면, 요소의 끝나는 시간을 컴퓨터 배열의 현재 인덱스에 기록을 해준다.
  그리고 count 배열의 값을 1씩 증가시키면 된다.
*/

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
