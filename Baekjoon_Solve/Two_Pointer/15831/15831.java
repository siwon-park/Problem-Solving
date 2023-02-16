import java.io.*;
import java.util.StringTokenizer;


public class Main {

    static void solve(String line) {
        int b = 0; // 현재 검은 조약돌의 수
        int w = 0;// 현재 흰 조약돌의 수
        int s = 0; // 시작 지점
        int e = 0; // 끝 지점
        if (line.charAt(0) == 'W') {
            w = 1;
        } else {
            b = 1;
        }
        while (e < N) {
            // 현재 검은 조약돌이 최대 검은 조약돌 이하, 현재 흰 조약돌이 최소 흰 조약돌 이상이면 최대 길이 갱신
            if (b <= BCnt && w >= WCnt) {
                ans = Math.max(ans, e - s + 1);
            }
            // 현재 검은 조약돌이 최대 검은 조약돌보다 크면 시작 포인터를 오른쪽으로 옮김
            if (b > BCnt) {
                if (line.charAt(s) == 'W') {
                    w -= 1;
                } else {
                    b -= 1;
                }
                s += 1;
            }
            // 조약돌 개수에 상관없이 끝 포인터를 오른쪽으로 옮김
            e += 1;
            if (e < N) {
                if (line.charAt(e) == 'W') {
                    w += 1;
                } else {
                    b += 1;
                }
            }
        }
    }

    static int N, BCnt, WCnt; // 전체 조약돌의 수, 검은 조약돌의 최대 수, 흰 조약돌의 최소 수
    static int ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        BCnt = Integer.parseInt(st.nextToken());
        WCnt = Integer.parseInt(st.nextToken());
        String line = br.readLine();
        solve(line);
        System.out.println(ans);
    }
}
