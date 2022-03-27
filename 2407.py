# 조합(2407번)
##################################################################
    # 문제: https://www.acmicpc.net/problem/2407
    # 수학, 다이나믹 프로그래밍
    # 조합의 재귀적 성질을 이용해 푸는 문제
    # nCk = n-1Ck + n-1Ck-1이므로 이를 이용해서 DP테이블을 구성하면 된다.
    # n == k 일 때는 1이고, k == 1일땐 n임만 체크해주면 쉽게 풀 수 있다.
##################################################################
import sys
input = sys.stdin.readline

n, m = map(int, input().split())
dp = [[0]*(m+1) for _ in range(n+1)] # dp[n][m] = dp[n-1][m] + dp[n-1][m-1]
for i in range(1, n+1):
    for j in range(1, m+1):
        if i < j:
            continue
        if i == j:
            dp[i][j] = 1
        elif j == 1:
            dp[i][j] = i
        else:
            dp[i][j] = dp[i-1][j] + dp[i-1][j-1]
print(dp[n][m])
