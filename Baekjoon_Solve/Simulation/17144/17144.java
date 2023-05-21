// 미세먼지 안녕! (17144번)
import java.io.*;
import java.util.*;

public class Main {

    static void spread(int[][] _map) {
        int[][] newMap = new int[R][C];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                int cnt = 0; // 퍼진 방향의 수
                if (_map[i][j] / 5 > 0) { // 퍼질 수 있을 경우에만 퍼짐
                    for (int k = 0; k < 4; k++) {
                        int ni = i + dy[k];
                        int nj = j + dx[k];
                        if (ni < 0 || ni >= R || nj < 0 || nj >= C || _map[ni][nj] == -1) continue;
                        cnt += 1;
                        newMap[ni][nj] += _map[i][j] / 5;
                    }
                }
                newMap[i][j] += (_map[i][j] - (_map[i][j] / 5) * cnt);
            }
        }
        // 배열 복사
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                _map[i][j] = newMap[i][j];
            }
        }
    }

    /*
    * 문제 설명과 다르게 위에 있는 공기 청정기가 반시계, 아래 있는 공기 청정기가 시계 방향으로 돌게함
    * */
    static void circulate(Pair pair, int w) {
        int y = pair.y;
        int x = pair.x;
        int k = w;
        int a = w == 0 ? 1 : -1;
        int rotate = 0;
        while (true) {
            int ny = y + dy[k];
            int nx = x + dx[k];
            if (inRange(pair, ny, nx, w)) {
                k = (k + 4 + a) % 4;
                rotate += 1;
                if (rotate == 4) break;
                ny = y + dy[k];
                nx = x + dx[k];
            }
            if (map[y][x] == -1) map[ny][nx] = 0;
            else {
                if (map[ny][nx] != -1) {
                    map[y][x] = map[ny][nx];
                    map[ny][nx] = 0;
                }
            }
            y = ny;
            x = nx;
        }
    }

    static boolean inRange(Pair pair, int ny, int nx, int w) {
        if (w == 0) { // 시계 방향
            if (ny < 0 || ny > pair.y || nx < 0 || nx >= C) return true;
            else return false;
        } else { // 반시계 방향
            if (ny < pair.y || ny >= R || nx < 0 || nx >= C) return true;
            else return false;
        }
    }

    static int R, C, T; // 행, 열, 시간
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static int[][] map; // 방 안의 상태
    static Pair[] airFilter; // 공기 청정기 위치

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        map = new int[R][C];
        airFilter = new Pair[2];
        int k = 0;
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == -1) airFilter[k++] = new Pair(i, j);
            }
        }

        int t = 0;
        while (t++ < T) {
            spread(map);
            circulate(airFilter[0], 0);
            circulate(airFilter[1], 2);
        }

        int ans = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] > 0) ans += map[i][j];
            }
        }

        System.out.println(ans);
    }
}

class Pair {
    int y;
    int x;
    Pair(int y, int x) {
        this.y = y;
        this.x = x;
    }
}