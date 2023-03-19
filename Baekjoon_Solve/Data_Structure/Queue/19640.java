// 화장실의 규칙 (19640번)
/*
  문제: https://www.acmicpc.net/problem/19640
  우선순위 큐, 구현
  선두 그룹을 우선 순위 큐로 하고, 각 줄을 큐로 배열화하여
  선두 그룹에서 사람을 뽑고 난 다음에 그 사람의 줄에 해당하는 큐 번호에
  사람이 있으면 선두 그룹에 넣는 방식을 반복해서
  k번째 사람이 나오기 전까지 뽑은 사람의 수를 카운트하면 된다.
  선두 그룹이 우선순위 큐인 것은 바로 눈치챘는데, 선두 그룹에 넣는 방법을 못 찾고 있었다.
  큐 배열을 활용해서 선두 그룹에서 나왔으면 나온 사람의 줄에 해당하는 큐 번호에 사람이 있으면 다시 선두 그룹에 넣어주는 것이 포인트
*/

import java.io.*;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static class Pair implements Comparable<Pair>{
        int D;
        int H;
        int M;
        int K;
        Pair(int D, int H, int M, int K) {
            this.D = D;
            this.H = H;
            this.M = M;
            this.K = K;
        }

        @Override
        public int compareTo(Pair o) {
            if (this.D < o.D) {
                return 1;
            } else if (this.D > o.D) {
                return -1;
            } else {
                if (this.H < o.H) {
                    return 1;
                } else if (this.H > o.H) {
                    return -1;
                } else {
                    if (this.M > o.M) {
                        return 1;
                    } else if (this.M < o.M) {
                        return -1;
                    } else {
                        return 0;
                    }
                }
            }
        }
    }

    static int N, M, K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        PriorityQueue<Pair> pq = new PriorityQueue<>(Pair::compareTo); // 선두 그룹

        Queue<Pair>[] q = new LinkedList[M + 1];
        for (int i=0; i<M+1; i++) {
            q[i] = new LinkedList<>();
        }

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int D = Integer.parseInt(st.nextToken());
            int H = Integer.parseInt(st.nextToken());
            q[(i % M) + 1].add(new Pair(D, H, (i % M) + 1, i)); // 각 줄별로 사람을 줄 세움
        }

        for (int i=1; i<M+1; i++) {
            if (!q[i].isEmpty()) {
                pq.add(q[i].poll());
            }
        }

        int ans = 0;
        while (!pq.isEmpty()) {
            Pair pair = pq.poll();
            if (pair.K == K) {
                System.out.println(ans);
                break;
            }
            ans++;
            if (!q[pair.M].isEmpty()) {
                pq.add(q[pair.M].poll());
            }
        }

    }
}
