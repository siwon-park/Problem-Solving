// 애너그램(6996번)
////////////////////////////////////////////////////////////////
  // 문제: https://www.acmicpc.net/problem/6996
  // 문자열, 구현
  // 각 단어별로 알파벳이 몇 번 등장했는지 카운트 배열을 만들고 카운트를 한 다음
  // 26개의 인덱스에서 카운트 숫자가 모두 일치한다면 애너그램을 만들 수 있다.
  // char형은 int로 만들 수 있는 것을 알았기 때문에 이를 활용해서 문제를 풀 수 있었다.
////////////////////////////////////////////////////////////////
import java.io.*;
import java.util.*;

public class Main {
  public static void main (String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int T = Integer.parseInt(br.readLine());
    for (int tc=0; tc<T; tc++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      // 각 단어별로 알파벳이 몇 번 등장했는지 카운트
      int[] count1 = new int[26];
      int[] count2 = new int[26];
      String s1 = st.nextToken();
      String s2 = st.nextToken();
      for (int j=0; j<s1.length(); j++) {
        int n = s1.charAt(j);
        n -= 97;
        count1[n] += 1;
      }
      for (int j=0; j < s2.length(); j++) {
        int n = s2.charAt(j);
        n -= 97;
        count2[n] += 1;
      }
      boolean flag = true;
      for (int i=0; i<26; i++) {
        if (count1[i] != count2[i]) {
          flag = false;
        }
      }
      if (!flag) {
        bw.write(s1+" & "+s2+" are NOT anagrams.\n");
      } else {
        bw.write(s1+" & "+s2+" are anagrams.\n");
      }
    }
    bw.flush();
    bw.close();
    br.close();
  }
}
