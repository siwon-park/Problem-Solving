// 터렛(1002번)
/////////////////////////////////////////////////////
  // 문제: https://www.acmicpc.net/problem/1002
  // 수학
  // 처음에 double형 자료를 쓰고, 막 했는데 생각해보니 굳이 루트 씌워서 할 필요없이 제곱인 상태에서 비교하면
  // int형끼리 비교가 가능하므로 따로 형변환을 해줄 필요가 없었다.
  // 두 원을 그렸을 때, 일치하는 점의 갯수를 반환하는 문제이다. 두 원이 같을 경우에는 무한대이므로 -1을 반환한다.
/////////////////////////////////////////////////////
import java.io.*;

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int T = Integer.parseInt(br.readLine());
    for (int i=0; i<T; i++) {
      String[] arr = br.readLine().split(" ");
      int x1 = Integer.parseInt(arr[0]);
      int y1 = Integer.parseInt(arr[1]);
      int r1 = Integer.parseInt(arr[2]);
      int x2 = Integer.parseInt(arr[3]);
      int y2 = Integer.parseInt(arr[4]);
      int r2 = Integer.parseInt(arr[5]);
      int a = Math.abs(x1-x2)*Math.abs(x1-x2);
      int b = Math.abs(y1-y2)*Math.abs(y1-y2);
      int d = a+b;
      int r = (r1+r2)*(r1+r2);
      if (r1 == r2 && x1 == x2 && y1 == y2) {
        bw.write(-1+"\n");
      } else if (d == r || d == (r1-r2)*(r1-r2)) {
        bw.write(1+"\n");
      } else if (d < (r1-r2)*(r1-r2) || d > r) {
        bw.write(0+"\n");
      } else {
        bw.write(2+"\n");
      }
    }
    bw.flush();
    bw.close();
    br.close();  
  }
}
