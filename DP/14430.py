# 자원 캐기(14430번)
##########################################################################
    # 문제: https://www.acmicpc.net/problem/14430
    # 다이나믹 프로그래밍
    # 처음 풀이는 if 구문 3연속을 썼다. 시간은 248ms가 나왔고, 조금 느린게 아닌가 싶어서 다른 사람들 풀이 시간대를 봤더니 빠른 편은 아니었다.
    # if 구문 3개를 썼던 것을 if, else로 분기를 나누었더니 132ms로 시간을 대폭 줄일 수 있었다.
    # 현재 좌표에서 배열의 크기를 만족하는 범위 내에서 위쪽, 왼쪽에 있는 dp 테이블의 값 중 큰 값 + 현재 자원의 값을 계속 더해 나가면 된다.
    # 그 외에는 0행이나 0열일 경우에 대해서만 예외 처리를 하면 된다.
##########################################################################
import sys
input = sys.stdin.readline

N, M = map(int, input().split())
board = [list(map(int, input().split())) for _ in range(N)]

dp = [[0]*M for _ in range(N)]
dp[0][0] = board[0][0]
for i in range(N):
    for j in range(M):
        if i-1 >= 0 and j-1 >= 0:
            dp[i][j] = max(dp[i-1][j], dp[i][j-1]) + board[i][j]
        else:
            if j-1 >= 0:
                dp[i][j] = max(dp[i][j-1]+board[i][j], dp[i][j])
            if i-1 >= 0:
                dp[i][j] = max(dp[i-1][j]+board[i][j], dp[i][j])
print(dp[N-1][M-1])
