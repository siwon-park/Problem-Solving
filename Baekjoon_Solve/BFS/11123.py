# 양 한마리... 양 두마리...(11123번)
##################################################
    # 문제: https://www.acmicpc.net/problem/11123
    # BFS, DFS
    # 전형적인 평범한 BFS문제
    # DFS로도 풀었는데 DFS가 아주 근소한 차이로 빨랐다. (DFS: 280ms, BFS: 300ms)
##################################################
import sys
from collections import deque
input = sys.stdin.readline

def bfs(h, w):
    visited[h][w] = True
    q = deque([(h, w)])
    while q:
        y, x = q.popleft()
        for dy, dx in dydx:
            ny, nx = y+dy, x+dx
            if 0 <= ny < H and 0 <= nx < W:
                if board[ny][nx] == "#" and not visited[ny][nx]:
                    visited[ny][nx] = True
                    q.append((ny, nx))
    
dydx = [(-1, 0), (0, 1), (1, 0), (0, -1)]

T = int(input())
for t in range(T):
    H, W = map(int, input().split())
    board = [list(input().rstrip()) for _ in range(H)]
    visited = [[False]*W for _ in range(H)]
    cnt = 0
    for h in range(H):
        for w in range(W):
            if board[h][w] == "#" and not visited[h][w]:
                bfs(h, w)
                cnt += 1
    print(cnt)
