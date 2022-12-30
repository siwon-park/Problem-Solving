// 전기가 부족해 (10423번)
/*
  문제: https://www.acmicpc.net/problem/10423
  MST, 유니온 파인드
  발전소는 자가 전원 공급이 가능하므로, 0원의 비용으로 0번 노드와 연결한다.
  나머지 노드들은 연결 비용을 기준으로 오름차순으로 정렬하여, 서로 부모 노드가 같지 않다면
  두 노드를 연결한다.
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;


public class Main {

    static class Pair implements Comparable<Pair>{
        int a;
        int b;
        int c;

        Pair(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }

        @Override
        public int compareTo(Pair o) {
            if (this.c > o.c) {
                return 1;
            } else if (this.c < o.c) {
                return -1;
            }
            return 0;
        }
    }

    static int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    static void union(int a, int b) {
        int pa = find(a);
        int pb = find(b);
        if (pa < pb) {
            parent[pb] = pa;
        } else {
            parent[pa] = pb;
        }
    }

    static int N, M, K;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        parent = new int[N + 1];
        for (int i=0; i<N+1; i++) {
            parent[i] = i;
        }

        st = new StringTokenizer(br.readLine());
        ArrayList<Pair> arrList = new ArrayList<>();
        for (int i=0; i<K; i++) {
            int x = Integer.parseInt(st.nextToken());
            arrList.add(new Pair(0, x, 0));
        }

        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            arrList.add(new Pair(u, v, w));
        }

        Collections.sort(arrList);

        int ans = 0;

        for (int i=0; i<M+K; i++) {
            Pair pair = arrList.get(i);
            int cost = pair.c;
            int a = pair.a;
            int b = pair.b;
            if (find(a) != find(b)) {
                union(a, b);
                ans += cost;
            }
        }

        System.out.println(ans);
    }
}
