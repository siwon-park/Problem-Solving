import java.io.*;
import java.util.StringTokenizer;


public class Main {

    static int binarySearch() {
        int s = 0;
        int e = totalScore;
        int max = 0;
        while (s <= e) {
            int mid = (s + e) / 2; // 시험지 그룹의 최솟값
            int groups = 0; // 그룹의 수
            int score = 0; // 그룹의 시험 점수
            for (int i = 0; i < N; i++) {
                score += X[i];
                if (score >= mid) {
                    groups += 1;
                    score = 0;
                }
            }
            if (groups >= K) { // 그룹의 수가 K 이상이면, 시험지 그룹의 최솟값을 늘림
                max = mid;
                s = mid + 1;
            } else { // 그룹 수가 K보다 작으면, 시험지 그룹의 최솟값을 줄임
                e = mid - 1;
            }
        }
        return max;
    }

    static int N, K, totalScore; // 시험지의 개수, 시험지의 그룹 수, 모든 시험지 점수의 합
    static int[] X; // 시험지의 점수
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        X = new int[N];
        totalScore = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            X[i] = Integer.parseInt(st.nextToken());
            totalScore += X[i];
        }
        if (K > 1) {
            totalScore /= (K - 1);
        }

        int maxScore = binarySearch();
        System.out.println(maxScore);

    }
}