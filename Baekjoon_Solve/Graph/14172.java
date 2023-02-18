// Moocast (14172번)
/*
  문제: https://www.acmicpc.net/problem/14172
  DFS
  재귀 호출을 할 때 ret 값을 잘못 계산하고 있었다.
  dfs(k, ret + 1) 형태로 호출하면서 파라미터로 ret 인자를 전달해줬기 때문에
  방문할 때마다 1씩 누적되는 것이 아니라, ret인 상태로 새롭게 방문하고 있었다.
  ret을 static 변수로 선언하고 dfs 최초 호출 전에 ret을 0으로 초기화시켜줬고,
  함수의 파라미터로 전달하는 것이 아니라 dfs 안에서 ret을 매번 += 1씩 누적시켜주면서
  ans의 최댓값을 ret과 비교하여 갱신하였다.
  1 <= N <= 200이므로, 최 800만번 연산하기 때문에 O(200^3)의 시간 복잡도로 통과할 수 있다.
*/
import java.io.*;
import java.util.*;

public class Main {

    static class Pair {
        int x;
        int y;
        int p;
        Pair(int x, int y, int p) {
            this.x = x;
            this.y = y;
            this.p = p;
        }
    }

    static void dfs(int cur) {
        ans = Math.max(ans, ret);
        for (int k=0; k<N; k++) {
            if (!visited[k] && isReachable(cur, k)) {
                visited[k] = true;
                ret += 1;
                dfs(k); // dfs(k, ret + 1)
            }
        }
    }

    static boolean isReachable(int cur, int nxt) {
        Pair pair1 = pairs[cur];
        Pair pair2 = pairs[nxt];
        int _x = Math.abs(pair1.x - pair2.x);
        int _y = Math.abs(pair1.y - pair2.y);
        return _x * _x + _y * _y <= pair1.p * pair1.p;
    }

    static Pair[] pairs;
    static boolean[] visited;
    static int N, ans, ret;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        pairs = new Pair[N];

        StringTokenizer st;
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            pairs[i] = new Pair(x, y, p);
        }

        for (int i=0; i<N; i++) {
            visited = new boolean[N];
            ret = 0;
            dfs(i);
        }
        System.out.println(ans);
    }
}
