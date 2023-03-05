import java.io.*;
import java.util.StringTokenizer;


public class Main {

    static int binarySearch() {
        int minGreed = 0; // 최소 질투
        int s = 1;
        int e = MAX;
        // 아이들은 항상 같은 색상의 보석만 가져간다. 모두 다 보석을 갖지 못해도 된다.
        while (s <= e) {
            int mid = (s + e) >> 1; // 질투심
            int cnt = 0;
            for (int i = 0; i < M; i++) cnt += K[i] % mid == 0 ? K[i] / mid : (K[i] / mid) + 1;
            if (cnt <= N) { // 보석을 가진 아이들 수가 N보다 작거나 같으면
                e = mid - 1; // 질투심을 더 줄여서 탐색해본다
                minGreed = mid; // 최소 질투심 갱신
            } else {
                s = mid + 1;
            }
        }
        return minGreed;
    }

    static int N, M; // 아이들의 수, 색상의 수
    static int MAX = 0;
    static int[] K; // i번째 보석의 개수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = new int[M];
        for (int i = 0; i < M; i++) {
            K[i] = Integer.parseInt(br.readLine());
            MAX = Math.max(MAX, K[i]);
        }
        System.out.println(binarySearch());
    }
}