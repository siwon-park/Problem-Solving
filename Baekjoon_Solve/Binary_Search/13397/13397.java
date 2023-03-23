import java.io.*;
import java.util.*;


public class Main {

    static int binarySearch() {
        int s = 0; // 구간 차이의 최소
        int e = 10000; // 구간 차이의 최대
        int ans = e;
        while (s <= e) {
            int mid = (s + e) >> 1; // 구간 차이
            int cnt = 1; // 그룹의 수
            int _min = arr[0];
            int _max = arr[0];

            for (int i = 1; i < N; i++) {
                _max = Math.max(_max, arr[i]);
                _min = Math.min(_min, arr[i]);
                if (_max - _min > mid) { // 최대 - 최소가 mid보다 크면 그룹 수를 증가
                    cnt += 1;
                    _max = arr[i]; // 구간의 최대 - 최소는 mid를 넘기면 안 되므로 arr[i]로 재지정
                    _min = arr[i];
                }
            }
            if (cnt <= M) { // 그룹의 수가 M보다 작으면 구간 차이의 최댓값을 mid로 하여 그룹 수 M개를 구성 가능
                e = mid - 1;
                ans = Math.min(ans, mid);
            } else {
                s = mid + 1;
            }
        }

        return ans;
    }

    static int N, M;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
        System.out.println(binarySearch());
    }
}