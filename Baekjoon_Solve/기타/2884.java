//알람 시계(2884번)
////////////////////////////////////////////////////
    // 문제: https://www.acmicpc.net/problem/2884
    // java에서는 Python의 print(H,M)과 같이 여러 요소를 한번에 출력하는 것이 불가능함
    // H와 M을 한줄에 출력하기 위해 H + " "(공백) + M를 사용하거나, printf를 써서 포멧팅해주는 방법이 있음
    // H와 M이 정수라도 도중에 문자열 데이터가 들어가면 (예) H+" "+M)전체를 문자열로 인식하게 되어 그 다음 - 연산은 불가능한듯
////////////////////////////////////////////////////
import java.util.*;
public class Solution{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int H, M;
        H=sc.nextInt();
        M=sc.nextInt();
        if (M>=45){
            M=M-45;
            System.out.println(H + " " + M);
        }else if (M<45){
            H--;
            M=60+M-45;
            if (H<0){
                H=23;
            }
            System.out.println(H + " " + M);
        }
    }
}
