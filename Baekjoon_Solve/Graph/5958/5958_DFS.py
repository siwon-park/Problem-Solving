import sys
sys.setrecursionlimit(int(1e7))
input = sys.stdin.readline


def dfs(y: int, x: int) -> None:
    for k in range(4):
        dy, dx = dydx[k]
        ny = y + dy
        nx = x + dx
        if 0 <= ny < N and 0 <= nx < N:
            if not visited[ny][nx] and graph[ny][nx] == "*":
                visited[ny][nx] = True
                dfs(ny, nx)


dydx = [(-1, 0), (0, 1), (1, 0), (0, -1)]
N = int(input()) # 격자판의 크기
graph = []  # 그래프
for _ in range(N):
    graph.append(list(input().rstrip()))

visited = [[False for _ in range(N)] for _ in range(N)]

sector = 0

for i in range(N):
    for j in range(N):
        if not visited[i][j] and graph[i][j] == "*":
            visited[i][j] = True
            dfs(i, j)  # 깊이 우선 탐색
            sector += 1  # 섹터의 번호를 증가

print(sector)