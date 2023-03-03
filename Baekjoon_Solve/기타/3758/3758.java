import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static class Pair implements Comparable<Pair> {
        int team;
        int score;
        int cnt;
        int last;
        Pair(int team, int score, int cnt, int last) {
            this.team = team;
            this.score = score;
            this.cnt = cnt;
            this.last = last;
        }

        @Override
        public int compareTo(Pair o) {
            if (this.score < o.score) {
                return 1;
            } else if (this.score > o.score) {
                return -1;
            } else {
                if (this.cnt > o.cnt) {
                    return 1;
                } else if (this.cnt < o.cnt) {
                    return -1;
                } else {
                    return Integer.compare(this.last, o.last);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine()); // 테스트 케이스
        for (int tc = 0; tc < T; tc++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()); // 전체 팀의 수
            int k = Integer.parseInt(st.nextToken()); // 문제의 수
            int t = Integer.parseInt(st.nextToken()); // 우리 팀 번호
            int m = Integer.parseInt(st.nextToken()); // 로그의 개수

            int[][] teamScore = new int[n + 1][k + 1]; // 팀별 문제 점수 배열
            int[] teamTotalScore = new int[n + 1]; // 팀의 총 점수
            int[] teamCount = new int[n + 1]; // 팀의 제출 횟수
            int[] submitTime = new int[n + 1]; // 팀의 마지막 제출 시간
            Pair[] pairs = new Pair[n + 1];
            pairs[0] = new Pair(0, -1, 10001, 10001);

            for (int l = 0; l < m; l++) {
                st = new StringTokenizer(br.readLine());
                int i = Integer.parseInt(st.nextToken()); // 팀 번호
                int j = Integer.parseInt(st.nextToken()); // 문제 번호
                int s = Integer.parseInt(st.nextToken()); // 획득 점수
                teamScore[i][j] = Math.max(teamScore[i][j], s);
                teamCount[i] += 1;
                submitTime[i] = l + 1;
            }

            // 팀의 최종 스코어 합산
            for (int i = 1; i < n + 1; i++) {
                for (int j = 1; j < k + 1; j++) {
                    teamTotalScore[i] += teamScore[i][j];
                }
            }

            for (int i = 1; i < n + 1; i++) {
                pairs[i] = new Pair(i, teamTotalScore[i], teamCount[i], submitTime[i]);
            }

            Arrays.sort(pairs, Pair::compareTo);
            int rank = 1;
            for (int i = 0; i < n; i++) {
                if (pairs[i].team == t) break;
                rank++;
            }

            bw.write(rank + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}