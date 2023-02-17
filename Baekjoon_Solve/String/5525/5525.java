import java.io.*;


public class Main {
    /*
    * Pn에는 Pn-1이 2개 들었고, Pn-2이 3개, ... P1은 n개 있음
    * */
    static int solve(String s, int n, int m) {
        int cnt = 0;
        int idx = 0;
        int P = 0;
        while (idx + 2 < m) {
            if (s.charAt(idx) == 'I' && s.charAt(idx + 1) == 'O' && s.charAt(idx + 2) == 'I') {
                P += 1;
                if (P == n) {
                    cnt += 1;
                    P -= 1;
                }
                idx += 1; // idx가 'I'이면 idx + 1은 'O'이므로, idx + 2를 해주기 위해 미리 idx + 1을 함
            } else {
                P = 0;
            }
            idx += 1;
        }
        return cnt;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        String S = br.readLine();
        System.out.println(solve(S, N, M));
    }
}