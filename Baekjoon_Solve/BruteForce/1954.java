// 화학실험(1954번)
//////////////////////////////////////////////////////////////////////////////////////////////
  // 문제: https://www.acmicpc.net/problem/1954
  // 브루트포스
  // ax+b가 모두 같아야 하므로 첫번째 ax1 + b 등식 x1에 0부터 M까지 담아서 나온 가스 값이
  // 나머지 등식의 결과와 같아야하므로, x의 값을 구할 수 있다. 해당 x 값을 모든 등식에 대해서 누적해서 계산했을 때
  // 정확히 M이 된다면 발생하는 가스값을 출력하고, 아니면 0을 출력하면 된다.
  // 자바는 나눴을 때 나머지를 버리므로, 비교를 위해 double형을 사용하였다.
  // totalM 과 M을 비교할 때는 totalM이 double형이므로, M에 double로 캐스팅해줬어야 했는데, totalM을 int형으로 캐스팅해서 비교하는 실수를 범하고 있었다.
//////////////////////////////////////////////////////////////////////////////////////////////
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static class Pair {
        int a;
        int b;
        Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }

    static int n;
    static Pair[] arr;
    static int M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new Pair[n];
        for (int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[i] = new Pair(a, b);
        }

        M = Integer.parseInt(br.readLine());
        int GAS = 0;
      
        for (int m=0; m<=M; m++) {
            int a1 = arr[0].a;
            int b1 = arr[0].b;
            double totalM = m; // 화학 용액의 총량(double형 사용)
            int gas = a1 * m + b1; // 발생 가스량
          
            for (int i=1; i<n; i++) {
                int a = arr[i].a;
                int b = arr[i].b;
                totalM += ((gas - b) / (double) a); // double형으로 결과가 나오기 위해 a를 double형으로 캐스팅해줌
                if (totalM > (double) M) { // (int)totalM > M으로 잘못 비교하고 있었다...
                    break;
                }
            }

            if (totalM == (double) M) { // (int)totalM == M으로 잘못 비교하고 있었다...
                GAS = gas;
                break;
            }
        }
      
        System.out.println(GAS);
        br.close();
    }
}
