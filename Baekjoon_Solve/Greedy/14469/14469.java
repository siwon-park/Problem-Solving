// 소가 길을 건너간 이유 3 (14469번)
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine()); // 소의 정보
        Pair[] arr = new Pair[N];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int arrive = Integer.parseInt(st.nextToken());
            int waiting = Integer.parseInt(st.nextToken());
            arr[i] = new Pair(arrive, waiting);
        }

        Arrays.sort(arr, (o1, o2) -> {
            if (o1.arrive > o2.arrive) return 1;
            else if (o1.arrive < o2.arrive) return -1;
            else return Integer.compare(o1.waiting, o2.waiting);
        });

        int last = 0;
        for (int i = 0; i < N; i++) {
            Pair pair = arr[i];
            if (last < pair.arrive) last = pair.arrive + pair.waiting;
            else last += pair.waiting;
        }

        System.out.println(last);

    }
}

class Pair {
    int arrive;
    int waiting;

    Pair(int arrive, int waiting) {
        this.arrive = arrive;
        this.waiting = waiting;
    }
}