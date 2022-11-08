// 트럭 주차 (2979번)
/////////////////////////////////////////////////////////////////////////////////////
  // 문제: https://www.acmicpc.net/problem/2979
  // 구현, 시뮬레이션
  // 주어진 조건에 맞게 구현하면 된다.
  // parked 배열을 만들고 해당 시간대에 주차한 트럭의 수를 기록한 다음, 요금표에 맞게 트럭 대수 x 주차 요금의 합을 계산하면 된다.
/////////////////////////////////////////////////////////////////////////////////////
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] parked = new int[101];
    static int fee = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        for (int i=0; i<3; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int arv = Integer.parseInt(st2.nextToken());
            int dpt = Integer.parseInt(st2.nextToken());
            for (int j=arv; j<dpt; j++ ) {
                parked[j] += 1;
            }
        }

        for (int i=1; i<101; i++) {
            if (parked[i] == 3) {
                fee += 3 * C;
            } else if (parked[i] == 2) {
                fee += 2 * B;
            } else if (parked[i] == 1) {
                fee += A;
            }
        }

        System.out.println(fee);
        br.close();
    }
}
