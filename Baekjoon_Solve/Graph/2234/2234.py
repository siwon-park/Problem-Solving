# 성곽 (2234번)
import sys
from collections import deque
input = sys.stdin.readline

dydx = [(0, -1), (-1, 0), (0, 1), (1, 0)] # 0: 서, 1: 북, 2: 동, 3: 남

M, N = map(int, input().rstrip().split())
graph = []
for i in range(N):
    graph.append(list(map(int, input().rstrip().split())))

room = []
visited = [[0 for _ in range(M)] for _ in range(N)]


def bfs(r: int, c: int, rn: int):
    q = deque([(r, c)]) # 행, 열
    visited[r][c] = rn
    ret = 0
    while q:
        y, x = q.popleft()
        bit = graph[y][x]
        ret += 1
        for k in range(4):
            ny = y + dydx[k][0]
            nx = x + dydx[k][1]
            if bit & (1 << k) == 0 and 0 <= ny < N and 0 <= nx < M:
                if not visited[ny][nx]:
                    visited[ny][nx] = rn
                    q.append((ny, nx))
    room.append(ret)


rn = 1 # 방 번호
room_dict = dict()
for r in range(N):
    for c in range(M):
        if not visited[r][c]:
            bfs(r, c, rn)
            rn += 1
        cur = visited[r][c]
        for k in range(4):
            nr, nc = r + dydx[k][0], c + dydx[k][1]
            if 0 <= nr < N and 0 <= nc < M and visited[nr][nc] and visited[nr][nc] != cur:
                room_dict[cur] = room_dict.get(cur, set())
                room_dict[visited[nr][nc]] = room_dict.get(visited[nr][nc], set())
                room_dict[cur].add(visited[nr][nc])
                room_dict[visited[nr][nc]].add(cur)

max_size = 0
for k, v_list in room_dict.items():
    cur_size = room[k - 1]
    for v in v_list:
        max_size = max(max_size, cur_size + room[v - 1])

print(rn - 1)
print(max(room))
print(max_size)