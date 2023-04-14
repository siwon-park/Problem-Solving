import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static void backtrack(int t, int score) {
        if (t == 10) { // 턴이 10턴이면 종료
            maxScore = Math.max(maxScore, score);
            return;
        }
        int d = dice[t]; // 현재 주사위의 눈

        for (int i = 0; i < 4; i++) {
            if (position[i] == 21) continue; // 해당 말이 도착 칸에 있으면 무시
            int tmp = position[i];
            int m = move(position[i], d);
            if (m > 0) { // 이동할 수 있으면
                position[i] = m;
                backtrack(t + 1, score + scores[position[i]]);
                position[i] = tmp;
            }
        }
    }

    static int move(int cur, int cnt) {
        while (cnt-- > 0) {
            cur = board[cur]; // 다음 위치로 계속 이동
            if (cur == 21) return 21; // 도착했으면 21 반환
        }
        if (cur == 5) cur = 22;
        else if (cur == 10) cur = 26;
        else if (cur == 15) cur = 29;
        for (int i = 0; i < 4; i++) {
            if (position[i] == cur) return 0; // 이미 다른 말이 도착한 곳이면 0
        }
        return cur; // 도착 가능한 위치 반환
    }

    static int maxScore = 0;
    static int[] dice, position, scores, board;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        position = new int[4]; // 말들의 위치
        dice = new int[10]; // 매 턴 나온 주사위의 눈
        board = new int[36]; // 36개의 격자 노드에 대한 연결 관계
        scores = new int[36]; // 각 격자판의 점수

        for (int i = 0; i < 10; i++) dice[i] = Integer.parseInt(st.nextToken());

        int s = 0;
        for (int i = 0; i < 21; i++) {
            board[i] = i + 1; // 정방향 이동
            scores[i] = s;
            s += 2;
        }

        for (int i = 22; i < 35; i++) {
            board[i] = i + 1;
        }

        s = 10;
        for (int i = 22; i < 26; i++) {
            scores[i] = s;
            s += 3;
        }

        s = 20;
        for (int i = 26; i < 29; i++) {
            scores[i] = s;
            s += 2;
        }

        s = 30;
        scores[29] = s--;
        for (int i = 30; i < 34; i++) {
            scores[i] = --s;
        }

        scores[34] = 30;
        scores[35] = 35;
        board[35] = 20; // 35번 다음으로 20번 노드로 이동
        board[25] = 33; // 25번 다음으로 33번 노드로 이동
        board[28] = 33; // 28번 다음으로 33번 노드로 이동
        board[32] = 33; // 32번 다음으로 33번 노드로 이동

        backtrack(0, 0);
        System.out.println(maxScore);
    }
}