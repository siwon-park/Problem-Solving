// 하샤드 수(연습문제)
// 처음으로 클래스 내에 메서드를 선언해서 문제를 해결해 보았다.
// numPosSum이라는 정수 x를 입력받았을 때 해당 정수의 자릿수들의 합을 반환하는 메서드를 선언하였고,
// 해당 메서드로부터 반환받은 값을 다시 x와 나누어 떨어지는지 확인하였다.
class Solution {
    public int numPosSum(int x){
        int pos_sum = 0;
        while (x != 0) {
            pos_sum += x%10;
            x /= 10;
        }
        return pos_sum;
    }
    public boolean solution(int x) {
        boolean answer = true;
        int pos_sum = numPosSum(x);
        if (x % pos_sum != 0) {
            answer = false;
        }
        return answer;
    }
}
