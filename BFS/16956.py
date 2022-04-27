# 늑대와 양(16956번)
###################################################################################
    # 문제: https://www.acmicpc.net/problem/16956
    # BFS
    # 양의 위치를 리스트에 담은 뒤 해당 위치별로 상하좌우에 D로 울타리를 체크한 뒤에
    # 늑대의 좌표들을 큐에 넣어서 BFS를 돌려서 양까지 갈 수 있는지 판별하는 방법으로 해결하였다.
    # 빠른 풀이는 아니었는데, 다 풀고나서 생각해보니까 어차피 맵은 출력해야하고, 늑대가 양까지 무슨 수를 써서라도 갈 수 있는지 없는지
    # 체크해야하는 게 핵심이므로 늑대가 반드시 양까지 갈 수 있는 케이스가 뭐가 있는지 생각해보니
    # 바로 옆에 붙어 있으면 무조건 갈 수 있다. 한 칸이라도 건너서 위치한다면 울타리를 설치해서 못 올 수 있게할 수 있다.
    # 따라서 아마도 양의 위치 주변에 늑대가 있다면 바로 0을 출력하게 함으로써 더 빠른 풀이로 해결 가능할 듯 싶다.
###################################################################################
import sys
from collections import deque
input = sys.stdin.readline

R, C = map(int, input().split())
board = []
sheeps = []
q = deque()
visited = [[False] * C for _ in range(R)]

for i in range(R):
    board.append(list(input().rstrip()))
    for j in range(C):
        if board[i][j] == "S":
            sheeps.append((i, j))
        elif board[i][j] == "W":
            q.append((i, j))
            visited[i][j] = True

dydx = [(-1, 0), (0, 1), (1, 0), (0, -1)]

for y, x in sheeps:
    for dy, dx in dydx:
        ny, nx = y + dy, x + dx
        if 0 <= ny < R and 0 <= nx < C and board[ny][nx] == ".":
            board[ny][nx] = "D"

def bfs(q):
    while q:
        y, x = q.popleft()
        for dy, dx in dydx:
            ny, nx = y + dy, x + dx
            if 0 <= ny < R and 0 <= nx < C and not visited[ny][nx]:
                if board[ny][nx] == ".":
                    visited[ny][nx] = True
                    q.append((ny, nx))
                elif board[ny][nx] == "S":
                    return 0
    return 1

ret = bfs(q)
print(ret)
if ret:
    for lst in board:
        print("".join(lst))
