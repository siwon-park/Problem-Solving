//곱셈(2588번)
///////////////////////////////////////////////////////////
    // 문제: https://www.acmicpc.net/problem/2588
    // 수학, 사칙연산
    // 숫자 한개만 어떻게 가져오나 고민했었음
    // 첫번째 시도는 strB.charAt(인덱스)를 했는데 이렇게 할 경우 해당 자료의 형태가 char이라 Integer.parseInt를 쓸 수 없음. String일 경우에만 사용가능하기 때문
    // 그래서 사용했던 방법은 substring메서드를 사용해서 여전히 String자료형으로 만든채 Integer.parseInt를 사용하였음.
    // 아래 유용한 방법 2개 일부 참고
///////////////////////////////////////////////////////////
import java.util.*;
public class Solution{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        String strB = String.valueOf(B);
        int num3 = Integer.parseInt(strB.substring(2,3));
        int num4 = Integer.parseInt(strB.substring(1,2));
        int num5 = Integer.parseInt(strB.substring(0,1));
        System.out.println(A*num3);
        System.out.println(A*num4);
        System.out.println(A*num5);
        System.out.println(A*B);
        
////////////////////////////////////////////////////////
        // firstNum은 정수형 자료
        // int c = firstNum * (b.charAt(2) - '0'); // 이렇게 하면 char 자료형이 정수형이 되는듯?
        // int d = firstNum * (b.charAt(1) - '0');
        // int e = firstNum * (b.charAt(0) - '0');
        
//////////////////////////////////////////////////////// 수학적으로 표현; 1의 자리, 10의 자리, 100의 자리 나누기
        // StringBuilder sb = new StringBuilder(); 
        // sb.append(A * (B % 10)).append("\n"); 
        // sb.append(A * (B / 10 % 10)).append("\n");
        // sb.append(A * (B / 100)).append("\n");
        // sb.append(A * B);    
        
    }
}
