// 자릿수 더하기(연습문제)
// 파이썬으로는 문자열로 변환한다음 풀었는데, 사실 이 문제는 그런 방식으로 푸는 것이 아니다.
// n을 10으로 나눠가면서 나온 나머지가 바로 각 자리수이므로, 그 값을 n = 0이 될 때까지 더해준다.
public class Solution {
    public int solution(int n) {
        int answer = 0;
        while(n != 0) {
            answer += n%10;
            n /= 10;
        }
        return answer;
    }
}
