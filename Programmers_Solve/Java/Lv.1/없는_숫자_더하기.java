// level 1 없는 숫자 더하기(월코챌3)
class Solution {
  public int solution(int[] numbers) {
    int answer = 45;
    int N = numbers.length;
    for (int i=0; i<N; i++) {
      answer -= numbers[i];
    }
    return answer;
  }
}
