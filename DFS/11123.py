# 양 한마리... 양 두마리...(11123번)
###########################################################
    # 문제: https://www.acmicpc.net/problem/11123
    # BFS, DFS
    # 같은 구획 및 붙어있는 영역이 몇개인지 찾는 것과 같은 평범한 BFS, DFS 문제
    # 재귀호출 제한을 풀지 않으면 recursion에러 발생함
###########################################################
import sys
sys.setrecursionlimit(int(1e5)) # 재귀호출 제한을 풀어줘야함
input = sys.stdin.readline

def dfs(y, x):
    visited[y][x] = True
    for dy, dx in dydx:
        ny, nx = y+dy, x+dx
        if 0 <= ny < H and 0 <= nx < W:
            if board[ny][nx] == "#" and not visited[ny][nx]:
                visited[ny][nx] = True
                dfs(ny, nx)
    
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
                dfs(h, w)
                cnt += 1
    print(cnt)
