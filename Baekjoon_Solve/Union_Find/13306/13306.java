import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

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

    static int N, Q; // 정점의 수, 쿼리의 수
    static int[] parent; // 부모 배열
    static Query[] queries;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        parent = new int[N + 1];
        for (int i = 0; i < N + 1; i++) parent[i] = i; // 부모 배열 초기화(루트는 항상 1)

        int[] tree = new int[N + 1]; // 트리 상의 연결 관계 배열
        for (int i = 1; i < N ; i++) {
            int p = Integer.parseInt(br.readLine()); // 정점 i + 1의 부모
            tree[i + 1] = p; // 트리 상의 부모 관계를 저장
        }

        Q += (N - 1); // 쿼리 수에 N - 1을 더함
        Stack<Query> queries = new Stack<>(); // 쿼리 번호를 기준으로 역순으로 뽑기 위해 스택 사용
        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()); // 쿼리의 종류
            Query query = new Query(x);

            if (x == 0) { // 연결을 끊음
                query.a = Integer.parseInt(st.nextToken());
            } else if (x == 1) { // 연결 경로 존재 확인
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                query.a = a;
                query.b = b;
            }

            queries.push(query);
        }


        Stack<String> stack = new Stack<>(); // 쿼리 결과를 다시 역순으로 담을 스택
        while(!queries.isEmpty()) {
            Query query = queries.pop();
            if (query.x == 0) { // 연결을 끊는 쿼리는 연결을 하는 쿼리로 변경하여 동작
                int c = query.a; // 자식
                int p = tree[c]; // 부모
                union(p, c); // 연결
            } else { // 정점간 연결을 확인
                int p1 = find(query.a); // a의 부모
                int p2 = find(query.b); // b의 부모
                if (p1 == p2) stack.push("YES");
                else stack.push("NO");
            }
        }

        // 쿼리를 역순 정렬했으니, 다시 역순으로 버퍼에 담아서 출력함
        while (!stack.isEmpty()) {
            bw.write(stack.pop() + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}

class Query {
    int x; // 쿼리 종류
    int a;
    int b;

    Query(int x) {
        this.x = x;
    }
}