// 회의실 배정 (1931번)
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine()); // 회의의 수
        Pair[] arr = new Pair[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int sTime = Integer.parseInt(st.nextToken()); // 회의 시작 시간
            int eTime = Integer.parseInt(st.nextToken()); // 회의 종료 시간
            arr[i] = new Pair(sTime, eTime);
        }

        // 끝나는 시간을 우선으로 정렬
        Arrays.sort(arr, (o1, o2) -> {
            if (o1.eTime > o2.eTime) return 1;
            else if (o1.eTime < o2.eTime) return -1;
            else return Integer.compare(o1.sTime, o2.sTime);
        });

        int cnt = 0; // 회의 최대 개수
        int lastEnd = 0; // 마지막으로 회의가 끝난 시간

        for (int i = 0; i < N; i++) {
            Pair pair = arr[i];
            if (pair.sTime >= lastEnd) {
                cnt += 1;
                lastEnd = pair.eTime;
            }
        }

        System.out.println(cnt);
    }
}

class Pair {
    int sTime;
    int eTime;

    Pair(int sTime, int eTime) {
        this.sTime = sTime;
        this.eTime = eTime;
    }
}