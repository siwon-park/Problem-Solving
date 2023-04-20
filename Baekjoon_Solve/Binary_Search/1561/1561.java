import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int binarySearch() {
        if (N <= M) {
            return N;
        }
        
        int idx = 0;
        long s = 0;
        long e = (long) N * arr[0];
        long time = 0;
        
        while (s <= e) {
            long mid = (s + e) / 2;
            long cnt = M;
            for (int i=0; i<M; i++) {
                cnt += mid / arr[i];
            }
            if (cnt >= N) {
                e = mid - 1;
                time = mid;
            } else {
                s = mid + 1;
            }
        }
        
        int n = M;
        for (int i=0; i<M; i++) {
            n += (time - 1) / arr[i];
        }

        for (int i=0; i<M; i++) {
            if (time % arr[i] == 0) {
                n += 1;
                if (n == N) {
                    idx = i + 1;
                    break;
                }
            }
        }
        
        return idx;
    }

    static int N, M;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<M; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(binarySearch());
    }
}