import java.io.*;
import java.util.StringTokenizer;


public class Main {

    static int MAX = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            int [] scores = new int[201]; // 각 팀별 점수 합
            int [] score5th = new int[201]; // 각 팀별 5번째 선수의 스코어
            int [] counts = new int[201]; // 각 팀별 점수 획득 횟수
            int[] teams = new int[N]; // 팀 정보 배열

            st = new StringTokenizer(br.readLine());
            int M = 0;
            for (int i = 0; i < N; i++) {
                int team = Integer.parseInt(st.nextToken());
                teams[i] = team;
                counts[team] += 1;
                M = Math.max(M, team);
            }

            for (int i = 0; i < 201; i++) { // 각 팀별 5번째 점수를 MAX로 초기화
                score5th[i] = MAX;
            }

            int s = 1;
            int[] counts2 = new int[201];
            for (int i = 0; i < N; i++) {
                int team = teams[i];
                counts2[team] += 1;
                if (counts2[team] <= 4) {
                    scores[team] += s;
                } else if (counts2[team] == 5) score5th[team] = s;
                if (counts[team] < 6) continue;
                s += 1;
            }

            int w = 0;
            int minScore = MAX;
            for (int i = 1; i < M + 1; i++) {
                if (counts[i] < 6) continue; // 팀의 참가 횟수가 6 이하면 참가 X
                if (scores[i] < minScore) { // 총점이 낮으면 최소 점수와 승리팀을 갱신
                    minScore = scores[i];
                    w = i;
                } else if (scores[i] == minScore) { // 총점이 같을 경우 5번째 팀원의 점수 비교
                    if (score5th[i] < score5th[w]) {
                        w = i;
                    }
                }
            }
            bw.write(w + "\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}