// 스위치 켜고 끄기(1244번)
/////////////////////////////////////////////////////////////
  // 문제: https://www.acmicpc.net/problem/1244
  // 구현
  // 문제의 논리를 잘 적어서 구현하면 되는 문제
  // 출력 때문에 정답률이 낮은 듯하다 -> 1줄에(1행 20열까지)을 출력하고 줄마다 개행을 해야함
/////////////////////////////////////////////////////////////
import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        String[] arr = br.readLine().split(" ");
        int k = Integer.parseInt(br.readLine());
        for (int i=0; i<k; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int g = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            // 남자일 경우 (뽑은 스위치 번호의 배수에 대해서만 처리)
            if (g == 1) {
                for (int j=s-1; j<N; j+=s){
                    if (arr[j].equals("0")) {
                        arr[j] = "1";
                    } else {
                        arr[j] = "0";
                    }
                }    
            }
            // 여자일 경우 (뽑은 스위치 번호에 해당하는 상태를 바꾸고, 양쪽으로 대칭인지 확인하면서 대칭이면 상태를 바꿔 나간다)
            else {
                // 일단 현재 스위치 번호의 상태를 바꿈
                int j = s-1;
                if (arr[j].equals("0")) {
                    arr[j] = "1";
                } else {
                    arr[j] = "0";
                }
                int l = j-1;
                int r = j+1;
                // 좌우 대칭일 경우 바꿈
                while (0 <= l && r < N) {
                    if (arr[l].equals(arr[r])) {
                        if (arr[l].equals("0")) {
                            arr[l] = "1";
                            arr[r] = "1";
                        } else {
                            arr[l] = "0";
                            arr[r] = "0";
                        }
                        l -= 1;
                        r += 1;
                    } else {
                        break;
                    }
                }
            }
        }
        // 1행 20열을 1줄씩 
        for (int i=0; i<N; i++) {
            if (i!=0 && i%20 == 19) {
                bw.write(arr[i]);
                bw.newLine();
            } else {
                bw.write(arr[i]+" ");
            }
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
