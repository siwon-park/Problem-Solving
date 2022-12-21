// 물통 (2251번)
/*
  문제: https://www.acmicpc.net/problem/2251
  BFS, DFS
  자바로 풀어본 문제
  Math.min, max 사용에서 이게 맞나 순간 고민을 너무 많이 했다.
  if문으로 조건분기했으면 간단했지만, 간단하게라도 수학적으로 생각하고자 다음과 같이 코드를 작성하였다.
*/
import java.io.*;
import java.util.*;
import java.util.LinkedList;

public class Main {

    static class Pair {
        int a;
        int b;
        int c;

        Pair(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }

    static void bfs(int a, int b, int c) {
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(a, b, c));
        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            if (pair.a == 0) {
                arr.add(pair.c);
            }
            if (!visited[Math.max(pair.a + pair.b - B, 0)][Math.min(pair.a + pair.b, B)]) { // A에서 B에게 물을 줌
                visited[Math.max(pair.a + pair.b - B, 0)][Math.min(pair.a + pair.b, B)] = true;
                queue.add(new Pair(Math.max(pair.a + pair.b - B, 0), Math.min(pair.a + pair.b, B), pair.c));
            }
            if (!visited[Math.max(pair.a + pair.c - C, 0)][pair.b]) { // A에서 C에게 물을 줌
                visited[Math.max(pair.a + pair.c - C, 0)][pair.b] = true;
                queue.add(new Pair(Math.max(pair.a + pair.c - C, 0), pair.b, Math.min(pair.a + pair.c, C)));
            }
            if (!visited[Math.min(pair.a + pair.b, A)][Math.max(pair.a + pair.b - A, 0)]) { // B에서 A에게 물을 줌
                visited[Math.min(pair.a + pair.b, A)][Math.max(pair.a + pair.b - A, 0)] = true;
                queue.add(new Pair(Math.min(pair.a + pair.b, A), Math.max(pair.a + pair.b - A, 0), pair.c));
            }
            if (!visited[pair.a][Math.max(pair.b + pair.c - C, 0)]) { // B에서 C에게 물을 줌
                visited[pair.a][Math.max(pair.b + pair.c - C, 0)] = true;
                queue.add(new Pair(pair.a, Math.max(pair.b + pair.c - C, 0), Math.min(pair.b + pair.c, C)));
            }
            if (!visited[Math.min(pair.a + pair.c, A)][pair.b]) { // C에서 A에게 물을 줌
                visited[Math.min(pair.a + pair.c, A)][pair.b] = true;
                queue.add(new Pair(Math.min(pair.a + pair.c, A), pair.b, Math.max(pair.c - A - pair.a, 0)));
            }
            if (!visited[pair.a][Math.min(pair.b + pair.c, B)]) {  // C에서 B에게 물을 줌
                visited[pair.a][Math.min(pair.b + pair.c, B)] = true;
                queue.add(new Pair(pair.a, Math.min(pair.b + pair.c, B), Math.max(pair.c - B - pair.b, 0)));
            }
        }
    }


    static boolean[][] visited = new boolean[201][201]; // A와 B에 물이 들어있을 때, C의 양
    static ArrayList<Integer> arr = new ArrayList<>();
    static int A, B, C;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        visited[0][0] = true;
        bfs(0, 0, C);
        Collections.sort(arr);
        for (int i=0; i<arr.size(); i++) {
            bw.write(arr.get(i) + " ");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
