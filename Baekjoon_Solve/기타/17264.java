// I AM IRONMAN (17264번)
////////////////////////////////////////////////////////////////////////////////////
  // 문제: https://www.acmicpc.net/problem/17264
  // 자료 구조, 집합과 맵
  // 맵 자료형을 사용해서 조건에 맞게 구현하면 되는 간단한 문제이다.
////////////////////////////////////////////////////////////////////////////////////
import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 총 게임
        int P = Integer.parseInt(st.nextToken()); // 해킹 플레이어 정보
        st = new StringTokenizer(br.readLine());
        int W = Integer.parseInt(st.nextToken()); // 이겼을 때 얻는 점수
        int L = Integer.parseInt(st.nextToken()); // 졌을 때 잃는 점수
        int G = Integer.parseInt(st.nextToken()); // 티어를 벗어나는 점수

        Map<String, Integer> hackedMap = new HashMap<>();
        for (int i=0; i<P; i++) {
            String[] inp = br.readLine().split(" ");
            String player = inp[0];
            String WL = inp[1];
            if (WL.equals("W")) {
                hackedMap.put(player, W);
            } else {
                hackedMap.put(player, -L);
            }
        }

        boolean isIron = true;
        int score = 0;
        for (int i=0; i<N; i++) {
            String player = br.readLine();
            int g = hackedMap.getOrDefault(player, -L);
            score = Math.max(score + g, 0);
            if (score >= G) {
                isIron = false;
            }
        }

        if (!isIron) {
            System.out.println("I AM NOT IRONMAN!!");
        } else {
            System.out.println("I AM IRONMAN!!");
        }

    }
}
