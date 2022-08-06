# 외판원 순회2(10971번)
###############################################################
    # 문제: https://www.acmicpc.net/problem/10971
    # 백트랙킹
    # 전형적인 TSP문제이다.
    # i에서 j로 갈 수 없는 경우 w[i][j] = 0으로 주어진다는 점을 주의해야한다. w[i][i]에 대해서만 0으로 주어지는 것이 아님을 유의
###############################################################
import sys
sys.setrecursionlimit(int(1e5))
input = sys.stdin.readline

def dfs(k, s, cost):
    global min_cost
    if cost > min_cost:
        return
    if k == N-1:
        if board[s][0]: # s에서 0로 갈 수 없는 경우(되돌아 갈 수 없는 경우)는 고려하면 안 됨
            cost += board[s][0]
            if cost < min_cost:
                min_cost = cost
        return
    for i in range(1, N):
        if not visited[i] and board[s][i]: # 아직 방문하지 않았고, s에서 i로 갈 수 있는 경우에만 고려
            visited[i] = True
            dfs(k+1, i, cost+board[s][i])
            visited[i] = False

N = int(input())
board = [list(map(int, input().split())) for _ in range(N)]
visited = [False]*N
min_cost = sys.maxsize
visited[0] = True
dfs(0, 0, 0)
print(min_cost)
