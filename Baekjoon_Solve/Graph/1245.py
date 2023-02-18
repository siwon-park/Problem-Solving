# 농장관리(1245번)
##########################################################################################
    # 문제: https://www.acmicpc.net/problem/1245
    # DFS, BFS
    # DFS에 익숙해 지기위해 DFS로 풀어보았다.
    # 처음에 4방향이라고 생각했는데, 예제 결과가 자꾸 4가 나와서 문제를 다시 한 번 읽어보니 8방향에 대해 탐색해야한다.
    # 주변을 탐색했을 때, 자기 자신의 높이보다 큰 곳이 있으면 flag에 False를 기록하고 방문은 계속하였다.
    # 방문을 계속한 이유는 지금 여기서 탐색을 종료하면 아직 방문하지 않은 같은 집합군을 탐색하게 되므로 비효율이 발생하기 때문이다.
    # 그래서 False를 기록한 뒤에도 계속 탐색하였고, False가 나오지 않는 다면 그곳은 산봉우리이므로 area += 1을 해주었다.
##########################################################################################
import sys
sys.setrecursionlimit(int(1e5))
input = sys.stdin.readline

N, M = map(int, input().split())
board = [list(map(int, input().split())) for _ in range(N)]

visited = [[False]*M for _ in range(N)]
dydx = [(-1, 0), (0, 1), (1, 0), (0, -1), (-1, -1), (-1, 1), (1, 1), (1, -1)]

def dfs(y, x, h):
    global flag
    visited[y][x] = True
    for dy, dx in dydx:
        ny, nx = y + dy, x + dx
        if 0 <= ny < N and 0 <= nx < M:
            if board[ny][nx] > h:
                flag = False
            if not visited[ny][nx] and board[ny][nx] == h:
                dfs(ny, nx, h)
    
area = 0
for i in range(N):
    for j in range(M):
        if not visited[i][j] and board[i][j]:
            flag = True
            dfs(i, j, board[i][j])
            if flag:
                area += 1
                
print(area)
