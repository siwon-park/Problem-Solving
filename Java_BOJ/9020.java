// 골드바흐의 추측(9020번)
////////////////////////////////////////////////////////////
  // 문제: https://www.acmicpc.net/problem/9020
  // 수학, 에라토스테네스의 체
  // 먼저 에라토스테네스의 체를 구한 뒤에, 이를 활용하여 해당 정수 N의 1/2 + 1 범위까지 탐색하여 더했을 때 정수 N을 이루는 두 소수를 찾았음
  // 탐색에서 비효율이 조금 존재하는지, 속도는 빠른 편이 아니었음
  // for 구문안에서 int p1 이런식으로 p1에 대해 처음 선언을 하고, p1을 for구문 완전 종료 이후 밖에서 선언하면 cannot be resolved to a variable 에러가 발생함
  // 아마 for구문 안에서 p1에 대해 최초로 선언하면 for구문의 지역변수로 보는 듯하다... 밖에서 int p1 선언후 for 구문 안에서 p1에 대해 갱신후 밖에서 출력하는 것은 가능함.
////////////////////////////////////////////////////////////
import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 에라토스테네스의 체
        boolean[] prime = new boolean[10001];
        prime[0] = true;
        prime[1] = true;
        for (int i=2; i<10001; i++) {
            if (!prime[i]) {
                int j = 2;
                while (i*j < 10001) {
                    prime[i*j] = true;
                    j += 1;
                }
            }
        }
        int T = Integer.parseInt(br.readLine());
        int p1 = 0;
        int p2 = 0;
        for (int i=0; i<T; i++) {
            int n = Integer.parseInt(br.readLine());
            for (int p=2; p<n/2+1; p++) {
                if (!prime[p] && !prime[n-p]) {
                    p1 = p; // 이 부분에서 int p1 = p; 이렇게 선언하였을 경우 for 구문을 빠져나와서 p1을 출력하려면 "cannot be resolved to a variable"오류가 뜸
                    p2 = n-p;
                }
            }
            System.out.println(p1+" "+p2);
        }
        br.close();
    }
}
