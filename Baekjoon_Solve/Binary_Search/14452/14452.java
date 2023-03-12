import java.io.*;
import java.util.*;


public class Main {

    static int binarySearch() {
        int ans = 1; // 필요한 최소 무대 수
        int s = 1;
        int e = N;
        while (s <= e) {
            int mid = (s + e) / 2; // 현재 무대 수
            int t = 0; // 총 춤춘 시간
            PriorityQueue<Integer> pq = new PriorityQueue<>(); // 우선 순위 큐
            for (int i = 0; i < mid; i++) { // mid 마리의 소를 무대에 투입
                pq.add(arr[i]);
            }

            for (int i = mid; i < N; i++) {
                int d = pq.poll();
                pq.add(arr[i] + d); // 마지막 소가 춤을 마치고 나온 시간 + 현재 소의 춤 시간을 삽입
                t = Math.max(t, arr[i] + d);
            }

            if (t <= T) { // 총 시간이 T이하일 경우
                e = mid - 1; // 무대 크기를 줄여서 탐색
                ans = mid; // 최적 무대 크기 기록
            } else {
                s = mid + 1; // 무대 크기를 늘려서 탐색
            }
        }
        return ans;
    }

    static int N, T; // 소의 수, 최대 제한 시간
    static int[] arr; // 소의 춤 추는 시간
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        arr = new int[N];
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(br.readLine());

        int ret = binarySearch();
        System.out.println(ret);
    }
}