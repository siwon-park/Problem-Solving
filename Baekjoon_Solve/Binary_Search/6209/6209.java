// 제자리 멀리뛰기 (6209번)
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int binarySearch() {
        int s = 1;
        int e = d;
        int jump = d;
        while (s <= e) {
            int mid = (s + e) / 2; // 점프할 수 있는 최소 거리의 최댓값
            int cnt = 0; // 제거한 돌의 개수
            int last = 0; // 마지막으로 점프한 곳의 위치
            for (int i = 0; i < n + 1; i++) {
                if (arr[i] - last < mid) {
                    cnt += 1;
                } else {
                    last = arr[i];
                }
            }

            if (cnt > m) { // 제거한 돌의 개수가 m개 보다 크면
                e = mid - 1;
            } else { // 제거한 돌의 개수가 m개 이하면 최소 거리의 최대를 늘림
                s = mid + 1;
                jump = mid;
            }
        }
        return jump;
    }

    static int d, n, m; // 탈출구까지의 거리, 섬의 수, 제거 가능한 돌의 수
    static int[] arr; // 섬이 떨어진 거리

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        d = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n + 1];
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(br.readLine());
        arr[n] = d;
        Arrays.sort(arr);

        int ret = binarySearch();
        System.out.println(ret);
    }
}