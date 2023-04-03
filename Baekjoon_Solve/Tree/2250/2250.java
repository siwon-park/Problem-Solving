import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static void inOrder(int n, int lv) { // 중위 순회
        if (n == -1) return;
        inOrder(tree[n][0], lv + 1);
        MAX_LV = Math.max(MAX_LV, lv);
        maxWeigth[lv] = Math.max(maxWeigth[lv], ++w); // 최대 너비 갱신
        minWeigth[lv] = Math.min(minWeigth[lv], w); // 최소 너비 갱신
        inOrder(tree[n][1], lv + 1);
    }

    static int MAX, w, MAX_LV;
    static int[] minWeigth, maxWeigth, parent; // 트리의 레벨, 무게, 부모 배열
    static int[][] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        MAX = N;
        w = 0;
        MAX_LV = 0;
        tree = new int[N + 1][2];
        parent = new int[N + 1];
        maxWeigth = new  int[N + 1];
        Arrays.fill(maxWeigth, Integer.MIN_VALUE);
        minWeigth = new  int[N + 1];
        Arrays.fill(minWeigth, Integer.MAX_VALUE);

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken()); // 부모
            int c1 = Integer.parseInt(st.nextToken()); // 왼쪽 자식
            int c2 = Integer.parseInt(st.nextToken()); // 오른쪽 자식
            tree[p][0] = c1;
            tree[p][1] = c2;
            if (c1 != -1) parent[c1] = p;
            if (c2 != -1) parent[c2] = p;
        }

        // 루트 구하기
        int root = N;
        while (parent[root] > 0) {
            root = parent[root];
        }

        inOrder(root, 1);

        int lv = 0;
        int maxW = 0;
        for (int i = 1; i <= MAX_LV; i++) {
            if (minWeigth[i] == Integer.MAX_VALUE || maxWeigth[i] == Integer.MAX_VALUE) continue;
            if (maxWeigth[i] - minWeigth[i] + 1 > maxW) {
                maxW = maxWeigth[i] - minWeigth[i] + 1;
                lv = i;
            }
        }

        System.out.println(lv + " " + maxW);
    }
}