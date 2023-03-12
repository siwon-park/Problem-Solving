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

def combine(k, s, cmb_lst, Y_cnt):
    global cnt
    if Y_cnt >= 4:
        return
    if k == 7:
        cnt += bfs(cmb_lst)
        return
    for i in range(s, 25):
        if board[lst[i][0]][lst[i][1]] == "Y":
            combine(k+1, i+1, cmb_lst + [lst[i]], Y_cnt + 1)
        else:
            combine(k+1, i+1, cmb_lst + [lst[i]], Y_cnt)

cnt = 0
combine(0, 0, [], 0)
print(cnt)