# 내 선물을 받아줘(15559번)
##########################################################################
    # 문제: https://www.acmicpc.net/problem/15559
    # DFS, 분리집합
    # 분리집합(서로소)을 활용한 풀이
    # 처음에 분리집합으로 접근해서 문제를 풀고나니까 더 빠른 풀이가 있길래 봤더니 DFS로도 접근이 가능했다
    # DFS풀이가 분리집합보다 메모리, 속도 측면에서 많은 이점이 있다.
    # 풀이는 그동안 BFS문제에서 많이 접해본 연결 컴포넌트의 개수를 구하는 문제를 DFS로 해결하면 된다.
    # N*M 배열을 탐색하면서 방문하지 않았다면, dfs탐색을 계속 진행하고 해당 위치에 현재 영역의 번호를 매겨준다
    # 만약 새로 탐색할 영역에 현재의 영역 번호가 매겨져있다면, cnt++를 한 다음 dfs 함수는 호출하지 않는다.
    # 맨 마지막으로 dfs호출이 다 끝나고나면 영역의 번호를 1증가시켜서 다음 영역의 번호를 탐색하게끔 한다.
##########################################################################
import sys
sys.setrecursionlimit(int(1e5))
input = sys.stdin.readline

N, M = map(int, input().split())
board = [list(input().rstrip()) for _ in range(N)]

dydx = [(-1, 0), (0, 1), (1, 0), (0, -1)]
W = {'N': 0, 'E': 1, 'S': 2, 'W': 3}

visited = [[False] * M for _ in range(N)]

cnt = 0
def dfs(r, c):
    global cnt
    visited[r][c] = area
    k = W[board[r][c]]
    dr, dc = dydx[k][0], dydx[k][1]
    nr, nc = r + dr, c + dc
    if 0 <= nr < N and 0 <= nc < M:
        if visited[nr][nc] == area:
            cnt += 1
        elif not visited[nr][nc]:
            visited[nr][nc] = area
            dfs(nr, nc)

area = 1
for r in range(N):
    for c in range(M):
        if not visited[r][c]:
            dfs(r, c)
            area += 1

print(cnt)
