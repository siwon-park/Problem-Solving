import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 카드의 수
        int m = Integer.parseInt(st.nextToken()); // 카드를 합체하는 수

        st = new StringTokenizer(br.readLine());
        long[] arr = new long[n];
        long ans = 0L; // 총합
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
            ans += arr[i];
            pq.add(arr[i]);
        }

        while (m-- > 0) { // 카드 합체 놀이를 m번 반복
            // 우선순위 큐에서 요소를 2개 뽑아서 더한 값을 ans에 더함
            long a = pq.poll();
            long b = pq.poll();
            long sum = a + b;
            pq.add(sum);
            pq.add(sum);
            ans += (sum);
        }

        System.out.println(ans);
    }
}