// 꼬인 전깃줄 (1365번)
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int lowerBound(int[] A, int s, int e, int target) {
        int idx = 0;
        while (s <= e) {
            int mid = (s + e) / 2;
            if (target <= A[mid]) { // (target >= A[mid]) => upperbound
                e = mid - 1; // s = mid + 1;
                idx = mid;
            } else {
                s = mid + 1;
            }
        }
        return idx;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr[0] = Integer.parseInt(st.nextToken());
        int cnt = 0;
        int idx = 0;
        for (int i=1; i<N; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (arr[idx] < num) { // 현재 가장 끝 인덱스에 있는 숫자와 비교하여
                arr[++idx] = num; // 그 다음 인덱스로 숫자를 삽입함
            } else {
                int indx = lowerBound(arr, 0, idx, num);
                arr[indx] = num;
                cnt += 1;
            }
        }

        System.out.println(cnt);
    }
}
