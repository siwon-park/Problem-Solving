// 소수 만들기(Summer/Winter Coding(~2018))
///////////////////////////////////////////////////////////
  // 에라토스테네스의 체 활용
  // nums배열의 원소의 최댓값은 1000이므로 최대 3000까지 소수를 미리 계산해두고, nums를 3중 for구문을 돌려서 서로 다른 인덱스에 위치하는 숫자를 더해서
  // 해당 결과가 false이면 소수이므로 answer += 1;을 하였음
///////////////////////////////////////////////////////////
class Solution {
  public int solution(int[] nums) {
    int answer = 0;
    boolean[] prime = new boolean[3001];
    prime[0] = true;
    prime[0] = true;
    for (int i=2; i<3000; i++) {
      if (!prime[i]) {
        int j = 2;
        while (i*j < 3000) {
          prime[i*j] = true;
          j += 1;
        }
      }
    }
    int N = nums.length;
    for (int i=0; i<N; i++) {
      for (int j=i+1; j<N; j++) {
        for (int k=j+1; k<N; k++) {
          int num = nums[i] + nums[j] + nums[k];
          if (!prime[num]) {
            answer += 1;
          }
        }
      }
    }
    return answer;
  }
}
