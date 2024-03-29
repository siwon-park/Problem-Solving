# 새끼치기(17291번)
###################################################################################
    # 문제: https://www.acmicpc.net/problem/17291
    # DP
    # 이번년도에 새롭게 탄생하는 벌레는 이전에 남은 벌레이고 dp[i][0] = dp[i - 1][5]
    # 이번 년도에 j번 분열한 벌레는 각각 dp[i][j] = dp[i - 1][j - 1]이다(단, 1 <= j <= 4)
    # 그리고 이번 년도 - 3년이 홀수년도이면 홀수년도에 태어난 벌레는 3회 분열 이후 사망하므로 차감해주고
    # 이번 년도 - 4년이 짝수년도이면, 짝수년도에 태어난 벌레는 4회 분열 이후 사망하므로 차감해준다
###################################################################################
import sys
input = sys.stdin.readline

N = int(input())
dp = [[0] * 6 for _ in range(N + 1)]
dp[1] = [1, 0, 0, 0, 0, 1] # 탄생, 1회, 2회, 3회, 4회 분열, 남은 벌레
for i in range(2, N + 1):
    dp[i][0] = dp[i - 1][5]
    for j in range(1, 5):
        dp[i][j] = dp[i - 1][j - 1]
    if i >= 4 and (i - 3) % 2 == 1:
        dp[i][3] -= dp[i - 3][0]
    if i >= 5 and (i - 4) % 2 == 0:
        dp[i][4] -= dp[i - 4][0]
    dp[i][5] = sum(dp[i][:5])

print(dp[N][5])
