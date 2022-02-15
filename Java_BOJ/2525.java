// 오븐 시계(2525번)
//////////////////////////////////////////////////////////////////
  // 문제: https://www.acmicpc.net/problem/2525
  // 수학, 사칙연산
  // 분(B)에 대해서는 나머지 연산을 제대로 적용시켰으나, 처음에 시간(A)에 대해서 그냥 A >= 24: A=0;으로 했어서 틀렸음
  // 생각해보니 입력으로 들어오는 요리시간(C)가 1000까지도 들어올 수 있기 때문에 A %= 24가 맞는 수식이었음
//////////////////////////////////////////////////////////////////
import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String s = br.readLine();
        StringTokenizer st = new StringTokenizer(s);
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(br.readLine());
        B += C;
        if (B >= 60) {
            A+=B/60;
            A%=24;
            B%=60;
            System.out.println(A+" "+B);
        } else {
            System.out.println(A+" "+B);
        }
    }
}
