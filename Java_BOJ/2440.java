// 별 찍기 - 3 (2440번)
///////////////////////////////////////////////////////////
  // 문제: https://www.acmicpc.net/problem/2440
  // 별찍기 문제 시리즈를 BufferedReader, BufferedWriter를 사용해서 풀어보았다.(이전 시리즈에서는 Scanner 및 System.out.println 사용)
///////////////////////////////////////////////////////////
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        for (int i=N; i>0; i--) {
            String s = "";
            for (int j=0; j<i; j++) {
                s += "*";
            }
            bw.write(s);
            bw.newLine();
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
