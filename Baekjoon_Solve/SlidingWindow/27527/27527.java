import java.io.*;
import java.util.*;

// 배너 걸기 (27527번)
public class Main {

    static int N, M;
    static int[] arr;
    static HashMap<Integer, Integer> hashMap = new HashMap<>();

    static int greaterEqual(int m) {
        int val = 9 * m;
        if (val % 10 == 0) return val / 10;
        else return (val / 10) + 1;
    }

    static String slide() {
        int leastCnt = greaterEqual(M); // 최소 필요 동일 개수
        for (int i = 0; i < M; i++) {
            int cur = arr[i];
            hashMap.computeIfPresent(cur, (k, v) -> v + 1);
            hashMap.putIfAbsent(cur, 1);
            if (hashMap.get(cur) >= leastCnt) {
                return "YES";
            }
        }

        int s = 0;
        for (int e = M; e < N; e++) {
            int start = arr[s];
            hashMap.computeIfPresent(start, (k, v) -> v - 1);
            int end = arr[e];
            hashMap.computeIfPresent(end, (k, v) -> v + 1);
            hashMap.putIfAbsent(end, 1);
            if (hashMap.get(end) >= leastCnt) {
                return "YES";
            }
            s += 1;
        }

        return "NO";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        String ans = slide();
        System.out.println(ans);

    }
}
