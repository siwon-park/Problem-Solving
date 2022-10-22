# Baaaaaaaaaduk2 (Easy) (16988번)
############################################################################
    # 문제: https://www.acmicpc.net/problem/16988
    # BFS
    # 0인 지점 2곳을 골라서 브루트포스로 BFS를 돌리면 된다.
    # 계속 시간초과가 나서 보니까 배열을 쓸데없이 늘리고 있었고, 쓸데없는 곳을 방문하고 있었다.
    # 그리고 nx의 범위를 0 <= nx < N으로 잡아버리는 바람에 자꾸 틀렸습니다를 받았다.
    # 생각보다는 단순한 문제였는데 너무 많이 되돌아갔던 것 같다.
    # 다른 사람의 효율적인 풀이를 보고 리팩토링했는데, deque를 쓰는 것보다 그냥 배열(스택)을 쓰는 게 더 빨랐다.
    # pypy3 기준으로 deque의 경우 1312ms, 리스트의 경우 720ms를 받았다
    # 어차피 최단 거리를 찾는 문제가 아니므로 굳이 deque를 쓸 필요는 없다.
############################################################################
import sys
from collections import deque
from itertools import combinations
input = sys.stdin.readline

dydx = [(-1, 0), (0, 1), (1, 0), (0, -1)]

N, M = map(int, input().split())
graph, lst = [], []
for i in range(N):
    graph.append(list(map(int, input().split())))
    for j in range(M):
        if not graph[i][j]:
            lst.append((i, j))


# bfs
def bfs():
    visited = [[False for _ in range(M)] for _ in range(N)]
    E = 0 # 잡히는 돌의 수
    for i in range(N):
        for j in range(M):
            if graph[i][j] == 2 and not visited[i][j]:
                visited[i][j] = True
                q = deque([(i, j)])
                escapable = False # 탈출 가능 여부
                cnt = 1
                while q:
                    y, x = q.popleft()
                    for dy, dx in dydx:
                        ny, nx = y + dy, x + dx
                        if 0 <= ny < N and 0 <= nx < M and not visited[ny][nx]:
                            if not graph[ny][nx]:
                                escapable = True
                            if graph[ny][nx] == 2:
                                q.append((ny, nx))
                                visited[ny][nx] = True
                                cnt += 1
                if not escapable: # 탈출 불가능할 경우
                    E += cnt
    return E


max_catch = 0
for cmb in list(combinations(lst, 2)):
    y1, x1 = cmb[0]
    y2, x2 = cmb[1]
    graph[y1][x1] = 1
    graph[y2][x2] = 1
    max_catch = max(max_catch, bfs())
    graph[y1][x1] = 0
    graph[y2][x2] = 0

print(max_catch)
