# 불(5427번)
#######################################################################
    # 문제: https://www.acmicpc.net/problem/5427
    # BFS(너비 우선 탐색), 그래프 이론
    # 처음 푼 풀이(풀이2)는 4020ms가 나왔고, 두 번째 풀이(풀이1)는 2320ms가 나왔다.
    # 로직은 똑같은데 첫 번째 풀이는 우선 불이 퍼지는 최단 거리를 bfs로 기록해줬고, 그 다음 상근이가 불과 마주치지 않으면서 bfs로 탈출구까지 도달할 수 있는지 확인하였다.
    # 두 번째 풀이는 bfs를 한번만 돌렸고, 상근이의 위치와 불의 위치를 모두 큐에 넣고 탐색하였다.
    # 첫 번째 풀이 로직으로 푼 이유는 불이 더 빨리 퍼질 수 있는데도 불구하고 상근이가 먼저 탈출하는 케이스가 존재할 것 같아서 그랬다.
    # 하지만 bfs로 최단거리를 탐색할 경우 다음 위치까지 도달한 것이 최초라면 해당 위치까지의 최단거리를 항상 보장하므로(FIFO니까), 굳이 첫번째 풀이처럼 bfs를 두 번 돌릴 필요가 없다.
    # 다만 불때문에 상근이가 탈출할 수 없음에도 먼저 도착하는 경우가 생길 수도 있으니, 큐에서 요소를 뽑아서 시작할 때 모든 불이 먼저 큐에서 출발을 시작하고 그 다음에 상근이가 출발해야한다.
    # 따라서 최초로 입력을 받을 때, 불을 우선적으로 전부 큐에 넣어주고, 상근이의 위치는 제일 마지막에 넣어준다.
    # 이 로직의 핵심은 불이 먼저 퍼지기 시작했음에도 불구하고 늦게 출발한 상근이가 출구 또는 다음 위치까지 불보다 더 빠르게 도달할 수 있는지 확인하는 것이다. 
#######################################################################

############### 풀이 1 (2320ms) ######################
import sys
from collections import deque
input = sys.stdin.readline

INF = sys.maxsize
dydx = [(-1, 0), (0, 1), (1, 0), (0, -1)]

def bfs(q):
    while q:
        case, y, x = q.popleft()
        for dy, dx in dydx:
            ny, nx = y+dy, x+dx
            if 0 <= ny < h and 0 <= nx < w:
                if board[ny][nx] != "#":
                    if spread_table[y][x] + 1 < spread_table[ny][nx]:
                        spread_table[ny][nx] = spread_table[y][x] + 1
                        q.append((case, ny, nx))
                        board[ny][nx] = case
            else:
                if board[y][x] == "@":
                    return spread_table[y][x] + 1
    return "IMPOSSIBLE"

T = int(input())
for t in range(T):
    w, h = map(int, input().split())
    board = []
    spread_table = [[INF]*w for _ in range(h)]
    q = deque()
    for i in range(h):
        board.append(list(input().rstrip()))
        for j in range(w):
            if board[i][j] == "@":
                sy, sx = i, j # 상근이의 위치를 기록함
                spread_table[i][j] = 0
            elif board[i][j] == "*":
                q.append(("*", i, j))
                spread_table[i][j] = 0
    q.append(("@", sy, sx)) # 모든 불의 위치를 큐에 삽입 후 맨 마지막에 상근이의 위치를 넣어줌
    print(bfs(q))
    
################ 풀이 2 (4020ms) ###################
import sys
from collections import deque
input = sys.stdin.readline

INF = sys.maxsize
dydx = [(-1, 0), (0, 1), (1, 0), (0, -1)]

def spread_fire(fq):
    while fq:
        y, x = fq.popleft()
        for dy, dx in dydx:
            ny, nx = y+dy, x+dx
            if 0 <= ny < h and 0 <= nx < w:
                if board[ny][nx] != "#":
                    if spread_table[y][x] + 1 < spread_table[ny][nx]:
                        spread_table[ny][nx] = spread_table[y][x] + 1
                        fq.append((ny, nx))

def bfs(sy, sx):
    q = deque([(sy, sx)])
    spread_table[sy][sx] = 0
    while q:
        y, x = q.popleft()
        for dy, dx in dydx:
            ny, nx = y+dy, x+dx
            if 0 <= ny < h and 0 <= nx < w:
                if board[ny][nx] == ".":
                    if spread_table[y][x] + 1 < spread_table[ny][nx]:
                        spread_table[ny][nx] = spread_table[y][x] + 1
                        q.append((ny, nx))
            else:
                return spread_table[y][x] + 1
    return "IMPOSSIBLE"

T = int(input())
for t in range(T):
    w, h = map(int, input().split())
    board = []
    spread_table = [[INF]*w for _ in range(h)]
    fire_queue = deque()
    for i in range(h):
        board.append(list(input().rstrip()))
        for j in range(w):
            if board[i][j] == "@":
                sy, sx = i, j
            elif board[i][j] == "*":
                fire_queue.append((i,j))
                spread_table[i][j] = 0
    spread_fire(fire_queue)
    print(bfs(sy, sx))
