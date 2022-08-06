// 두 개 뽑아서 더하기(월코챌1)
/////////////////////////////////////////////////////////
  // 더한 결과를 중복없이 담아야 한다는 것은 알았는데,
  // 파이썬처럼 자료 구조의 형변환이 쉽지 않을 것 같아서 고민했는데, 찾아보니까
  // 집합 자료형인데 오름차순으로 자료를 저장하는 TreeSet이 있었다. 
  // 해당 자료형을 사용하니 쉽게 해결할 수 있었다.
/////////////////////////////////////////////////////////
import java.util.*;

class Solution {
  public TreeSet<Integer> solution(int[] numbers) {
    TreeSet<Integer> answer = new TreeSet<Integer>();
    int N = numbers.length;
    for (int i=0; i<N; i++) {
      for (int j=i+1; j<N; j++) {
        int num = numbers[i]+numbers[j];
        answer.add(num);
      }
    }
    return answer;
  }
}
