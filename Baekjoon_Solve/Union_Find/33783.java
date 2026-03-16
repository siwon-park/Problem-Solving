// Friends (33783번)
import java.io.*;
import java.util.*;

public class Main {
    
    static int N, M, S;
    static int[] parent;

    static int find(int x) {
        if (parent[x] != x) parent[x] = find(parent[x]);
        return parent[x];
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a < b) parent[b] = a;
        else parent[a] = b;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        parent = new int[N];
        for (int i = 0; i < N; i++) parent[i] = i;

        String line;
        for (int i = 0; i < M; i++) {
            line = br.readLine();
            if (line == null || line.isBlank()) continue;
            st = new StringTokenizer(line);
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            union(u, v);
        }

        boolean flag = true;
        int s = find(S);
        for (int i = 0; i < N; i++) {
            int p = find(i);
            if (p != s) {
                flag = false;
                break;
            }
        }

        if (!flag) {
            System.out.println("no");
        } else {
            System.out.println("yes");
        }

    }
}
