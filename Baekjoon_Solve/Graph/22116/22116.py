# 창영이와 퇴근 (22116번)
import sys, heapq
input = sys.stdin.readline

INF = sys.maxsize
N = int(input())
board = []
dydx = [(-1, 0), (0, 1), (1, 0), (0, -1)]

for i in range(N):
    board.append(list(map(int, input().split())))


def dijkstra():
    q = []
    distance = [[INF] * N for i in range(N)]
    distance[0][0] = 0
    heapq.heappush(q, (0, 0, 0))
    while q:
        dist, y, x = heapq.heappop(q)
        if distance[y][x] < dist:
            continue
        for dy, dx in dydx:
            ny, nx = y + dy, x + dx
            if 0 <= ny < N and 0 <= nx < N:
                nxt_dist = max(dist, abs(board[ny][nx] - board[y][x]))
                if nxt_dist < distance[ny][nx]:
                    distance[ny][nx] = nxt_dist
                    heapq.heappush(q, (nxt_dist, ny, nx))
    return distance


print(dijkstra()[N - 1][N - 1])
