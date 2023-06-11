// 선분 교차 2 (17387번)
import java.io.*;
import java.util.*;

public class Main {

    static long ccw(int x1, int y1, int x2, int y2, int x3, int y3) { // 좌표 값이 최소 -100 ~ 최대 100만이라 long형 선언
        long tmp = (long) (x2 - x1) * (y3 - y1) - (long) (x3 - x1) * (y2 - y1);
        if (tmp > 0) return 1;
        else if (tmp < 0) return -1;
        return 0;
    }

    static boolean isIntersect(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) {
        // ABC * ABD
        long ab = ccw(x1, y1, x2, y2, x3, y3) * ccw(x1, y1, x2, y2, x4, y4);
        // CDA * CDB
        long cd = ccw(x3, y3, x4, y4, x1, y1) * ccw(x3, y3, x4, y4, x2, y2);
        // 두 선분이 일치하는 경우 체크
        if (ab == 0 && cd == 0) { // (x2, y2) > (x3, y3) and (x4, y4) > (x1, y1)
            // 대소 비교를 위해 점들의 위치를 변경
            int mx1 = Math.min(x1, x2);
            int my1 = Math.min(y1, y2);
            int mx2 = Math.max(x1, x2);
            int my2 = Math.max(y1, y2);

            int mx3 = Math.min(x3, x4);
            int my3 = Math.min(y3, y4);
            int mx4 = Math.max(x3, x4);
            int my4 = Math.max(y3, y4);

            // 변경된 위치로 대소 비교 수행
            if (mx4 >= mx1 && my4 >= my1 && mx2 >= mx3 && my2 >= my3) return true;
            return false;
        }

        return ab <= 0 && cd <= 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int x1 = Integer.parseInt(st.nextToken());
        int y1 = Integer.parseInt(st.nextToken());
        int x2 = Integer.parseInt(st.nextToken());
        int y2 = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int x3 = Integer.parseInt(st.nextToken());
        int y3 = Integer.parseInt(st.nextToken());
        int x4 = Integer.parseInt(st.nextToken());
        int y4 = Integer.parseInt(st.nextToken());

        boolean flag = isIntersect(x1, y1, x2, y2, x3, y3, x4, y4);
        if (flag) System.out.println(1);
        else System.out.println(0);

    }
}