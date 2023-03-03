import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static void sort(int s, int e) {
        if (s >= e) return;
        int mid = (s + e) >> 1;
        sort(s, mid);
        sort(mid + 1, e);
        merge(s, mid, e);
    }

    static void merge(int s, int mid, int e) {
        int i = s;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= e) {
            if (arr[i] <= arr[j]) {
                tmp[k++] = arr[i++];
            }
            else tmp[k++] = arr[j++];
        }

        while (i <= mid) tmp[k++] = arr[i++];
        while (j <= e) tmp[k++] = arr[j++];

        for (i = s; i <= e; i++) {
            arr[i] = tmp[i - s];
            save ++;
            if (save == K) ans = arr[i];
        }
    }

    static int ans, K, save;
    static int[] arr, tmp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 배열의 크기
        K = Integer.parseInt(st.nextToken()); // 저장횟수
        arr = new int[N];
        tmp = new int[N];
        save = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        sort(0, N - 1);

        System.out.println(save < K ? -1 : ans);
    }
}