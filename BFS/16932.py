# 모양 만들기(16932번)
########################################################################
    # 문제: https://www.acmicpc.net/problem/16932
    # BFS
    # 그냥 생각없이 풀면 시간초과 나는 문제
    # board[i][j] == 1인 부분에 대해서 영역의 번호를 매겼고, 해당 영역 번호별 크기를 담을 리스트를 만들고 영역의 크기를 기록하였다.
    # 그리고 영역의 번호와 크기를 구하는 BFS를 돌리면서 경계지점이 0인 곳의 좌표를 borders에 담았다.
    # bfs가 끝난 이후, borders에 대하여 0과 인접한 곳의 영역이 다를 경우 해당 영역 번호의 영역 크기를 합산하였고,
    # 합산한 결과와 최댓값을 비교하여 최댓값을 갱신하였다.
########################################################################
import sys
from collections import deque
input = sys.stdin.readline

N, M = map(int, input().split())
board = []
lst = []
for i in range(N):
    board.append(list(map(int, input().split())))
    for j in range(M):
        if board[i][j] == 1:
            lst.append((i, j))

dydx = [(-1, 0), (0, 1), (1, 0), (0, -1)]

max_area = 0
visited = [[False]*M for _ in range(N)] # 최단 거리 기록
land = [0] * 1000001 # 영역별 크기를 담을 리스트(영역이 얼마나 많을지 모르니 N*M 크기로 선언)

no = 1 # 영역의 번호
borders = set() # 경계지점에 있는 0을 담을 집합
for i, j in lst:
    if not visited[i][j]:
        q = deque([(i, j)])
        visited[i][j] = True
        board[i][j] = no # 영역 표시
        area = 0 # 각 영역의 크기
        while q:
            y, x = q.popleft()
            area += 1
            for dy, dx in dydx:
                ny, nx = y + dy, x + dx
                if 0 <= ny < N and 0 <= nx < M:
                    if not visited[ny][nx] and board[ny][nx]:
                        visited[ny][nx] = True
                        board[ny][nx] = no
                        q.append((ny, nx))
                    elif not board[ny][nx]:
                        borders.add((ny, nx))
        land[no] = area # 각 영역별 크기를 기록
        no += 1

for y, x in borders:
    tmp = set() # 영역 번호를 담을 집합
    for dy, dx in dydx:
        ny, nx = y + dy, x + dx
        if 0 <= ny < N and 0 <= nx < M:
            if board[ny][nx]:
                tmp.add(board[ny][nx])
    tmp_area = 1 # 0부터 체크하니 크기는 1부터 출발
    for no in tmp: # 영역이 다를 경우에 현재 영역에 합산
        tmp_area += land[no] 
    max_area = max(tmp_area, max_area)

print(max_area)
