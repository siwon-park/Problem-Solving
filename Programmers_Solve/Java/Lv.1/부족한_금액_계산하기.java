// 부족한 금액 계산하기(위클리 챌린지)
class Solution {
  public long solution(int price, int money, int count) {
    long answer = 0;
    long total_price = 0;
    for (int i=1; i<count+1; i++) {
      total_price += price*i;
    }
    answer = total_price - money;
    if (answer < 0) {
      answer = 0;
    }
    return answer;
  }
}
