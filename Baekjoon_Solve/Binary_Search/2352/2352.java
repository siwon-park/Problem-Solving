import java.io.*;
import java.util.StringTokenizer;


public class Main {

    static int lowerBound(int[] arr, int e, int target) {
        int s = 0;
        int idx = e + 1;
        while (s <= e) {
            int mid = (s + e) / 2;
            if (target <= arr[mid]) {
                e = mid - 1;
                idx = mid;
            } else {
                s = mid + 1;
            }
        }
        return idx;
    }

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] LIS = new int[N];
        int l = 0;
        LIS[l] = arr[0];
        l += 1;
        for (int i=1; i<N; i++) {
            int num = arr[i];
            // LIS의 마지막 요소보다 크면 바로 삽입
            if (LIS[l - 1] < num) {
                LIS[l] = num;
                l += 1;
            } else { // 아니라면 조건 분기하여 lowerBound로 넣을 곳을 찾아 교환
                int idx = lowerBound(LIS, l - 1, num);
                if (num < LIS[idx]) {
                    LIS[idx] = num;
                }
            }
        }
        System.out.println(l);
    }
}