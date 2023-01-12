// 콘센트 (23843번)
/*
  문제: https://www.acmicpc.net/problem/23843
  우선순위 큐, 정렬
  가지고 있는 콘센트 개수만큼 우선순위 큐에 충전기 번호별 Pair 클래스를 넣고 (최소 우선순위 큐)
  충전 시간이 큰 순서대로 반복문을 통해 우선순위 큐에서 먼저 뽑고 시간을 누적해서 다시 넣는다.
  우선순위 큐에서 모든 요소를 뽑으면서 최대 충전 시간을 찾는다.
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Pair implements Comparable<Pair> {
        long t;
        int m;
        Pair(long t, int m) {
            this.t = t;
            this.m = m;
        }

        @Override
        public int compareTo(Pair o) {
            if (this.t > o.t) {
                return 1;
            } else if (this.t < o.t) {
                return -1;
            } else {
                return Integer.compare(this.m, o.m);
            }
        }
    }
  
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Integer[] t = new Integer[N];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            t[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(t, Collections.reverseOrder());
        PriorityQueue<Pair> pq = new PriorityQueue<>(Pair::compareTo);

        for (int i=0; i<M; i++) {
            pq.add(new Pair(0, i + 1)); // 각 충전기 번호별 Pair 클래스 삽입
        }

        for (Integer num : t) { // 충전 시간이 큰 순서대로 
            Pair p = pq.poll(); // 우선순위 큐에서 요소를 뽑고
            pq.add(new Pair(p.t + num, p.m)); // 시간을 누적해서 다시 넣음
        }

        long ans = 0;
        while (!pq.isEmpty()) {
            ans = Math.max(ans, pq.poll().t);
        }

        System.out.println(ans);
    }
}
