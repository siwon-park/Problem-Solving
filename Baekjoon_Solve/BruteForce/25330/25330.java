import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static class Pair implements Comparable<Pair>{
        int a;
        int b;
        Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public int compareTo(Pair o) {
            if (this.a > o.a) {
                return 1;
            } else if (this.a < o.a) {
                return -1;
            } else {
                return Integer.compare(this.b, o.b);
            }
        }
    }

    static void backtrack(int idx, int k, int acc, int save) {
        ans = Math.max(ans, save);
        if (idx == N) {
            return;
        }

        if (k - pairs[idx].a - acc < 0) { // 체력이 다하여 마을 사람을 구할 수 없음
            return;
        }
        // 현재 마을에서 사람을 구하지 않음
        backtrack(idx + 1, k, acc, save);

        // 현재 마을에서 사람을 구함
        backtrack(idx + 1, k - acc - pairs[idx].a, acc + pairs[idx].a, save + pairs[idx].b);
    }

    static int N, K; // 몬스터의 수, 초기 체력
    static Pair[] pairs;

    static int ans; // 해방 가능한 주민 수
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        int[] A = new int[N];
        int[] P = new int[N];
        pairs = new Pair[N];

        st = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st2.nextToken());
            pairs[i] = new Pair(A[i], P[i]);
        }

        Arrays.sort(pairs, Pair::compareTo);
        backtrack(0, K, 0, 0);
        System.out.println(ans);
    }
}
