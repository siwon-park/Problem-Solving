// 평균 구하기(연습문제)
///////////////////////////////////////////////////////////
  // 자바에서 실수 기본형은 double이고, 평균을 계산할 때 int형으로 선언하고 나눗셈을 하면
  // 정수로 내림하므로, 반드시 double로 선언해야함을 잊지말자
  // 연습문제이지만 아주 기본 중에 기본을 상기시켜줄 수 있어서 좋았다.
///////////////////////////////////////////////////////////
class Solution {
    public double solution(int[] arr) {
        double answer = 0;
        for (int i=0; i<arr.length; i++) {
            answer += arr[i];
        }
        answer /= arr.length;
        return answer;
    }
}
