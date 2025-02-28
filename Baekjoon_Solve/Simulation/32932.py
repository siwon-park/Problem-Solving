import java.io.*;
import java.util.*;

// 드론 조작 (32932번)
public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int x = 500;
        int y = 500;
        boolean[][] arr = new boolean[x + 501][y + 501];
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 장애물
        int K = Integer.parseInt(st.nextToken()); // 명령의 수
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int xi = Integer.parseInt(st.nextToken());
            int yi = Integer.parseInt(st.nextToken());
            arr[xi + 500][yi + 500] = true;
        }

        String ord = br.readLine();
        for (int i = 0; i < ord.length(); i++) {
            char c = ord.charAt(i);
            int nx = x;
            int ny = y;
            switch (c) {
                case 'L':
                    nx = x - 1;
                    break;
                case 'R':
                    nx = x + 1;
                    break;
                case 'U':
                    ny = y + 1;
                    break;
                case 'D':
                    ny = y - 1;
                    break;
            }
            if (!arr[nx][ny]) { // 장애물이 아닐 경우
                x = nx;
                y = ny;
            }
        }

        System.out.println((x - 500) + " " + (y - 500));

    }
}

