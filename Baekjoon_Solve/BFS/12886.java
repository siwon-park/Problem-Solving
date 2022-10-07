// 돌 그룹(12886번)
//////////////////////////////////////////////////////////////////////////////////
  // 문제: https://www.acmicpc.net/problem/12886
  // BFS
//////////////////////////////////////////////////////////////////////////////////
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static class Pair {
        int first;
        int second;
        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    static int bfs(int first, int second, int third) {
        int total = first + second + third;
        int[][] visited = new int[total + 1][total + 1];
        if (first == second && second == third) {
            return 1;
        }

        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(first, second));

        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            int frst = pair.first;
            int scnd = pair.second;
            int thrd = total - frst - scnd;

            if (frst == scnd && scnd == thrd) {
                return 1;
            }

            if (frst != scnd) {
                int X = Math.min(frst, scnd);
                int Y = Math.max(frst, scnd);

                int minValue = Math.min(Math.min(X + X, Y - X), thrd);
                int maxValue = Math.max(Math.max(X + X, Y - X), thrd);

                if (minValue >= 0 && maxValue <= total && visited[minValue][maxValue] == 0) {
                    visited[minValue][maxValue] = 1;
                    queue.add(new Pair(minValue, maxValue));
                }

            }

            if (scnd != thrd) {
                int X = Math.min(scnd, thrd);
                int Y = Math.max(scnd, thrd);

                int minValue = Math.min(Math.min(X + X, Y - X), frst);
                int maxValue = Math.max(Math.max(X + X, Y - X), frst);

                if (minValue >= 0 && maxValue <= total && visited[minValue][maxValue] == 0) {
                    visited[minValue][maxValue] = 1;
                    queue.add(new Pair(minValue, maxValue));
                }

            }

            if (frst != thrd) {
                int X = Math.min(frst, thrd);
                int Y = Math.max(frst, thrd);

                int minValue = Math.min(Math.min(X + X, Y - X), scnd);
                int maxValue = Math.max(Math.max(X + X, Y - X), scnd);

                if (minValue >= 0 && maxValue <= total && visited[minValue][maxValue] == 0) {
                    visited[minValue][maxValue] = 1;
                    queue.add(new Pair(minValue, maxValue));
                }

            }
        }

        return 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        System.out.println(bfs(A, B, C));

        br.close();
    }
}
