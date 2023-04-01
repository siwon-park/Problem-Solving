import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = 1_000_001;
        SegmentTree segmentTree = new SegmentTree(N);
        int n = Integer.parseInt(br.readLine());
        int A, B, C;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            A = Integer.parseInt(st.nextToken());
            if (A == 1) { // 사탕을 꺼내는 경우
                B = Integer.parseInt(st.nextToken()); // 사탕의 순위
                int out = segmentTree.findIdx(1, N, 1, B); // 사탕의 순위
                bw.write(out + "\n");
                segmentTree.update(1, N, 1, out, -1); // 사탕을 꺼냈으니 사탕의 개수 -1개를 해서 업데이트
            } else if (A == 2) { // 특정 맛의 사탕을 넣는 경우
                B = Integer.parseInt(st.nextToken()); // 사탕의 맛
                C = Integer.parseInt(st.nextToken()); // 사탕의 개수
                segmentTree.update(1, N, 1, B, C); // B맛에 해당하는 사탕을 C개 집어 넣음
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}

class SegmentTree {
    int N;
    int[] tree;

    SegmentTree(int N) {
        this.N = N;
        this.tree = new int[N * 4];
    }

    int update(int s, int e, int n, int idx, int val) {
        if (idx < s || e < idx) return tree[n]; // 자기 자신 반환
        if (s == idx && e == idx) {
            tree[n] += val;
            return tree[n];
        }
        int mid = (s + e) / 2;
        tree[n] = update(s, mid, n * 2, idx, val) + update(mid + 1, e, n * 2 + 1, idx, val);
        return tree[n];
    }

    int findIdx(int s, int e, int n, int rank) { // rank번째 인덱스를 찾음
        if (s == e) return s;
        int mid = (s + e) / 2;
        // 트리의 왼쪽에 있는 자식의 수가 rank보다 크면 왼쪽 자식으로 이동해서 인덱스를 찾음
        if (tree[n * 2] >= rank) return findIdx(s, mid, n * 2, rank);
        return findIdx(mid + 1, e, n * 2 + 1, rank - tree[n * 2]); // 오른쪽 자식에서 rank - 왼쪽 자식 수인 곳을 찾음
    }
}