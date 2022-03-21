// 대소문자 바꾸기(2744번)
///////////////////////////////////////////////////////
  // 문제: https://www.acmicpc.net/problem/2744
  // 문자열
  // 처음에 틀렸습니다가 나왔는데, 자세히보니 작거나 같음, 크거나 같음으로 했어야했는데, 크고 작음으로 비교하고있었다.
  // 문자열에서 문자형을 떼어와서 정수형으로 만들고 문자형과 크기를 비교하여 대/소문자 변환을 해주었음 
///////////////////////////////////////////////////////
import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    String s = br.readLine();
    int N = s.length();
    for (int i=0; i<N; i++) {
      int ss = s.charAt(i);
      String l = s.charAt(i)+"";
      if ('a' <= ss && ss <= 'z') {
        bw.write(l.toUpperCase());
      } else {
        bw.write(l.toLowerCase());
      }
    }
    br.close();
    bw.flush();
    bw.close();
  }
}
