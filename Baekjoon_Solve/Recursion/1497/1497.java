import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;


public class Main {

    static class Bit {
        String bit;
        int cnt;
        Bit(String bit, int cnt) {
            this.bit = bit;
            this.cnt = cnt;
        }
    }

    // 두 문자열을 받아서 비트 변환 결과와 일치 개수를 반환
    static Bit bitCount(String s1, String s2) {
        String bit = "";
        int cnt = 0;
        for (int i = 0; i < M; i++) {
            if (s1.charAt(i) == 'Y' || s2.charAt(i) == 'Y') {
                bit += "Y";
                cnt += 1;
            } else bit += "N";
        }
        return new Bit(bit, cnt);
    }


    static void backtrack(int k, int s, String curBit, int curCnt) {
        if (curCnt > MAX) {
            MAX = curCnt;
            ans = k;
        } else if (curCnt == MAX) {
            ans = Math.min(ans, k);
        }
        if (k == N) return;
        for (int i = s; i < N; i++) {
            Bit bit = bitCount(curBit, hashMap.get(arr[i]));
            backtrack(k + 1, i + 1, bit.bit, bit.cnt);
        }
    }


    static int N, M; // 기타의 개수, 곡의 개수
    static int ans = -1;
    static int MAX = 0; // 현재 연주할 수 있는 곡
    static String[] arr;
    static HashMap<String, String> hashMap;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new String[N];
        hashMap = new HashMap<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = st.nextToken();
            hashMap.put(arr[i], st.nextToken());
        }

        String curBit = "";
        for (int i = 0; i < M; i++) curBit += "N";

        backtrack(0, 0, curBit, 0);
        System.out.println(ans);
    }
}