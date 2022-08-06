# 문자열 비교하기(17180번)
###########################################################################
    # 문제: https://www.acmicpc.net/problem/17180
    # 다이나믹 프로그래밍
    # 로직을 잘못짰는데, 어디서 잘못짰는지 몰라서 거의 한 40분은 헤맸던 것 같다.
    # 처음에는 2중 for구문 안에 있는 if/elif 구문 없이 else구문과 바로 그 아래 있는 내용으로만 dp를 구성했는데
    # 자꾸 틀렸습니다를 받아서 반레를 찾아보니 로직이 어디가 잘못되었는지 찾아낼 수 있었다.
    # 반례 3 2 aee ea일 때, dp 테이블을 잘못구성함을 알 수 있었다.
    # 즉, (1행, 1열) 칸을 제외한 1행 라인과 1열 라인은 직전 칸의 값을 받아와서 누적해야 올바른 dp테이블이다.
###########################################################################
import sys
input = sys.stdin.readline

N, M = map(int, input().split())
S1 = input().rstrip()
S2 = input().rstrip()

dp = [[0] * (N + 1) for _ in range(M + 1)]

for j in range(1, N + 1):
    dp[0][j] = ord(S1[j-1]) - 96 + dp[0][j-1]
for i in range(1, M + 1):
    dp[i][0] = ord(S2[i-1]) - 96 + dp[i-1][0]

for i in range(1, M + 1):
    for j in range(1, N + 1):
        if i == 1 and j > 1:
            dp[i][j] = dp[i][j-1]
        elif j == 1 and i > 1:
            dp[i][j] = dp[i-1][j]
        else:
            dp[i][j] = min(dp[i-1][j-1], dp[i-1][j], dp[i][j-1])
        dp[i][j] += abs(ord(S1[j-1]) - ord(S2[i-1]))

print(dp[M][N])
