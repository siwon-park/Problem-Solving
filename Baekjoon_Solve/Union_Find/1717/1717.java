import java.io.*;
import java.util.StringTokenizer;


public class Main {

    static int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        parent[b] = a;
    }

    static int[] parent; // 부모 배열
    static int N, M; // 원소의 수, 쿼리의 수
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        parent = new int[N + 1];
        for (int i=0; i<N+1; i++) {
            parent[i] = i; // 부모를 자기 자신으로 초기화
        }

        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int op = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (op == 0) {
                union(a, b);
            } else {
                if (find(a) == find(b)) {
                    bw.write("YES" + "\n");
                } else {
                    bw.write("NO" + "\n");
                }
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}