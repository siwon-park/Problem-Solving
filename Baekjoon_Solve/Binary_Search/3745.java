// 오름세(3745번)
/*
  문제: https://www.acmicpc.net/problem/3745
  이분탐색, 가장 긴 증가하는 부분 수열
  주어진 케이스마다 가장 긴 증가하는 부분 수열의 길이를 출력하면 된다.
  NumberFormatException Error 처리 때문에 고생을 했다. 원인이 정확하게 뭔지 모르니 헤맸다.
  질문 게시판에서 .trim()을 썼는지 체크하길래 .trim()을 추가했더니 통과할 수 있었다.
  백준에서 문제 번호가 낮은 문제들을 파이썬으로 풀 때, 개행이나 공백때문에 rstrip()을 썼는데,
  java에서도 trim()으로 공백을 처리해줘야하는 것은 이번이 처음인 것 같다.
  맨 마지막 출력은 l + 1을 해줘야한다. l을 0부터 시작하는 배열의 인덱스로 사용했기 때문에 결국 LIS의 길이는 l + 1이 되기 때문이다.
*/
import java.io.*;
import java.util.*;

public class Main {

    static int lowerBound(int[] arr, int s, int e, int val) {
        int idx = 0;
        while (s <= e) {
            int mid = (s + e) / 2;
            if (val <= arr[mid]) {
                e = mid - 1;
                idx = mid;
            } else {
                s = mid + 1;
            }
        }
        return idx;
    }

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        String S = "";
        while ((S = br.readLine()) != null) {
            N = Integer.parseInt(S.trim()); // .trim()으로 공백 처리
            int[] lst = new int[N];
            st = new StringTokenizer(br.readLine().trim()); // .trim()으로 공백 처리
            for (int i=0; i<N; i++) {
                lst[i] = Integer.parseInt(st.nextToken());
            }

            int[] LIS = new int[N];
            int l = 0;
            LIS[l] = lst[0];
            for (int i=1; i<N; i++) {
                int val = lst[i];
                if (LIS[l] < val) { // 자바에서는 배열의 길이가 고정이므로 마지막 LIS의 길이보다 크면 배열에 넣고 길이를 증가시켜준다.
                    LIS[++l] = val;
                } else { // val 값이 더 크면 그냥 해당 위치에서 교체해주면 되므로 LIS의 길이는 변함없다.
                    int idx = lowerBound(LIS, 0, l, val);
                    LIS[idx] = val;
                }
            }
            bw.write((l + 1) + "\n");
        }

        br.close();
        bw.flush();
        bw.close();

    }
}
