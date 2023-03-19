// 컵라면 (1718번)
/*
  문제: https://www.acmicpc.net/problem/1781
  우선순위 큐, 정렬
  과제(13904번)과 동일한 내용의 문제
  마감기한을 오름차순 정렬하고 반복문을 돌면서 우선순위 큐에 요소가 없으면 삽입하고
  마감기한이 현재 날짜보다 크면 우선순위 큐에 삽입하고, 작거나 같을 경우 뽑은 다음에
  현재 들어오려는 컵라면의 수가 더 크다면 해당 마감기한과 컵라면의 수를 넣고, 아니라면 원래의 요소를 다시 집어 넣는다.
  우선순위 큐에서 요소를 뽑아서 컵라면의 수를 누적하여 출력하면 끝.
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Pair implements Comparable<Pair>{
        int d;
        int c;

        Pair(int d, int c) {
            this.d = d;
            this.c = c;
        }


        @Override
        public int compareTo(Pair o) {
            if (this.c > o.c) {
                return 1;
            } else if (this.c < o.c) {
                return -1;
            } else {
                return Integer.compare(this.d, o.d);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        ArrayList<Pair> arrayList = new ArrayList<>();

        StringTokenizer st;
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int dead = Integer.parseInt(st.nextToken());
            int cup = Integer.parseInt(st.nextToken());
            arrayList.add(new Pair(dead, cup));
        }

        Collections.sort(arrayList, (Pair o1, Pair o2) -> {
           if (o1.d > o2.d) {
               return 1;
           } else if (o1.d < o2.d) {
               return -1;
           } else {
               return Integer.compare(o1.c, o2.c);
           }
        });

        PriorityQueue<Pair> pq = new PriorityQueue<>(Pair::compareTo);
        int day = 0;
        for (Pair p : arrayList) {
            if (pq.isEmpty()) {
                pq.add(new Pair(p.d, p.c));
                day += 1;
            } else {
                if (p.d > day) {
                    pq.add(new Pair(p.d, p.c));
                    day += 1;
                } else {
                    Pair newPair = pq.poll();
                    if (newPair.c < p.c) {
                        pq.add(new Pair(p.d, p.c));
                    } else {
                        pq.add(newPair);
                    }
                }
            }
        }

        int ans = 0;
        while (!pq.isEmpty()) {
            ans += pq.poll().c;
        }

        System.out.println(ans);
    }
}
