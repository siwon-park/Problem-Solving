// 놀이 공원 (1561번)
/*
  문제: https://www.acmicpc.net/problem/1561
  이분탐색, 매개변수 탐색
  문제 접근법이랑 풀이까지 다 맞았는데, 답이 안 나와서 확인해보니 cnt가 int형, e를 계산시 long으로 캐스팅해주지 않아서
  오버플로우가 발생하고 있었다. e가 오버플로우가 발생하는 건 이해하는데
  cnt를 long형으로 선언하는 건 이해가 처음에 잘 안 갔다. 그런데, mid가 long형이기 때문에 누적하면 cnt도 N을 초과하는 오버플로우가 발생할 수 있다.
  문제 접근 방식은 이렇다. M번 반복했을 때 인원수를 N 이상으로 만드는 가장 작은 시간을 찾는다.
  해당 시간에서 -1을 한 다음 M번 반복했을 때의 인원수를 구하고, time을 기준으로 arr[i]로 나눠 떨어진다면 인원수에 + 1씩 누적하여
  가장 마지막 학생이 타는 놀이 기구 번호를 찾는다.
  N이 M이하면 N을 출력하고, 그 외에는 인원수는 무조건 M명부터 시작한다.
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int binarySearch() {
        if (N <= M) {
            return N;
        }
        int idx = 0;
        long s = 0;
        long e = (long) N * arr[0];
        long time = 0;
        
        while (s <= e) {
            long mid = (s + e) / 2;
            long cnt = M;
            for (int i=0; i<M; i++) {
                cnt += mid / arr[i];
            }
            if (cnt >= N) {
                e = mid - 1;
                time = mid;
            } else {
                s = mid + 1;
            }
        }
        
        int n = M;
        for (int i=0; i<M; i++) {
            n += (time - 1) / arr[i];
        }

        for (int i=0; i<M; i++) {
            if (time % arr[i] == 0) {
                n += 1;
                if (n == N) {
                    idx = i + 1;
                    break;
                }
            }
        }

        return idx;
    }
    
    static int N, M;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<M; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(binarySearch());
    }
}
