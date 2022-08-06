// 주사위 세개(2480번)
////////////////////////////////////////////////////
  // 문제: https://www.acmicpc.net/problem/2480
  // 수학, 사칙연산
  // count배열(arr)을 통해 해결하였음
////////////////////////////////////////////////////
import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        StringTokenizer st = new StringTokenizer(s);
        int n1 = Integer.parseInt(st.nextToken());
        int n2 = Integer.parseInt(st.nextToken());
        int n3 = Integer.parseInt(st.nextToken());
        int[] arr = new int[7];
        arr[n1] += 1;
        arr[n2] += 1;
        arr[n3] += 1;
        int last = 0;
        for (int i=1; i<7; i++) {
            if (arr[i] >= 2) {
                last = i;
                break;
            } else if (arr[i] != 0) {
                last = i;
            }
        }
        if (arr[last] == 3){
            System.out.println(10000+last*1000);
        } else if (arr[last] == 2) {
            System.out.println(1000+last*100);
        } else {
            System.out.println(last*100);
        }
    }
}
