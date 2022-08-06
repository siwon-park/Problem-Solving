# 점프(1890번)
##########################################################################
    # 문제: https://www.acmicpc.net/problem/1890
    # 다이나믹 프로그래밍
    # 메모이제이션으로 풀어보았다.
    # (N-1, N-1)에서 출발해서 위쪽, 왼쪽에서 온 값을 더 하는 방식으로 해결하였다.
##########################################################################
import sys
sys.setrecursionlimit(int(1e5))
input = sys.stdin.readline

def dfs(r, c):
    if memo[r][c]:
        return memo[r][c]
    up, left = 0, 0 # 위쪽, 왼쪽
    for dr in range(1, r+1): # 위쪽에서 오는 경우
        if board[r-dr][c] == dr: # board[r-dr][c]에 기록된 값이 dr이면 점프해서 board[r][c]까지 올 수 있으므로 재귀호출
            up += dfs(r-dr, c)
    for dc in range(1, c+1): # 왼쪽에서 오는 경우
        if board[r][c-dc] == dc: # board[r][c-dc]에 기록된 값이 dc이면 점프해서 board[r][c]까지 올 수 있으므로 재귀호출
            left += dfs(r, c-dc)
    memo[r][c] = up + left
    return memo[r][c]

N = int(input())
board = [list(map(int, input().split())) for _ in range(N)]
memo = [[0]*N for _ in range(N)]
memo[0][0] = 1

print(dfs(N-1, N-1))
