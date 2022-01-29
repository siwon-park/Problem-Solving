//쉽게 푸는 문제(1292번)
///////////////////////////////////////////////////////
    // 문제: https://www.acmicpc.net/problem/1292
    // 수학, 구현
    // for 구문으로 어떻게 배열을 구현해야하나 고민하다가 결국 while문으로 해결했던 문제
    // 이렇게 밖에 해결할 수 없나 아직도 고민이 들지만, 다른 사람의 풀이를 찾다가
    // for 구문을 저렇게 활용할 수 있다는 것을 깨달았다. java의 for 구문은 파이썬처럼 i하나만 인수로 고정된 것이 아니라
    // 조건을 더 넣을 수 있다는 것을 깨달았다.
///////////////////////////////////////////////////////
import java.util.*;
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[1001];
        int A = sc.nextInt();
        int B = sc.nextInt();
        int indx = 1;
        int n = 1;
        int i = 0;
        int total = 0;
        while (indx<1001) {
            while (indx<1001 && i<n) {
                arr[indx]=n;
                indx+=1;
                i+=1;
            }
            n+=1;
            i=0;
        } for (i=A; i<=B; i++) {
            total+=arr[i];
        }
        System.out.println(total);
    }
}

// for 구문 활용 예시
////////////////////////////////////////////////////
// for(int i = 0, num = 1;i<1000;i+=num,num++) {
//  for(int j = 0; j < num; j++) {
