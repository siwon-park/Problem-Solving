// 알파벳 개수(10808번)
///////////////////////////////////////////////////////////////
  // 문제: https://www.acmicpc.net/problem/10808
  // 구현, 문자열
  // java에서 딕셔너리 자료형인 해시맵(HashMap)을 처음 써 봤다. 
  // alpha 문자열에서 char형을 바로 String형으로 변환하는 것은 막힘 없이 잘 했지만, 마지막 count 배열 출력에 대해
  // Arrays.toString이 아니라, 공백을 간격으로 두고 일렬로 출력해야해서 어떻게 해야하나 고민하다가 String.join()을 쓰려고 했는데,
  // 타입때문인지 뭔지 컴파일 자체가 불가능해서, StringBuffer를 사용했다.
  // 아직도 기초적인 부분에서 많이 모자란 것 같다. 조금씩 익히고 있긴한데...
///////////////////////////////////////////////////////////////
import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, Integer> map = new HashMap<>();
        int[] count = new int[26];
        String alpha = "abcdefghijklmnopqrstuvwxyz";
        for (int i=0; i<26; i++) {
            map.put(alpha.charAt(i)+"", i);
        }
        String S = br.readLine();
        for (int i=0; i<S.length(); i++) {
            count[map.get(S.charAt(i)+"")] += 1;
        }
        StringBuffer sb = new StringBuffer();
        for (int i=0; i<26; i++) {
            sb.append(count[i]);
            sb.append(" ");
        }
        System.out.println(sb);
    }
}
