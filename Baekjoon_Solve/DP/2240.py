# 자두나무 (2240번)
"""
    문제: https://www.acmicpc.net/problem/2240
    DP
    3차원의 DP 테이블을 선언. dp[i][w][k] => i번째 선택에서, w만큼의 에너지를 사용했고, k번 나무의 자두를 선택함
    w가 0인 경우에 대해 처리
    현재 자두가 1일 경우에 dp[i][0][1] = dp[i - 1][0][1] + 1이다.
    또한 출발을 1번 나무 아래에서 하므로, 절대 dp[i][0][2]가 0보다 큰 경우는 없다. 따라서 dp[i][0][2] = dp[i - 1][0][2]이다.
    당연하게도 현재 자두가 2인 경우에는 dp[i][0][1] = dp[i - 1][0][1]이다.
    그리고, 현재 떨어지는 1번 자두를 선택하는 경우는 dp[i][w][1]이고,
    이는 i - 1번째 선택에서 w - 1번 이동하여 2번 자두를 고른 경우와 i - 1번째 선택에서 w번 이동하여 1번 자두를 고른 경우 중 큰 값 + 1이다.
    1번을 선택하지 않는 경우는 현재 2번을 고른다는 것이므로 dp[i][w][2]이고,
    이는 i - 1번째 선택에서 w번 이동하여 2번을 고른 값과 i - 1번째 선택에서 w - 1번 이동하여 1번을 선택한 값 중 큰 값이다.
    마찬가지로 현재 떨어지는 자두가 2번일 경우에도 1번과 유사한 로직으로 처리하면 된다.
"""
import sys
input = sys.stdin.readline

T, W = map(int, input().rstrip().split())
arr = [int(input().rstrip()) for _ in range(T)]
dp = [[[0, 0, 0] for _ in range(W + 1)] for _ in range(T + 1)]

for i in range(1, T + 1):
    if arr[i - 1] == 1:  # 현재 1번
        dp[i][0][1] = dp[i - 1][0][1] + 1
        dp[i][0][2] = dp[i - 1][0][2]
        for w in range(1, W + 1):
            dp[i][w][1] = max(dp[i - 1][w - 1][2], dp[i - 1][w][1]) + 1  # 1번을 선택하는 경우
            dp[i][w][2] = max(dp[i - 1][w][2], dp[i - 1][w - 1][1])  # 1번을 선택하지 않음
    else:  # 현재 2번
        dp[i][0][1] = dp[i - 1][0][1]
        for w in range(1, W + 1):
            dp[i][w][2] = max(dp[i - 1][w - 1][1], dp[i - 1][w][2]) + 1  # 2번을 선택하는 경우
            dp[i][w][1] = max(dp[i - 1][w][1], dp[i - 1][w - 1][2])  # 2번을 선택하지 않음

ans = 0
for w in range(W + 1):
    ans = max(dp[T][w][1], dp[T][w][2])

print(ans)
