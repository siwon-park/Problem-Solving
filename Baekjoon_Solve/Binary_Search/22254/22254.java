import java.io.*;
import java.util.*;


public class Main {

    static int binarySearch() {
        int K = 1; // 최적 공정의 개수
        int s = 1; // 최소 공정
        int e = N; // 최대 공정
        while (s <= e) {
            int mid = (s + e) / 2; // 현재 공정의 수
            int t = 0; // 총 걸리는 시간

            PriorityQueue<Integer> pq = new PriorityQueue<>();
            for (int i = 0; i < mid; i++) pq.add(arr[i]); // mid개 만큼 공정에 투입
            // 최소 사용 시간인 공정에서 선물의 공정 작업 시간을 뽑아서 현재 선물의 작업 시간을 더해서 공정에 투입
            for (int i = mid; i < N; i++) {
                int x = pq.poll();
                pq.add(x + arr[i]);
                t = Math.max(t, x + arr[i]);
                if (t > X) break; // t가 X보다 크면 break하여 공정의 수를 늘려서 탐색
            }

            if (t <= X) { // 총 작업 시간이 X 이하이면
                e = mid - 1; // 공정의 수를 줄여서 탐색
                K = mid; // 최적 공정을 갱신
            } else s = mid + 1;
        }
        return K;
    }

    static int N, X; // 선물의 개수, 남은 작업 시간
    static int[] arr; // 선물 제작에 필요한 공정 작업 시간
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());

        int k = binarySearch();
        System.out.println(k);
    }
}