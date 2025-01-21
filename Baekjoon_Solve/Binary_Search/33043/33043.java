import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static HashMap<String, Integer> hashMap;
    static String[] mazaks;

    static int binarySearch() {
        int x = -1;
        // x장의 패 중에 같은 패가 5장 이상
        if (N <= 4) return x; // 5장 미만이면 이변을 절대 눈치 못챔
        hashMap = new HashMap<>();
        for (int i = 0; i < 5; i++) {
            hashMap.computeIfPresent(mazaks[i], (k, v) -> v + 1);
            hashMap.putIfAbsent(mazaks[i], 1);
        }
        if (hashMap.size() == 1) return 5; // 해시맵의 크기가 1이면 5개 모두 같은 카드
        int s = 5;
        int e = N;
        while (s <= e) {
            int mid = (s + e) / 2;
            boolean flag = false;
            hashMap = new HashMap<>();
            for (int i = 0; i < mid; i++) {
                hashMap.computeIfPresent(mazaks[i], (k, v) -> v + 1);
                hashMap.putIfAbsent(mazaks[i], 1);
                if (hashMap.get(mazaks[i]) >= 5) { // 다섯장 이상이면 true
                    flag = true;
                }
            }

            for (int i = mid; i < N; i++) {
                // i - mid 위치의 마작 패를 제거
                hashMap.computeIfPresent(mazaks[i - mid], (k, v) -> v - 1);
                if (hashMap.get(mazaks[i - mid]) == 0) {
                    hashMap.remove(mazaks[i - mid]);
                }
                // mid 위치의 마작을 넣음
                hashMap.computeIfPresent(mazaks[i], (k, v) -> v + 1);
                hashMap.putIfAbsent(mazaks[i], 1);
                if (hashMap.get(mazaks[i]) >= 5) {
                    flag = true;
                }
            }

            if (flag) {
                e = mid - 1;
                x = mid;
            } else {
                s = mid + 1;
            }
        }
        return x;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        mazaks = new String[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            mazaks[i] = st.nextToken();
        }

        System.out.println(binarySearch());

    }
}

