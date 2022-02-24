// 종이자르기(2628번)
///////////////////////////////////////////////////////////////
  // 문제: https://www.acmicpc.net/problem/2628
  // 정렬
  // 신기하게도 자바 정렬하는 방법에 대해 익혀놔야겠다고 생각한 상태였는데, 마침 정렬 문제를 풀게 되었다.
  // 정렬 문제인지 처음부터 알았던 것은 아니고 그림을 그리다보니 정렬을 해야 쉽게 풀 수 있을 것 같다는 생각이 들어서 정렬하는 방법을 찾은 다음 풀었다.
  // 처음으로 ArrayList를 활용해서 푼 문제이다.(편의상 리스트로 설명)
///////////////////////////////////////////////////////////////
import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(br.readLine());
        ArrayList<Integer> arr1 = new ArrayList<>(); // 가로 절단좌표(x좌표)를 받을 arrayList
        ArrayList<Integer> arr2 = new ArrayList<>(); // 세로 절단좌표(y좌표)를 받을 arrayList
        for (int i=0; i<K; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int way = Integer.parseInt(st2.nextToken());
            int cut_point = Integer.parseInt(st2.nextToken());
            if (way == 1) {
                arr1.add(cut_point);
            } else {
                arr2.add(cut_point);
            }
        }
        arr1.add(w); // arr1 마지막에 w값(가로의 최댓값)을 삽입
        arr2.add(h); // arr2 마지막에 h값(세로의 최댓값)을 삽입
        // 두 리스트를 오름차순 정렬함
        arr1.sort(Comparator.naturalOrder());
        arr2.sort(Comparator.naturalOrder());
        int last_w = 0; // 가로의 마지막 값(초기값은 0)
        int last_h = 0; // 세로의 마지막 값(초기값은 0)
        int max_w = 0;
        int max_h = 0;
        for (Integer nums: arr1) {
            // 리스트의 현재 값에서 마지막 값(방금 전 값)을 뺀 값이 너비 최댓값보다 크면 갱신함 
            if (nums - last_w > max_w) {
                max_w = nums - last_w;
            }
            last_w = nums; // 마지막 값은 매번 갱신
        }
        for (Integer nums: arr2) {
            // 리스트의 현재 값에서 마지막 값(방금 전 값)을 뺀 값이 높이 최댓값보다 크면 갱신함 
            if (nums - last_h > max_h) {
                max_h = nums - last_h;
            }
            last_h = nums; // 마지막 값은 매번 갱신
        }
        System.out.println(max_h*max_w);
    }
}
