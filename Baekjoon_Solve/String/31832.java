import java.io.*;
import java.util.*;

// 팀명 정하기 2 (31832번)
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        String ans = "";
        for (int i = 0; i < N; i++) {
            String S = br.readLine();
            int cnt1 = 0; // 대문자
            int cnt2 = 0; // 소문자
            int cnt3 = 0; // 숫자
            boolean flag = true;
            int M = S.length();
            if (M > 10) flag = false;
            for (int j = 0; j < M; j++) {
                char c = S.charAt(j);
                if ('0' <= c && c <= '9') {
                    cnt3 += 1;
                } else if ('A' <= c && c <= 'Z') {
                    cnt1 += 1;
                } else if ('a' <= c && c <= 'z') {
                    cnt2 += 1;
                }
            }
            if (cnt1 > cnt2) flag = false;
            if (M == cnt3) flag = false;
            if (flag) {
                ans = S;
            }
        }

        System.out.println(ans);
    }
}

