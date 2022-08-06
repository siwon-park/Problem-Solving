# 진우의 달 여행(small, large) (17484, 17485번)
#################################################################################################
    # 문제: https://www.acmicpc.net/problem/17484, https://www.acmicpc.net/problem/17485
    # 다이나믹 프로그래밍
    # small은 N과 M의 범위가 작아서 브루트포스로 풀 수 있지만, Large는 N, M이 최대 1000이기 때문에 DP로 풀어야한다.
    # 나는 small도 DP로 풀어서 small과 large와 답이 같다.
    # 핵심은 아래 주석에도 쓰여있지만, dp[r][c] = [이전에 왼쪽을 택함, 이전에 가운데를 택함, 이전에 오른쪽을 택함]이다.
    # 현재 선택하려는 요소의 위치에 따라 이전에 선택한 것이 무엇인지 고려하여 최솟값을 선택하면 된다.
    # 예를 들어, dp[r][0][1]은 현재가 가운데 요소[1]이기 때문에 이전에(dp[r-1][0] 중) 가운데를 선택한 위치에서 올 수 없다.
    # 따라서 dp[r][0][1] = min(dp[r-1][0][0], dp[r-1][0][2]) + board[r][0]이다.
    # dp[r][0][2]는 오른쪽에서 온 요소를 더해야하는데, 전전 위치에서 오른쪽에서 왔다면 그것은 선택할 수 없다.
    # 따라서 dp[r][0][2] = min(dp[r-1][1][0], dp[r-1][1][1]) + board[r][0]이다.
#################################################################################################
import sys
sys.setrecursionlimit(int(1e5))
input = sys.stdin.readline

N, M = map(int, input().split())
board = [list(map(int, input().split())) for _ in range(N)]

INF = sys.maxsize
dp = [[[INF, INF, INF] for _ in range(M)] for _ in range(N)]

for c in range(M):
    dp[0][c] = [board[0][c], board[0][c], board[0][c]]

# [이전에 왼쪽을 택함, 이전에 가운데를 택함, 이전에 오른쪽을 택함]
for r in range(1, N):
    for c in range(M):
        if c == 0:
            dp[r][c][1] = min(dp[r-1][c][0], dp[r-1][c][2]) + board[r][c]
            dp[r][c][2] = min(dp[r-1][c+1][0], dp[r-1][c+1][1]) + board[r][c]
        elif c == M - 1:
            dp[r][c][0] = min(dp[r-1][c-1][1], dp[r-1][c-1][2]) + board[r][c]
            dp[r][c][1] = min(dp[r-1][c][0], dp[r-1][c][2]) + board[r][c]
        else:
            dp[r][c][0] = min(dp[r-1][c-1][1], dp[r-1][c-1][2]) + board[r][c]
            dp[r][c][1] = min(dp[r-1][c][0], dp[r-1][c][2]) + board[r][c]
            dp[r][c][2] = min(dp[r-1][c+1][0], dp[r-1][c+1][1]) + board[r][c]

min_value = INF
for c in range(M):
    min_value = min(min_value, min(dp[N-1][c]))
print(min_value)

# for lst in dp:
#     print(lst)
