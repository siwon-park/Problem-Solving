import java.io.*;
import java.util.StringTokenizer;


public class Main {

    static void sort(int s, int e) {
        if (s >= e) return;
        int mid = (s + e) >> 1;
        sort(s, mid);
        sort(mid + 1, e);
        merge(s, e, mid);
    }

    static void merge(int s, int e, int mid) {
        int i = s;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= e) {
            if (arr[i] <= arr[j]) tmp[k++] = arr[i++];
            else tmp[k++] = arr[j++];
        }

        while (i <= mid) tmp[k++] = arr[i++];
        while (j <= e) tmp[k++] = arr[j++];

        for (i = s; i <= e; i++) {
            arr[i] = tmp[i - s];
            save++;
            if (save == K) {
                for (int t = 0; t < N; t++) sb.append(arr[t] + " ");
            }
        }
    }

    static int N, K, save;
    static int[] arr, tmp;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        save = 0;
        arr = new int[N];
        tmp = new int[N];
        sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        sort(0, N - 1);

        if (save < K) sb.append(-1);
        System.out.println(sb);
    }
}