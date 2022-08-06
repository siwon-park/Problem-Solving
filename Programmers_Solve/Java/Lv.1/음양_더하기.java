// level 1 음양 더하기(월코챌2)
class Solution {
    public int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;
        int N = absolutes.length;
        for (int i=0; i<N; i++) {
            if (signs[i]) {
                answer += absolutes[i];
            } else {
                answer -= absolutes[i];
            }
        }
        return answer;
    }
}
