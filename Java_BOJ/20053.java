// 최소, 최대 2(20053번)
/////////////////////////////////////////////////////
  // 문제: https://www.acmicpc.net/problem/20053
  // 구현
  // 간단한 최대 최소를 찾는 문제, 이번엔 bw.write에서 실수 하지 않았다.
  // 길이 N인 배열을 String[] 배열로 한번에 받아왔고, 비교때만 정수형으로 변환하였다.
/////////////////////////////////////////////////////
import java.io.*;

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int T = Integer.parseInt(br.readLine());
    for (int i=0; i<T; i++) {
      int N = Integer.parseInt(br.readLine());
      String[] arr = br.readLine().split(" ");
      int maxValue = -1000001;
      int minValue = 1000001;
      for (int j=0; j<N; j++) {
        int num = Integer.parseInt(arr[j]);
        if (num > maxValue) {
          maxValue = num;
        } if (num < minValue) {
          minValue = num;
        }
      }
      bw.write(minValue+" "+maxValue+"\n");
    }
    br.close();
    bw.flush();
    bw.close();
  }
}
