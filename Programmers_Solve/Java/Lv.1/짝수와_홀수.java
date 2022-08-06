// 짝수와 홀수(연습 문제)
// 음수가 있기 때문에 짝수에 대해서 먼저 처리해주고 나니 통과할 수 있었다.(음수 케이스가 최소 2개 있었던 듯...)
class Solution {
    public String solution(int num) {
        String answer = "";
        if(num%2 == 0) { // 음수가 있을 수도 있어서 Even에 대해 먼저 처리하는게 나았음
            answer = "Even";
        } else {
            answer = "Odd";
        }
        return answer;
    }
}
