import java.io.*;
import java.util.*;


public class Main {

    static int binarySearch() {
        int count = 0;
        int s = 1;
        int e = R - 1;
        while (s <= e) {
            int mid = (s + e) / 2;
            boolean flag = true; // mid 크기로 문자열을 중복 없이 자를 수 있음
            HashSet<String> hashSet = new HashSet<>();
            for (int i = 0; i < C; i++) {
                String subS = vertical[i].substring(R - 1 - mid); // 시작 인덱스는 R - 1 - 크기
                if (hashSet.contains(subS)) {
                    flag = false;
                    break;
                }
                hashSet.add(subS);
            }
            if (flag) { // mid 크기로 문자열을 자를 수 있으면 탐색 범위를 줄임
                e = mid - 1;
                count = R - mid;
            } else {
                s = mid + 1;
            }
        }
        return count;
    }

    static int R, C; // 행의 개수, 열의 개수
    static String[] table, vertical;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        table = new String[R];
        for (int i = 0; i < R; i++) table[i] = br.readLine();

        vertical = new String[C]; // 세로 문자열을 모음
        for (int i = 0; i < C; i++) {
            String vs = "";
            for (int j = 1; j < R; j++) {
                vs += table[j].charAt(i) + "";
            }
            vertical[i] = vs;
        }

        int ret = binarySearch();
        System.out.println(ret);

    }
}