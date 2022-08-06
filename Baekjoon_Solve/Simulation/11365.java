// !밀비 급일(11365번)
//////////////////////////////////////////////////////////////////
  // 문제: https://www.acmicpc.net/problem/11365
  // 문자열, 구현
  // java에서 처음 해보는 문자열 뒤집기였다.
  // for 구문을 이용해 빈 문자열에 문자열을 한줄씩 뒤에서 부터 받아와서 bw에 저장해서 출력하였다.
  // 다른 사람 풀이를 참조해보니, 문자열을 뒤집는데 더 쉬운 방법인 메서드가 있었다.
  // StringBuffer의 reverse() 메서드인데, 사용하면 StringBuffer에 있는 문자열들을 모두 뒤집는 기능을 보여준다.
  // 코드도 훨씬 간단하고 깔끔해서 보기 좋다. 덕분에 또 새로운 것을 배울 수 있었다.
//////////////////////////////////////////////////////////////////
import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    while (true) {
      String s = br.readLine();
      if (s.equals("END")){
        break;
      }
      String rvrs = "";
      int n = s.length();
      for (int i=n-1; i>-1; i--){
        rvrs += s.charAt(i);
      }
      bw.write(rvrs);
      bw.newLine();
    }
    br.close();
    bw.flush();
    bw.close();
  }
}
/////////////////////// 다른 사람의 풀이(StringBuffer의 reverse()메서드 사용) //////////////////////
import java.io.*;
import java.util.*;
public class Main {
	public static String str;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			str = br.readLine();
			if(str.equals("END"))break;
			StringBuilder sb = new StringBuilder();
			sb.append(str);
			System.out.println(sb.reverse());
		}
		
	}
}
