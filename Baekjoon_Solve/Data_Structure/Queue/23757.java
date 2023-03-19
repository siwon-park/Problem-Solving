// 아이들과 선물 상자(23757번)
/*
  문제: https://www.acmicpc.net/problem/23757
  우선순위 큐
  최대 우선순위 큐 문제
  우선순위 큐에서 요소를 뽑았을 때, wi보다 이상이면 wi만큼 뺀 다음 다시 우선순위 큐에 집어 넣는다.
  이것을 M번 반복하는 것이 가능하다면 1을 아니라면 0을 출력하면 된다.
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            pq.add(Integer.parseInt(st.nextToken()));
        }

        boolean flag = true;
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<M; i++) {
            int wi = Integer.parseInt(st.nextToken());
            int ci = pq.poll();
            if (ci >= wi) {
                pq.add(ci - wi);
            } else {
                flag = false;
                break;
            }
        }

        if (!flag) {
            System.out.println(0);
        } else {
            System.out.println(1);
        }
    }
}
