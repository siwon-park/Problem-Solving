// 오셀로 재배치 (13413번)
/*
  문제: https://www.acmicpc.net/problem/13413
  그리디
  바꿔야할 색의 개수를 기록한 다음
  더 큰 바꿔야할 개수를 출력하면 된다.
*/
import java.io.*;
public class Main {

    static int T;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        T = Integer.parseInt(br.readLine());
        for (int i=0; i<T; i++) {
            int N = Integer.parseInt(br.readLine());
            String start = br.readLine();
            String target = br.readLine();
            int total = 0;
            int bCnt = 0;
            int wCnt = 0;
            for (int j=0; j<N; j++) {
                if (start.charAt(j) != target.charAt(j)) {
                    if (target.charAt(j) == 'B') {
                        bCnt++;
                    } else {
                        wCnt++;
                    }
                }
            }
            int ans = (bCnt >= wCnt) ? bCnt : wCnt;
            bw.write(ans + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
