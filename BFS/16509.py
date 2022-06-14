# 장군(16509번)
###############################################################################################
    # 문제: https://www.acmicpc.net/problem/16509
    # BFS
    # 문제를 딱 봤을 때, 상과 왕만 주어지니까 무조건 갈 수 있는 거 아닌가? 싶었는데, 
    # 방향을 꺾어서 가야하는 도중에 왕이 있으면 못 가는 경우라는 것을 알게되었다.
    # 그런데 코드를 아무리 수정해도 예제의 답도 안 나왔는데, 보니까 ny, nx를 계산함에 있어서 원본 y, x에 대해서 계산하고 있어서 그랬다
    # 그래서 dy, dx값 누적을 위해 ny, nx = y, x로 선언하고 값을 누적시켰으며 flag는 도중에 뭔가 있는지 없는지를 확인하는 변수로 썼다.
    # 또 이 문제에서 주의할 게 1칸 이동할 때마다 visited 배열에 +1을 해주는 게 아니라, 총 3칸 이동해야하는 1가지 경우를 다 이동하고 난 다음에 +1을 해줘야한다.
###############################################################################################
import sys
from collections import deque
input = sys.stdin.readline

INF = sys.maxsize

# 10 X 9 크기의 장기판
visited = [[INF] * 9 for _ in range(10)]
R1, C1 = map(int, input().split()) # 상의 위치
R2, C2 = map(int, input().split()) # 왕의 위치

# 상이 이동할 수 있는 경로
dydx_lst = [
    [(-1, 0), (-1, -1), (-1, -1)],
    [(-1, 0), (-1, 1), (-1, 1)],
    [(0, 1), (-1, 1), (-1, 1)],
    [(0, 1), (1, 1), (1, 1)],
    [(1, 0), (1, 1), (1, 1)],
    [(1, 0), (1, -1), (1, -1)],
    [(0, -1), (-1, -1), (-1, -1)],
    [(0, -1), (1, -1), (1, -1)]
]

def bfs():
    q = deque([(R1, C1)])
    visited[R1][C1] = 0
    while q:
        y, x = q.popleft()
        if (y, x) == (R2, C2):
            return visited[y][x]
        for k in range(8):
            dydx = dydx_lst[k]
            flag = True
            ny, nx = y, x
            for d in range(3):
                dy, dx = dydx[d][0], dydx[d][1]
                ny += dy
                nx += dx
                # 도중에 뭔가 있으면 아예 못 감
                if 0 <= ny < 10 and 0 <= nx < 9 and d != 2 and (ny, nx) == (R2, C2):
                    flag = False
                    break
                # 최종 목적지가 빈 칸일 경우에만 큐에 삽입
                if 0 <= ny < 10 and 0 <= nx < 9 and d == 2 and flag and visited[y][x] + 1 < visited[ny][nx]:
                    visited[ny][nx] = visited[y][x] + 1
                    q.append((ny, nx))
    return -1

print(bfs())
