// 크리스마스 선물 (14235번)
/*
 문제: https://www.acmicpc.net/problem/14235
 우선순위 큐
 최대 우선순위 큐 문제
*/


import java.io.*;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            if (a == 0) {
                int res = (pq.isEmpty()) ? -1 : pq.poll();
                bw.write(res + "\n");
            } else {
                for (int j=0; j<a; j++) {
                    pq.add(Integer.parseInt(st.nextToken()));
                }
            }
        }

        br.close();
        bw.flush();
        bw.close();

    }
}
