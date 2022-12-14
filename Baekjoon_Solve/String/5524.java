// 입실 관리 (5524번)
////////////////////////////////////////////////////////////////////////////
  // 문제: https://www.acmicpc.net/problem/5524
  // 문자열
  // 입력받은 문자열을 소문자로 치환하면 되는 문제
////////////////////////////////////////////////////////////////////////////
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for (int i=0; i<N; i++) {
            String name = br.readLine();
            System.out.println(name.toLowerCase());
        }
    }
}
