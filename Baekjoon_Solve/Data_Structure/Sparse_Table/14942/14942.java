// 개미 (14942번)
import java.io.*;
import java.util.*;

public class Main {

    static void dfs(int cur, int d) {
        distance[cur] = d;
        for (int i = 0; i < graph.get(cur).size(); i++) {
            Pair pair = graph.get(cur).get(i);
            if (distance[pair.nxt] == -1) {
                parent[pair.nxt][0] = cur;
                dfs(pair.nxt, d + pair.c);
            }
        }
    }

    static void setParent() {
        parent[1][0] = 1; // 1번의 부모는 1
        for (int k = 0; k < LOG - 1; k++) {
            for (int n = 1; n < N + 1; n++) {
                if (parent[n][k] != -1) parent[n][k + 1] = parent[parent[n][k]][k];
            }
        }
    }

    static int findNearest(int a) {
        int curHP = ant[a]; // 현재 체력
        while (curHP > 0) {
            int b, diff;
            int last = curHP; // 순회 전 체력
            for (int i = LOG - 1; i >= 0; i--) {
                b = parent[a][i];
                diff = distance[a] - distance[b];
                if (curHP - diff >= 0) {
                    curHP -= diff;
                    a = parent[a][i];
                }
            }
            if (last == curHP) break; // 무한 루프 방지
        }
        return a; // 중요! 현재 체력으로 a까지만 갈 수 있음. parent[a][0]을 반환하면 현재 체력으로 못 갈 수도 있음
    }

    static final int LOG = 18; // 2 ^ 17 = 13만
    static int N; // 방의 개수
    static int[] ant; // 개미의 초기 체력
    static int[] distance; // 1번 방까지의 거리
    static int[][] parent; // 부모 배열
    static ArrayList<ArrayList<Pair>> graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        ant = new int[N + 1];
        parent = new int[N + 1][LOG];
        distance = new int[N + 1];
        Arrays.fill(distance, -1);
        Arrays.fill(parent[0], -1);

        graph = new ArrayList<>();
        graph.add(new ArrayList<>());
        for (int i = 1; i < N + 1; i++) {
            ant[i] = Integer.parseInt(br.readLine());
            graph.add(new ArrayList<>());
            Arrays.fill(parent[i], -1);
        }

        StringTokenizer st;
        int a, b, c;
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            graph.get(a).add(new Pair(b, c));
            graph.get(b).add(new Pair(a, c));
        }

        dfs(1, 0);
        setParent();

        for (int i = 1; i < N + 1; i++) {
            bw.write(findNearest(i) + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}

class Pair {
    int nxt;
    int c;

    Pair(int nxt, int c) {
        this.nxt = nxt;
        this.c = c;
    }
}