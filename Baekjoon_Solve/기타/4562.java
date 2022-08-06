// No Brainer(4562번)
//////////////////////////////////////////////////
    // 문제: https://www.acmicpc.net/problem/4562
    // java for 구문 
//////////////////////////////////////////////////
import java.util.*;
public class Solution{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i=0; i<n; i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            if (x>=y){
                System.out.println("MMM BRAINS");   
            } else {
                System.out.println("NO BRAINS");
            }
        }
    }
}
