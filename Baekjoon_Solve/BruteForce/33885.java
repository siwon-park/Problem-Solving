import java.io.*;
import java.util.*;

// 마지막 수강신청 (33885번)
public class Main {

    static int N, M;
    static boolean[][] schedule;
    static boolean flag;
    static ArrayList<int[]>[] lectures;
    static boolean[] visited;
    static int[] points;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        schedule = new boolean[5][24];
        lectures = new ArrayList[N];
        visited = new boolean[N];
        points = new int[N];
        for (int i = 0; i < N; i++) {
            lectures[i] = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            int c = Integer.parseInt(st.nextToken()); // 학점
            int s = Integer.parseInt(st.nextToken()); // 과목 수
            for (int j = 0; j < s; j++) {
                String day = st.nextToken(); // 요일
                int h = Integer.parseInt(st.nextToken()); // 시간
                int d = 0;
                if (day.equals("MON")) d = 0;
                else if (day.equals("TUE")) d = 1;
                else if (day.equals("WED")) d = 2;
                else if (day.equals("THU")) d = 3;
                else if (day.equals("FRI")) d = 4;
                lectures[i].add(new int[] { d, h });
                points[i] = c;
            }
        }

        backtrack(0, 0);
        System.out.println(flag ? "YES" : "NO");
    }

    private static void backtrack(int idx, int total) {
        if (flag) return;
        if (total >= M) {
            flag = true;
            return;
        }
        if (idx == N) return;
        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                // 강의를 들을 수 있는지 체크하여 시간표에 반영
                boolean isPossible = check(i);
                int tmp = 0;
                if (isPossible) {
                    tmp = points[i];
                    for (int[] lec : lectures[i]) schedule[lec[0]][lec[1]] = true;
                }
                backtrack(idx + 1, total + tmp);
                if (isPossible) for (int[] lec : lectures[i]) schedule[lec[0]][lec[1]] = false;
                visited[i] = false;
            }
        }
    }

    private static boolean check(int i) {
        for (int[] lec : lectures[i]) {
            if (schedule[lec[0]][lec[1]]) return false;
        }
        return true;
    }

}

