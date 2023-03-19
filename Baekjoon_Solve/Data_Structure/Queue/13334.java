// 철로 (13334번)
/*
  문제: https://www.acmicpc.net/problem/13334
  우선순위 큐, 정렬
  정렬 기준이 중요한 문제
  배열은 o를 기준으로 오름차순 정렬하고,
  우선순위 큐는 h를 기준으로 최소 우선순위 큐를 구성한다.

  입력으로 주어지는 값이 정렬된 값이 아니기 때문에 유의해야 한다.
  배열을 순회하면서 o - h가 d보다 크면 continue하여 무시하고, 또한 우선순위 큐에 요소가 없으면 삽입한다.
  우선순위 큐 최상단의 요소의 h값에 + d한 값이 현재 최대 오른쪽 범위이다.
  현재 들어오려는 요소의 o값이 최대 오른쪽 범위보다 크면
  우선순위 큐에서 요소를 뽑았을 때, 요소의 h값이 현재 진입하려는 요소 o값에서 d를 뺀 값보다
  작으면 계속해서 우선순위 큐에서 뽑는다. 그후 현재 진입 요소를 우선순위 큐에 삽입한다.
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static class Pair implements Comparable<Pair> {
        int h;
        int o;

        Pair(int h, int o) {
            this.h = h;
            this.o = o;
        }

        @Override
        public int compareTo(Pair o) { // o를 기준으로 오름차순 정렬
            if (this.o > o.o) {
                return 1;
            } else if (this.o < o.o) {
                return -1;
            } else {
                return Integer.compare(this.h, o.h);
            }
        }

    }
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        Pair[] arr = new Pair[n];

        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            int tmpH = Integer.parseInt(st.nextToken());
            int tmpO = Integer.parseInt(st.nextToken());

            arr[i] = new Pair(Math.min(tmpH, tmpO), Math.max(tmpH, tmpO));
        }

        Arrays.sort(arr, Pair::compareTo);

        int d = Integer.parseInt(br.readLine());
        int ans = 0;
        // 최소 h 기준 우선순위 큐
        PriorityQueue<Pair> pq = new PriorityQueue<>((Pair o1, Pair o2) -> {
            if (o1.h > o2.h) {
                return 1;
            } else if (o1.h < o2.h) {
                return -1;
            } else {
                return Integer.compare(o1.o, o2.o);
            }
        });

        for (int i=0; i<n; i++) {
            Pair pair = arr[i];
            if (pair.o - pair.h > d) { // o - h가 d를 초과하면 무시
                continue;
            }
            if (pq.isEmpty()) {
                pq.add(pair);
            } else {
                int right = pq.peek().h + d; // 현재 pq에 넣을 수 있는 최대 오른쪽 범위
                if (pair.o > right) { // 현재 들어오려는 요소가 최대 오른쪽 범위보다 크면
                    while (!pq.isEmpty() && pq.peek().h < pair.o - d) { // 현재 들어오려는 요소에서 d를 뺀 값 미만은 요소에서 삭제
                        pq.poll();
                    }
                }
                pq.add(pair); // 현재 요소 삽입
            }
            ans = Math.max(ans, pq.size());
        }
        System.out.println(ans);
    }
}
