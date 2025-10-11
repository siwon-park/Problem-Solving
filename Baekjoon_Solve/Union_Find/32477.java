// Alien Attack 2 (32477번)
/*
* 외계인이 친구들을 납치할 때 필요한 최소 우주선 크기를 구하는 문제
* 납치할 때 친구관계에 있는 n명의 친구를 모두 납치해야만 하기 때문에, 우주선의 최소 크기는 친구 네트워크의 최대 크기를 구하는 것과 같음.
* */
import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int[] parent, size;

    static int find(int x) {
        if (parent[x] != x) parent[x] = find(parent[x]);
        return parent[x];
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b) {
            parent[b] = a;
            size[a] += size[b];
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        parent = new int[N + 1];
        size = new int[N + 1];
        size[0] = 1;
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
            size[i] = 1;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            union(u, v);
        }

        int ans = 0;
        for (int i = 1; i <= N; i++) {
            int k = find(i);
            ans = Math.max(ans, size[parent[k]]);
        }

        System.out.println(ans);
    }
}

