// 주사위 게임 (5566번)
///////////////////////////////////////////////////////////////////////////////
  // 문제: https://www.acmicpc.net/problem/5566
  // 구현, 시뮬레이션
  // 주어진 조건에 따라 진행하면 되는 문제
  // N을 넘었을 때도, N에 도착한 것인 것과 지시사항은 각 칸에 도착했을 때 한번만 따른다는 것을 유의해야한다.
///////////////////////////////////////////////////////////////////////////////
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] A;
    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = new int[N];
        for (int i=0; i<N; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }

        int cur = 0; // 현재 위치
        int[] D = new int[M];
        for (int i=0; i<M; i++) {
            D[i] = Integer.parseInt(br.readLine());
        }

        for (int i=0; i<M; i++) {
            cur += D[i];
            if (cur >= N - 1) {
                System.out.println(i + 1);
                break;
            }
            cur += A[cur];
            if (cur >= N - 1) {
                System.out.println(i + 1);
                break;
            }
        }
        
        br.close();
    }
}
