//나는 요리사다(2953번)
//////////////////////////////////////////////////
    // 문제: https://www.acmicpc.net/problem/2953
    // 수학, 구현
    // 역시 알고리즘 문제 풀이는 파이썬이 훨씬 편한 것 같다.
    // max함수나 enumerate함수가 없으니까 직접 구현해야 했다.
    // 입력도 5개로 한정, 데이터 갯수도 각각 4개 한정이라 다행이지, 아니었으면 조금 더 고민했을 수도 있었다...
    // 5칸짜리 배열을 만들고, 해당 배열에 각 라인마다 입력으로 들어오는 숫자 누적값을 각 인덱스에 넣으면서, 최댓값과 인덱스를 갱신해나갔다.
//////////////////////////////////////////////////
import java.util.*;
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int [5];
        int maxValue = 0;
        int maxIndx = 0;
        for (int i=0; i<5; i++) {
            for (int j=0; j<4; j++) {
                int n = sc.nextInt();
                arr[i]+=n;
            } if (arr[i] > maxValue){
                maxValue = arr[i];
                maxIndx = i+1;
            }
        }
        System.out.println(maxIndx+" "+maxValue);
    }
}
