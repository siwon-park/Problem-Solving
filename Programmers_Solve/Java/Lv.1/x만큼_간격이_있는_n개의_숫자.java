// x만큼 간격이 있는 n개의 숫자(연습문제)
class Solution {
  public long[] solution(int x, int n) {
    long[] answer = new long[n];
    long num = x;
    for (int i=0; i<n; i++) {
      answer[i] = num;
      // answer[i] = x*(i+1); 이 틀린 이유? => 자문자답: x의 범위가 -1천만 ~ 1천만이고, n의 범위가 1000만까지이므로 최대로하면 -100억 ~ 100억이므로 int의 범위를 벗어나기 때문
      num += x;
    }
    return answer;
  }
}
