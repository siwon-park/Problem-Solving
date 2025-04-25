import java.io.*;
import java.util.*;

// 그런 사람은 없었습니다 (32859번)
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(br.readLine());
        int[][] arr = new int[N + 1][2];
//        Arrays.fill(arr, 0);
        int acc = 0;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken()); // 0: 폼 제출, 1: 입금
            if (t == 1) {
                arr[k][0] = acc;
                if (arr[k][1] == 0) {
                    arr[k][1] = 1; // 입금을 먼저 함
                }
            } else { // 폼 제출
                acc += 1; // 품 제출자 증가
                if (arr[k][1] == 0) { // 입금보다 먼저 폼을 제출하는 경우
                    arr[k][1] = 2;
                }
                // 입금을 먼저 했는데, S명 지난 다음에 폼을 제출함
                else if (arr[k][1] == 1 && acc - arr[k][0] > S) {
                    arr[k][0] = acc - arr[k][0];
                    arr[k][1] = -1;
                } else if (arr[k][1] == 1 && acc - arr[k][0] <= S) {
                    arr[k][1] = 2;
                }
            }
        }

        acc += 1;
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            if (arr[i][1] == -1) arrayList.add(i);
            else if (arr[i][1] == 1 && acc - arr[i][0] > S) arrayList.add(i);
        }

        if (arrayList.size() == 0) {
            bw.write("-1\n");
        } else {
            for (int i : arrayList) bw.write(i + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}

