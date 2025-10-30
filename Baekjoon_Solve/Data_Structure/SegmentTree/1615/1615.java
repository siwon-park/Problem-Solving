// 교차개수세기 (1615번)
import java.io.*;
import java.util.*;

public class Main {

    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = read();
        M = read();

        int[][] pairList = new int[M][2];
        for (int i = 0; i < M; i++) {
            int s = read();
            int e = read();
            pairList[i][0] = s;
            pairList[i][1] = e;
        }

        // s가 빠른 순, s가 크다면 e가 빠른 순으로 정렬
        Arrays.sort(pairList, (o1, o2) -> {
            if (o1[0] > o2[0]) return 1;
            else if (o1[0] < o2[0]) return -1;
            else return Integer.compare(o1[1], o2[1]);
        });

        FenwickTree fenwickTree = new FenwickTree(N);
        long ans = 0;
        for (int i = 0; i < M; i++) {
            fenwickTree.update(pairList[i][1]); // pair.s와 pair.e를 잇는 간선을 추가 (pair.e 지점에 += 1)
            ans += fenwickTree.count(N) - fenwickTree.count(pairList[i][1]);
        }

        bw.write(ans + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private static int read() throws IOException {
        int n = 0;
        int i;
        while ((i = System.in.read()) >= '0') {
            n = (n << 3) + (n << 1) + (i & 15);
        }
        return n;
    }
}


class FenwickTree {
    long[] tree;
    int size;

    FenwickTree(int n) {
        this.tree = new long[n + 1];
        this.size = n + 1;
    }

    void update(int i) {
        while (i < size) {
            tree[i] += 1;
            i += (i & -i);
        }
    }

    long count(int i) {
        long ans = 0;
        while (i > 0) {
            ans += tree[i];
            i -= (i & -i);
        }
        return ans;
    }
}
