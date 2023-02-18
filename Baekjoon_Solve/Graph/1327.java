// 소트 게임 (1327번)

/*
  문제: https://www.acmicpc.net/problem/1327
  BFS, 맵(해시 테이블)
  직접 순열을 구성하면서 순열:번호(0부터 시작)의 구조를 가지는 해시 테이블을 만든다.
  순열의 크기만큼 방문 배열을 선언한다.
  (해시테이블의 값에 해당하는 번호로 방문 배열을 체크한다.)
  BFS탐색을 통해 K개의 수를 뒤집을 수 있는 인덱스까지 반복문을 돌리면서 순열(뒤집은 문자열)에 대한 값을 방문 체크한다.
  이 때, 이미 방문한 순열이면 큐에 삽입하지 않는다.
  방문하면서 0번째 순열에 해당하는 값에 방문하면 최솟값을 출력 return 한다.
  (0번째 순열이 1 ~ N까지의 수를 오름차순 정렬한 것이기 때문)
  
  진짜 말도 안 되게 억까 당했는데, import java.util.*;로 import하니 LinkedList에서 non-generic관련 타입 추론 에러가 났고
  import java.util.LinkedList;로 명시적으로 import하니 성공적으로 컴파일 되었다.
  중요한 것은 이게 인텔리제이 버그였던 것이고, 버그인지 모른 채 30분동안 에러를 잡으려고 시간을 투자하였다...
  백준에서는 import java.util.*;로도 컴파일해도 통과한다
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.*;

public class Main {

    static class Pair {
        String str;
        int cnt;
        Pair(String str, int cnt) {
            this.str = str;
            this.cnt = cnt;
        }
    }

    static void permutation(int k, String arr) {
        if (k == N) {
            map.put(arr, M++);
            return;
        }
        for (int i=1; i<=N; i++) {
            if (!check[i - 1]) {
                check[i - 1] = true;
                permutation(k + 1, arr + Integer.valueOf(i));
                check[i - 1] = false;
            }
        }
    }


    static String reverseStr(String s, int idx) {
        String reversed = "";
        for (int i=idx+K-1; i>=idx; i--) {
            reversed += s.charAt(i) + "";
        }
        if (idx + K < N) {
            return s.substring(0, idx) + reversed + s.substring(idx + K, N);
        }
        return s.substring(0, idx) + reversed;
    }

    static int bfs(String s) {
        Queue<Pair> queue = new LinkedList<>();
        boolean[] visited = new boolean[M];
        queue.add(new Pair(s, 0));
        visited[map.get(s)] = true;
        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            if (map.get(pair.str) == 0) {
                return pair.cnt;
            }
            // K개를 뒤집을 수 있을 때까지 반복
            for (int i=0; i<=N-K; i++) {
                String newS = reverseStr(pair.str, i);
                if (!visited[map.get(newS)]) {
                    visited[map.get(newS)] = true;
                    queue.add(new Pair(newS, pair.cnt + 1));
                }
            }
        }
        return -1;
    }

    static int N, K, M; // N, K, M(순열의 개수)
    static Map<String, Integer> map = new HashMap<>();
    static boolean[] check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        check = new boolean[N];

        String start = "";
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            start += st.nextToken();
        }

        permutation(0, "");
        int ret = bfs(start);
        System.out.println(ret);
    }
}
