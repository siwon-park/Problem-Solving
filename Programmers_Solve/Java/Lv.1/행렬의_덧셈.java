// 행렬의 덧셈(연습문제)
class Solution {
  public int[][] solution(int[][] arr1, int[][] arr2) {
    int N = arr1.length;
    int M = arr1[0].length;
    for(int i=0; i<N; i++) {
      for(int j=0; j<M; j++) {
        arr1[i][j] += arr2[i][j];
      }
    }
    return arr1;
  }
}
