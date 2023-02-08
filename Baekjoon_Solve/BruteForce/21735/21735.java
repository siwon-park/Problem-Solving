import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static void snowballing(int pos, int left, int size) {
        ans = Math.max(ans, size); // 눈덩이의 최댓값 갱신
        if (left == 0 || pos == N) { // 남은 대회 시간이 0이거나 끝에 도달했으면 종료
            return;
        }
        if (pos + 1 <= N) {
            // 현재 위치(pos) + 1칸 굴림 -> 크기: 현재 크기 + a[pos + 1]로 변화
            snowballing(pos + 1, left - 1, size + a[pos + 1]);
        }
        if (pos + 2 <= N) {
            // 현재 위치 + 2칸 굴림 -> 크기: 현재 크기 절반 + a[pos + 2]로 변화(절반 계산 시 소수점 절삭)
            snowballing(pos + 2, left - 1, size / 2 + a[pos + 2]);
        }
    }

    static int N; // 앞마당의 길이
    static int M; // 대회 시간
    static int[] a; // 눈덩이 -> i에 쌓여있는 눈덩이
    static int ans = 1; // 눈덩이의 최댓값

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        a = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i=1; i<=N; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        snowballing(0, M, 1); // 시작 위치 0, 남은 시간, 눈덩이 크기 1
        System.out.println(ans);
    }
}
