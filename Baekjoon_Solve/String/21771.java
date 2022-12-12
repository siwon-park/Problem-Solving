// 가희야 거기서 자는 거 아니야 (21771번)
///////////////////////////////////////////////////////////////////////////////////////////
  // 문제: https://www.acmicpc.net/problem/21771
  // 문자열
  // 매우 간단한 문제였는데, 어렵게 생각해서 구현하는 바람에 많은 시간을 소비했고, 비효율적인 코드를 짜버렸다.
  // 내가 푼 풀이는 베개의 크기만큼 탐색해서 "."이 하나도 없고 G가 1 이상이고, P의 개수가 1 이상이면서 P의 개수와 원본 배열의 P가 같으면 1을 return하게 하였다.
  // 근데 생각해보면 엄청 간단한 문제인 것이
  // P의 개수를 전부 센 다음에 P의 개수가 베개의 크기와 같다면 P가 G에 의해 가려진 부분이 없으므로 0이고, P의 개수가 베개 크기와 다르다면 1이다.
  // 왜 이렇게 어렵게 생각했는지 모르겠다...
///////////////////////////////////////////////////////////////////////////////////////////
import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        graph = new String[R][C];

        StringTokenizer st2 = new StringTokenizer(br.readLine());
        Rg = Integer.parseInt(st2.nextToken());
        Cg = Integer.parseInt(st2.nextToken());
        Rp = Integer.parseInt(st2.nextToken());
        Cp = Integer.parseInt(st2.nextToken());
        /*
            // 보다 효율적인 풀이
        		int pillow = Rp * Cp;
		        int cntP = 0;
		        while(R-- > 0) {
			        for(char c : br.readLine().toCharArray()) {
				        if(c == 'P') cntP++;
			        }
		        }              
		        System.out.print(cntP == pillow ? 0 : 1); // 베개크기가 P개수랑 같으면 가희가 위에 있지않음 
        */
        int P = 0;
        for (int i=0; i<R; i++) {
            String[] tmp = br.readLine().split("");
            graph[i] = tmp;
            for (int j=0; j<C; j++) {
                if (tmp[j].equals("P")) {
                    P += 1;
                }
            }
        }

        int ret = check(P);
        System.out.println(ret);

    }
    static int R, C, Rg, Cg, Rp, Cp;;
    static String[][] graph;

    static int check(int P) {
        for (int i=0; i<R; i++) {
            for (int j=0; j<C; j++) {
                if (!graph[i][j].equals(".") && i + Rp <= R && j + Cp <= C) {
                    int empty = 0;
                    int GCnt = 0;
                    int PCnt = 0;
                    for (int r=i; r<i+Rp; r++) {
                        for (int c=j; c<j+Cp; c++) {
                            if (graph[r][c].equals(".")) {
                                empty += 1;
                            } else if (graph[r][c].equals("G")) {
                                GCnt += 1;
                            } else {
                                PCnt += 1;
                            }
                        }
                    }

                    if (empty == 0 && PCnt >= 1 && GCnt >= 1 && P == PCnt) {
                        return 1;
                    }

                }
            }
        }
        return 0;
    }
}
