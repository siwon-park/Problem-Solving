import java.io.*;

public class Main {

    // 가로로 누을 수 있는 자리 개수를 찾는 함수
    static void findHorizon() {
        char last = 'X'; // 마지막 문자
        int streak; // 연속 횟수
        for (int i = 0; i < N; i++) {
            streak = 0;
            // 중복없이 카운트하는 방법?
            for (int j = 0; j < N; j++) {
                if (map[i].charAt(j) == 'X') { // 'X'가 나왔을 때
                    if (streak >= 2) w += 1; // streak이 2 이상이면 가로로 누울 수 증가
                    streak = 0;
                } else { // '.'이면
                    if (last == 'X') streak = 1; // 마지막이 'X'였다면 streak은 1
                    else streak += 1; // 외에는 streak을 1증가
                }
                last = map[i].charAt(j);
            }
            if (streak >= 2) w += 1;
        }
    }

    // 세로로 누울 수 있는 자리 개수를 찾는 함수
    static void findVertical() {
        char last = 'X';
        int streak;
        for (int j = 0; j < N; j++) {
            streak = 0;
            for (int i = 0; i < N; i++) {
                if (map[i].charAt(j) == 'X') {
                    if (streak >= 2) h += 1;
                    streak = 0;
                } else {
                    if (last == 'X') streak = 1;
                    else streak += 1;
                }
                last = map[i].charAt(j);
            }
            if (streak >= 2) h += 1;
        }
    }

    static int N; // 방의 크기
    static int h, w; // 세로, 가로
    static String[] map; // 방의 정보

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new String[N];

        for (int i = 0; i < N; i++) map[i] = br.readLine();

        findHorizon();
        findVertical();

        System.out.println(w + " " + h);
    }
}