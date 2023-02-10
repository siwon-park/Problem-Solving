import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int check(String str) { // 내용을 입력할 수 있는지 확인하는 함수
        int M = str.length();
        String last = "-1";
        for (int i=0; i<M; i++) {
            String s = str.charAt(i) + "";
            if (s.equals(" ")) { // 빈칸일 경우
                if (!last.equals(s)) { // 마지막 입력이 빈칸이 아니면
                    N -= 1; // 스페이스를 입력할 수 있는 횟수 차감
                    if (N < 0) { // 스페이스 입력 횟수를 초과했으면 불가능
                        return -1;
                    }
                }
                last = s;
            } else { // 빈칸이 아닐 경우
                String largeS = s.toUpperCase(); // s를 대문자로 바꿈
                if (!last.equals(s)) { // 연속된 입력이 아닐 경우
                    int n = largeS.charAt(0) - 65;
                    arr[n] -= 1;
                    if (arr[n] < 0) {
                        return -1;
                    }
                }
                last = s;
            }
        }
        return 1;
    }

    static int N; // 스페이스 바 입력 한계 횟수
    static int[] arr = new int[26]; // 영어 자판 입력 한계 횟수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String contents = br.readLine();
        N = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<26; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int ret = check(contents);
        if (ret == 1) { // 내용을 입력할 수 있으면 제목까지도 입력 가능한지 확인
            String[] tmp = contents.split(" ");
            String ans = "";
            boolean flag = true;
            for (int i=0; i<tmp.length; i++) {
                if (tmp[i].equals("")) { // StringIndexOutOfBound 예외 처리
                    continue;
                }
                int n = (tmp[i].charAt(0) - 97 >= 0) ? tmp[i].charAt(0) - 97 : tmp[i].charAt(0) - 65;
                if (arr[n] == 0) { // arr[n] == 0이면 더 이상 입력이 불가능하므로 제목 입력 불가
                    flag = false;
                }
                ans += (tmp[i].charAt(0) + "").toUpperCase();
            }
            if (flag) {
                System.out.println(ans);
            } else {
                System.out.println(-1);
            }
        } else {
            System.out.println(-1);
        }

    }
}
