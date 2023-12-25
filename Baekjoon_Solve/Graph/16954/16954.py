# 움직이는 미로 탈출(16954번)
#######################################################################################
    # 문제: https://www.acmicpc.net/problem/16954
    # BFS
    # 아마 실제 코딩테스트에 나왔으면 절대 못 통과했을 것 같다.
    # 내가 놓친 점은 3차원의 방문 배열을 사용하는 것이었다. 그냥 2차원이면 충분할 것 같았는데, 방문 체크를 하려면 3차원의 배열을 사용해야한다.
    # 또하나 놓친 것은 벽이 아랫방향으로 내려가는데, 아래에서부터 차례로 내렸어야했는데, 처음에 벽을 배열에 담을 때 위에서부터 담아서
    # 벽을 아래로 내리는 로직에서 실수를 하고 있었다.
    # 그리고 오히려 남들이 놓친 제자리에 대한 방문은 잘 처리했는데, 큰 실수를 하나 더 했다.
    # BFS의 while q에서 들여쓰기를 잘못하고 있었다. 일단 현재 큐에서 모든 요소를 뽑아서 다음 위치로 가는 큐를 구해서
    # 그 다음번째에도 이동이 가능한지 확인해야하는데, 큐에서 어떤 요소를 뽑을 때마다 그러한 행동을 하고 있어서 못 도착하는 경우가 있음에도 불구하고
    # 도착을 할 수 있다고 출력하고 있었다.
    # 이런 디테일과 설계를 제대로 하지 못하면 코딩테스트 통과는 어려울 듯하다.
#######################################################################################
import sys
from collections import deque
input = sys.stdin.readline

dydx = [(0, 0), (-1, 0), (0, 1), (1, 0), (0, -1), (-1, -1), (-1, 1), (1, 1), (1, -1)]

# 벽을 움직이는 함수
def map_move(wq):
    nxt_wq = []
    for y, x in wq:
        ny = y + 1
        nx = x
        if 0 <= ny < 8 and 0 <= nx < 8 and board[ny][nx] == ".":
            board[ny][nx], board[y][x] = "#", "."
            nxt_wq.append((ny, nx))
        elif ny >= 8:
            board[y][x] = "."
    return nxt_wq

# bfs
def bfs(wq):
    q = deque([(0, 7, 0)])
    visited = [[[False] * 9 for _ in range(8)] for _ in range(8)]
    nxt_q = deque()
    while q:
        n = len(q)
        for _ in range(n): # 일단 현재 큐에서 요소를 모두 뽑아서 다음 위치로 이동함
            d, y, x = q.popleft()
            if (y, x) == (0, 7):
                return 1
            for k in range(9):
                dy, dx = dydx[k][0], dydx[k][1]
                ny, nx = y + dy, x + dx
                if 0 <= ny < 8 and 0 <= nx < 8 and not visited[ny][nx][k] and board[ny][nx] == ".":
                    visited[ny][nx][k] = True
                    nxt_q.append((k, ny, nx))
        wq = map_move(wq)
        while nxt_q: # 다음으로 이동한 위치가 벽이랑 겹치지 않는 위치이면 q에 삽입하고 그렇지 않으면 continue
            k, y, x = nxt_q.popleft()
            if (y, x) in wq:
                continue
            else:
                q.append((k, y, x))
    return 0

wq = deque([])
board = [list(input().rstrip()) for _ in range(8)]
for i in range(7, -1, -1):
    for j in range(8):
        if board[i][j] == "#":
            wq.append((i, j))

print(bfs(wq))
