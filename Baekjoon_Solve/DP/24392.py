# 영재의 징검다리(24392번)
#########################################################
    # 문제: https://www.acmicpc.net/problem/24392
    # DP(다이나믹 프로그래밍)
    # 간단한 다이나믹 프로그래밍 문제였다. 처음에 DP테이블의 N-1번째 인덱스를 전부 1로 초기화시켰다. 이는 1을 더하기 위함이다.
    # 그리고나서 N-2행부터 0행까지 0~M열까지 탐색을 하는데, board[i+1][j-1], board[i+1][j], board[i+1][j+1]이 1일 경우에만 dp 테이블에서 합을 계산한다.
    # 최종적으로 0행에서 board[i][j]가 1일 경우에만 해당 위치에 기록된 dp테이블에 있는 값을 ans에 누적한 다음, 1000000007로 나눠준다.
    # (좀 더 빠르게 해결해보기위해 2중 for문에서 board[i][j]==1일 경우를 if문 최상단에 뒀는데, 예상과는 달리 조금 더 느렸다. 
#########################################################
import sys
input = sys.stdin.readline

N, M = map(int, input().split())
board = [list(map(int, input().split())) for _ in range(N)]
dp = [[0]*M for _ in range(N)]
dp[N-1] = [1]*M
for i in range(N-2, -1, -1):
    for j in range(M):
        if j-1 >= 0 and board[i+1][j-1]:
            dp[i][j] += dp[i+1][j-1]
        if board[i+1][j]:
            dp[i][j] += dp[i+1][j]
        if j+1 < M and board[i+1][j+1]:
            dp[i][j] += dp[i+1][j+1]

ans = 0
for i in range(M):
    if board[0][i]:
        ans += dp[0][i]
ans %= 1000000007
print(ans)
