# 소문난 칠공주(1941번)
###############################################################################
    # 문제: https://www.acmicpc.net/problem/1941
    # 브루트포스, BFS, DFS
    # DFS로 조합을 구성하여 조합이 갖춰졌으면 BFS 탐색을 통해 해결하였음 
    # DFS를 통해 25개의 좌표 중 7개를 뽑는다. 조합을 구성하면서 가지치기를 하는데, Y의 개수가 4 이상이면 return한다.
    # 가지치기를 통과해서 7개의 좌표가 모였으면 BFS탐색을 통해 7개의 좌표가 하나의 연결 컴포넌트로 연결되어 있는지 확인한다.
    # 한 개의 연결 컴포넌트로 연결되어 있다면 소문난 칠공주를 결성할 수 있는 케이스이므로 1을 반환하여 경우의 수(cnt)에 합산한다.
    # 두 개 이상의 연결 컴포넌트라면 서로 이어져있지 않으므로 0을 리턴하여 cnt에 합산한다.(cnt에 0을 더하는 것이므로 변화 없음)
###############################################################################
import sys
from collections import deque
input = sys.stdin.readline

board = [list(input().rstrip()) for _ in range(5)]

lst = [(i, j) for i in range(5) for j in range(5)] # 좌표 모음

dydx = [(-1, 0), (0, 1), (1, 0), (0, -1)]

def bfs(cmb):
    area = 0 # 서로 이어져있는지 확인, 이어져 있으면 1임 # 경우의 수 값으로 사용
    visited = [[False] * 5 for _ in range(5)]
    for r, c in cmb:
        if not visited[r][c]:
            visited[r][c] = True
            area += 1
            if area > 1: # 2 이상이면 끊겨있으므로 경우의 수 0을 반환
                return 0
            q = deque([(r, c)])
            while q:
                y, x = q.popleft()
                for dy, dx in dydx:
                    ny, nx = y + dy, x + dx
                    if 0 <= ny < 5 and 0 <= nx < 5:
                        if (ny, nx) in cmb and not visited[ny][nx]:
                            q.append((ny, nx))
                            visited[ny][nx] = True
    return 1 # 경우의 수 1개 반환

def combine(k, s, cmb_lst, Y_cnt): # k개 뽑음, s는 시작 인덱스, cmb_lst는 조합을 담을 리스트, Y_cnt는 임도연파의 수
    global cnt
    if Y_cnt >= 4: # 임도연파가 4명 이상이면 return
        return
    if k == 7: # 7명이 모였으면 BFS탐색 시작
        cnt += bfs(cmb_lst)
        return
    for i in range(s, 25):
        if board[lst[i][0]][lst[i][1]] == "Y": # 뽑으려는 좌표가 임도연파(Y)이면 Y_cnt + 1을 하여 dfs 탐색
            combine(k+1, i+1, cmb_lst + [lst[i]], Y_cnt + 1)
        else:
            combine(k+1, i+1, cmb_lst + [lst[i]], Y_cnt)

cnt = 0
combine(0, 0, [], 0)
print(cnt)
