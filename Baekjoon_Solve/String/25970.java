// 현대 모비스 에어 서스펜션 (25970번)
//////////////////////////////////////////////////////////////////////////////////////////////
  // 문제: https://www.acmicpc.net/problem/25970
  // 자료구조, 비트마스킹, KMP
  // 주어진 N개의 데이터에 대하여 각각 B개의 '차고의 낮음'을 판단하는 판단 데이터, '차고의 높음'을 판단하는 판단 데이터가
  // 부분 문자열로서 몇 번씩 등장하는지 체크하여 C를 구한 다음에, C의 값에 따라 문제에서 주어진 대로 출력하면 되는 문제
  // startswith로 분석해야할 데이터가 판단 데이터로 시작하는지 판별하여 C 값을 구하였다.
  // 문제를 다 풀고나서 더 빠른 풀이법을 보니까, KMP로도 풀 수 있었다. (왜 생각을 못했지...?)
//////////////////////////////////////////////////////////////////////////////////////////////
import java.io.*;

public class Main {

    static int B;
    static int N;
    static String[] judgeLow;
    static String[] judgeHigh;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        B = Integer.parseInt(br.readLine());
        judgeLow = new String[B];
        judgeHigh = new String[B];

        for (int i=0; i<B; i++) {
            judgeLow[i] = br.readLine();
        }

        for (int i=0; i<B; i++) {
            judgeHigh[i] = br.readLine();
        }

        N = Integer.parseInt(br.readLine());

        for (int i=0; i<N; i++) {
            String data = br.readLine();
            int high = 0;
            int low = 0;
            int M = data.length();

            for (int j=0; j<M; j++) {
                String parseData = data.substring(j, M);

                for (int k=0; k<B; k++) {
                    if (parseData.startsWith(judgeLow[k])) {
                        low ++;
                    }
                    if (parseData.startsWith(judgeHigh[k])) {
                        high ++;
                    }
                }
            }

            int C = high - low;
            if (C > 0) {
                bw.write("LOW " + C + "\n");
            } else if (C < 0) {
                bw.write("HIGH " + -C + "\n");
            } else {
                bw.write("GOOD\n");
            }
        }

        bw.flush();
        br.close();
        bw.close();
    }
}
