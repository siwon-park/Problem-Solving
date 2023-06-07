// 선분 그룹 (2162번)
import java.io.*;
import java.util.*;

public class Main {

    /*
    * counter clock wise
    * */
    static long ccw(Pair a, Pair b, Pair c) {
        // (x2 - x1) * (y3 - y1) - (x3 - x1) * (y2 - y1)
        return (long) (b.x - a.x) * (c.y - a.y) - (long) (c.x - a.x) * (b.y - a.y);
    }

    static boolean isIntersect(Pair a, Pair b, Pair c, Pair d) {
        long ab = ccw(a, b, c) * ccw(a, b, d);
        long cd = ccw(c, d, a) * ccw(c, d, b);
        if (ab == 0 && cd == 0) { // 두 선분이 일직선 상에 있을 경우 추가 확인 -> 점들의 위치만 확인
            // 각 점들이 일직선 상에 있는 것이기 때문에 대소 비교 가능
            if (!compare(a, b)) {
                Pair tmp = b;
                b = a;
                a = tmp;
            }
            if(!compare(c, d)) {
                Pair tmp = d;
                d = c;
                c = tmp;
            }
            return compare(c, b) && compare(a, d);
        }
        return ab <= 0 && cd <= 0; // ccw의 결과를 곱한 값들이 각 각 음수이면 교차
    }

    static boolean compare(Pair a, Pair b) {
        if (a.x > b.x) return false; // x좌표가 더 크면 false
        else if (a.x < b.x) return true; // x좌표가 더 작으면 true
        else { // 같을 경우
            if (a.y > b.y) return false; // y좌표가 더 크면 false
            else if (a.y < b.y) return true;
            else return true; // y좌표가 더 작으면 true;
        }
    }

    static int find(int x) {
        if (parent[x] != x) parent[x] = find(parent[x]);
        return parent[x];
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a < b) parent[b] = a;
        else parent[a] = b;
    }

    static int[] parent;
    static Pair[][] lines;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        parent = new int[N];
        lines = new Pair[N][2];
        StringTokenizer st;
        int x1, y1, x2, y2;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            x1 = Integer.parseInt(st.nextToken());
            y1 = Integer.parseInt(st.nextToken());
            x2 = Integer.parseInt(st.nextToken());
            y2 = Integer.parseInt(st.nextToken());
            lines[i][0] = new Pair(x1, y1);
            lines[i][1] = new Pair(x2, y2);
            parent[i] = i;
        }

        for (int i = 0; i < N - 1; i++) {
            Pair a = lines[i][0];
            Pair b = lines[i][1];
            for (int j = i + 1; j < N; j++) {
                Pair c = lines[j][0];
                Pair d = lines[j][1];
                // 두 선분이 교차하면 find로 부모를 확인 후 union
                if (isIntersect(a, b, c, d)) {
                    if (find(i) != find(j)) union(i, j);
                }
            }
        }

        for (int i = 0; i < N; i++) find(i);

        int cnt = 0; // 가장 큰 그룹의 선분의 수
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < N; i++) {
            hashMap.computeIfPresent(parent[i], (k, v) -> v + 1);
            hashMap.putIfAbsent(parent[i], 1);
            cnt = Math.max(hashMap.get(parent[i]), cnt);
        }

        System.out.println(hashMap.size());
        System.out.println(cnt);
    }
}

class Pair {
    int x;
    int y;

    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}