import java.io.*;


public class Main {

    /*
    * 현재 구간에서 제일 작은 문자열을 찾아서 분할 정복 반복
    * */
    static void recur(String s, int l, int r) {
        int idx = 0;
        int max = MAX;
        for (int i=l; i<r; i++) {
            // 아직 방문하지 않은 문자 중 가장 작은 문자를 찾음
            if (s.charAt(i) < max && !visited[i]) {
                idx = i;
                max = s.charAt(i);
            }
        }
        if (max == MAX) {
            return;
        }
        visited[idx] = true; // 방문 체크
        for (int i=0; i<N; i++) { // 방문한 문자만 버퍼에 담음
            if (visited[i]) {
                sb.append(s.charAt(i));
            }
        }
        sb.append("\n");
        recur(s, idx + 1, r); // 오른쪽 구간 탐색
        recur(s, l, idx); // 왼쪽 구간 탐색
    }

    static StringBuilder sb;
    static boolean[] visited;
    static int MAX = Integer.MAX_VALUE;
    static int N; // 문자열의 길이

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        String S = br.readLine();
        N = S.length();
        visited = new boolean[N];
        recur(S, 0, N);
        System.out.println(sb);
    }
}