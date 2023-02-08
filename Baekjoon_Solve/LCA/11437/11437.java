import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    // 각 노드별 트리상의 레벨을 찾는 함수
    static void findLevel(int cur, int lv) {
        level[cur] = lv; // 현재 노드의 레벨 정보를 기록
        for (int i=0; i<tree.get(cur).size(); i++) {
            int nxt = tree.get(cur).get(i); // 연결된 다음 노드
            if (level[nxt] == 0) { // 아직 레벨에 기록된 정보가 없으면
                parent[nxt] = cur; // nxt의 부모를 cur로 기록
                findLevel(nxt, lv + 1); // 레벨 + 1하여 dfs 탐색
            }
        }
    }

    // a번 노드와 b번 노드의 LCA를 찾는 함수
    static int LCA(int a, int b) {
        // 두 노드의 레벨이 다를 경우 레벨을 맞춤
        while (level[a] < level[b]) { // b노드의 레벨이 a노드의 레벨보다 크면 b노드의 레벨을 내림
            b = parent[b]; // b의 부모
            if (a == b) { // a와 b의 부모가 같다면, a가 최소 공통 조상
                return a;
            }
        }
        while (level[a] > level[b]) { // a노드의 레벨이 b노드의 레벨보다 크면 a노드의 레벨을 내림
            a = parent[a]; // a의 부모
            if (a == b) { // a와 b의 부모가 같다면, b가 최소 공통 조상
                return b;
            }
        }
        // 레벨이 같은 상태에서 비교 시작
        while (a != b) {
            a = parent[a];
            b = parent[b];
        }
        return a;
    }

    static int N; // 노드 수. 루트는 1번
    static int M; // 쿼리 수
    static int[] level; // i번째 노드별 트리 상의 레벨
    static int[] parent; // i번째 노드별 부모를 기록하기 위한 배열
    static ArrayList<ArrayList<Integer>> tree; // 트리

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        level = new int[N + 1];
        parent = new int[N + 1];
        tree = new ArrayList<>();

        for (int i=0; i<N+1; i++) { // 0 ~ N 인덱스를 가진 트리 생성
            tree.add(new ArrayList<>());
        }

        for (int i=0; i<N-1; i++) { // 트리의 간선(N - 1) 정보 입력
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            tree.get(a).add(b);
            tree.get(b).add(a);
        }

        findLevel(1, 1);

        M = Integer.parseInt(br.readLine());
        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int ret = LCA(u, v);
            bw.write(ret + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}