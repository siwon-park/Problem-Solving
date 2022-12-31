// 배부른 마라토너 (10546번)
/*
  문제: https://www.acmicpc.net/problem/10546
  맵, 집합
  동명 이인이 있을 수도 있다고 했으므로, String을 키로, Integer를 값으로 가지는 Map을 선언한다.
  만약 완주자가 다 들어왔는데도, Map에 값이 1로 남아있는 키가 있으면 해당 키를 출력하면 된다.
*/

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Map<String, Integer> map = new HashMap<>();
        for (int i=0; i<N; i++) {
            String name = br.readLine();
            if (map.get(name) == null) {
                map.put(name, 1);
            } else {
                int v = map.get(name);
                map.put(name, v + 1);
            }
        }

        for (int i=0; i<N-1; i++) {
            String finished = br.readLine();
            int v = map.get(finished);
            map.replace(finished, v - 1);
        }

        for (String name : map.keySet()) {
            if (map.get(name) == 1) {
                System.out.println(name);
                break;
            }
        }

    }
}
