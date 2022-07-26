# 피리부는 사나이(16724번)
###################################################################################
    # 문제: https://www.acmicpc.net/problem/16724
    # DFS
    # 15559번 내 선물을 받아줘와 완전히 같은 문제이다
    # 다시 한번 해설을 하면 dfs로 영역의 번호를 표시하면서 방문하지 않은 곳을 방문한다
    # 만약 다음 방문할 곳이 현재의 영역의 번호와 같다면 해당 루트는 해당 루트를 구성하는 어떤 점에서 출발해도
    # 해당 루트의 어떤 점이든 도달할 수 있기 때문에 cnt += 1을 해준다
    # 그냥 visited에 True로 표시하면 안될까라는 고민을 할 수 있는데, 결론부터 이야기하자면 안 된다.
    # 왜냐하면 A 집합군이 아닌데, 어느 한 곳에서 방향을 따라 해당 집합군으로 올 수 있다고 한다면
    # 최종적으로 cnt = 1로 계산해야하는데, 단순히 True로 체크를 하게 되면 A 집합군에서 체크할 때 cnt += 1,
    # 다른 어느 한 곳에서 A 집합군에 도달했을 때 cnt += 1로 cnt = 2로 체크하게 된다.
    # 어느 곳에서 출발하더라도 SAFE인 영역을 구해야하므로, 위의 경우 올바르게 영역의 개수를 센 것은 cnt = 1인 경우이다
###################################################################################
import sys
input = sys.stdin.readline

N, M = map(int, input().split())
board = [list(input().rstrip()) for _ in range(N)]

dydx_dict = {"D": (1, 0), "L": (0, -1), "R": (0, 1), "U": (-1, 0)}

def dfs(y, x, area):
    global cnt
    visited[y][x] = area
    dy, dx = dydx_dict[board[y][x]]
    ny, nx = y + dy, x + dx
    if 0 <= ny < N and 0 <= nx < M:
        if not visited[ny][nx]:
            dfs(ny, nx, area)
        elif visited[ny][nx] == area:
            cnt += 1

visited = [[False]*M for _ in range(N)]

cnt = 0
area = 1
for r in range(N):
    for c in range(M):
        if not visited[r][c]:
            dfs(r, c, area)
            area += 1

print(cnt)
