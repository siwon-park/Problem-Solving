// 베스트셀러(1302번)
//////////////////////////////////////////////////////////////////////////////////////////////
  // 문제: https://www.acmicpc.net/problem/1302
  // 정렬, 맵
  // 정말 오랜만에 풀어보는 자바 알고리즘 풀이이다.
  // 오랜만에 풀다보니 어떻게 뭘 사용해야하는지 완전히 까먹었다. 쉬운 문제는 앞으로 자바로 풀어야겠다.
  // 자바 정렬, 콜렉션 사용에 대해 정리를 한다고 한다고 했지만 아직도 안했다.
  // 람다랑 스트림도 정리가 필요해보인다. 물론 알고리즘은 자바가 아니라 파이썬으로 풀겠지만,
  // 스프링을 사용해야하기 때문에 자바에 대한 감을 잃지 않도록 연습해야겠다.
//////////////////////////////////////////////////////////////////////////////////////////////
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map.Entry;
import java.util.*;

public class Main {

  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    Map<String, Integer> map = new TreeMap<>();
    for (int i=0; i<N; i++) {
      String seller = br.readLine();
      // map에 키와 값 쌍을 담음
      if (map.get(seller) == null) {
        map.put(seller, 1);
      } else {
        map.put(seller, map.get(seller) + 1);
      }
    }
    List<Entry<String, Integer>> entryList = new ArrayList<Entry<String, Integer>>(map.entrySet());

    Collections.sort(entryList, new Comparator<Entry<String, Integer>>() {
      public int compare(Entry<String, Integer> obj1, Entry<String, Integer> obj2) {
        return obj2.getValue().compareTo(obj1.getValue());
      }
    });

    for (Entry<String, Integer> entry: entryList) {
      System.out.println(entry.getKey());
      break;
    }
  }
}
