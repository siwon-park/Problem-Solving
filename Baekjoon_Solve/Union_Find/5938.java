import java.io.*;
import java.util.*;

// Daisy Chains in the Field (5938번)
public class Main {

    static int N, M;
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

        parent = new int[N + 1];
        for (int i = 0; i < N + 1; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int c1 = Integer.parseInt(st.nextToken());
            int c2 = Integer.parseInt(st.nextToken());
            union(c1, c2);
        }

        boolean flag = false;
        for (int i = 1; i < N + 1; i++) {
            if (find(i) != 1) {
                flag = true;
                bw.write(i + "\n");
            }
        }

        if (!flag) {
            bw.write("0\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
