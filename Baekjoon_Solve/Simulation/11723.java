// 집합(11723번)
///////////////////////////////////////////////////
  // 문제: https://www.acmicpc.net/problem/11723
  // 구현, 비트마스킹
  // 명령에 따른 행동을 그대로 구현하면 되는 문제
  // 문제를 푸는 도중에 다 풀고 출력이 분명 나와야하는데 안 나와서 당황했다.
  // bw.write(arr[n]); bw.newLine(); (또는 bw.write("\n"))을 했는데 bw.flush();를 하니 공백만 줄바꿈으로 출력되는 것을 볼 수 있었다.
  // 그래서 어쩌다가 bw.write(arr[n]+"\n")을 해보니까 의도했던대로 정상 출력이 되서 문제는 해결했지만, 처음의 코드는 왜 안 됐는지 궁금해서 검색해보았다.
  // 검색 결과 bw.write에 대해 잘 모르는 부분이 있어서 생겼던 문제였다.
  // bw.write에 정수값만 넣을 경우 char형으로 변환시키기 때문에 char형에 해당하는 숫자가 아닐 경우 제대로 출력되지 않는다.
  // 따라서 문자열로 값을 변경해줘서 write를 해주면 원하는대로 정수를 버퍼에 입력하여 출력할 수 있다.
  // 쉬운 문제라서 그냥 무난하게 풀릴 줄 알았는데, 의도치 않게 몰랐던 새로운 부분을 배울 수 있어서 좋았다.
  // 그대로 bw.write(arr[n]+"\n")로 처음부터 썼다면 아마 몰랐을 것이다. 
///////////////////////////////////////////////////
import java.io.*;
import java.util.*;

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int[] arr = new int[21];
    int M = Integer.parseInt(br.readLine());
    for (int i=0; i<M; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      String order = st.nextToken();
      if (order.equals("add")) {
        int n = Integer.parseInt(st.nextToken());
        arr[n] = 1;
      } else if (order.equals("remove")) {
        int n = Integer.parseInt(st.nextToken());
        if (arr[n] == 1) {
          arr[n] = 0;
        }
      } else if (order.equals("check")) {
        int n = Integer.parseInt(st.nextToken());
        bw.write(arr[n]+"\n"); // bw.write에 only 정수값만 넣으면 원하는대로 출력 X
        // ex) bw.write(65) -> (char)'A'가 출력됨
        // 의도한대로 정수를 출력하려면 bw.write(num+"");와 같이 String형으로 변환해주면 된다. 
      } else if (order.equals("toggle")) {
        int n = Integer.parseInt(st.nextToken());
        if (arr[n] == 1) {
          arr[n] = 0;
        } else {
          arr[n] = 1;
        }
      } else if (order.equals("all")) {
        int[] all_arr = {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        arr = all_arr;
      } else {
        arr = new int[21];
      }
    }
    br.close();
    bw.flush();
    bw.close();
  }
}
