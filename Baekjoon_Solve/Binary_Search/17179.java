// 케이크 자르기 (17179번)
///////////////////////////////////////////////////////////////////////////////////
  // 문제: https://www.acmicpc.net/problem/17179
  // 이분 탐색, 매개변수 탐색
  // 파이썬 풀이를 자바로 다시 풀었다. 파이썬은 2296ms가 나왔는데, 자바는 192 ms가 나왔다.
///////////////////////////////////////////////////////////////////////////////////
import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int binarySearch(int s, int e, int C) {
        int opt = 0;
        while (s <= e) {
            int mid = (s + e) / 2;
            int cut = -1;
            int last = 0; // 마지막으로 잘린 지점
            for (int i=0; i<M+1; i++) {
                int curCutPoint = cutPoints[i];
                if (curCutPoint - last >= mid) {
                    cut ++;
                    last = curCutPoint;
                }
            }

            if (cut >= C) {
                s = mid + 1;
                opt = mid;
            } else {
                e = mid - 1;
            }
        }

        return opt;
    }


    static int N;
    static int M;
    static int L;
    static int[] cutPoints;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        cutPoints = new int[M + 1];
        cutPoints[M] = L;

        int start = 1;
        int end = 0;
        for (int i=0; i<M; i++) {
            cutPoints[i] = Integer.parseInt(br.readLine());
            end = Math.max(end, cutPoints[i]);
        }

        for (int j=0; j<N; j++) {
            int cuts = Integer.parseInt(br.readLine());
            int ret = binarySearch(start, end, cuts);
            bw.write(ret + "\n");
        }

        bw.flush();
        br.close();
        bw.close();

    }
}
