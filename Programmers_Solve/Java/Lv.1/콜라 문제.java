// 재귀
// 재귀적 호출을 통해 현재 콜라병의 개수가 바꿀 수 있는 빈 병의 개수보다 작으면 결과값을 return한다.

class Solution {
    static int recur(int cur, int empty, int bonus, int ret) {
        if (cur < empty) {
            return ret;
        }
        int possible = cur / empty;
        int remainder = cur % empty;
        return recur(remainder + bonus * possible, empty, bonus, ret + possible * bonus);
    }
    
    public int solution(int a, int b, int n) {
        return recur(n, a, b, 0);
    }
}
