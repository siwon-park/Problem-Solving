# 모래성(10711번)
##################################################
    # 문제: https://www.acmicpc.net/problem/10711
    # BFS, 그래프 이론
    # 11%에서 시간초과가 났고, 고민하다가 BFS를 한번만 돌려야한다는 것까진 캐치했는데, 어떻게 하나 싶었는데,
    # 알고보니, 모래성이 안 쌓인 곳 "."인 곳만 큐에 넣고, BFS를 돌리면 되는 것이었다.
    # 처음 구현한 코드는 문제에서 나오는 로직 그대로 구현한 코드였고, 나중에 무너지는 곳이 계속 일단 계속 큐에는 들어가야하고,
    # 그 숫자가 7, 8 이렇게 되면 결국 하나의 위치 대해서도 여러 번 탐색해야하므로 엄청난 중복이 발생하게 된다.
    # 무슨 말이냐면, 모래성의 튼튼함이 7이나 8이고 가운데 위치해 있고 어쨌든 결국에 없어진다고 한다면, 시간 초과 코드에 따를 경우
    # 얘는 자기 차례가 올 때까지 계속 큐에 들어가야하고, 그것도 주변에 아직 "."이 없는데도 8방향을 계속해서 중복적으로 탐색해야한다는 뜻이다.
    # 이는 엄청난 비효율인데, 왜냐하면 지금 상황에서 굳이 탐색하지 않아도 되는 곳에 대하여 8방향씩 탐색을 하고 있는 것이기 때문이다.
    # 사실 보면 중요한 것은 주변에 "."이 있냐 없냐이므로 "."의 좌표를 큐에 넣고 8방향으로 숫자가 존재한다면 그 수를 -1씩 하다가,
    # 0이 되는 순간에 "."으로 간주하고 해당 위치를 큐에 넣는 것이다.
    # 생각해보면 우리의 최종 목표는 파도가 몇번 쳤을 때 더 이상 모양이 변하지 않는가이지, 현재 모래성의 상태를 출력하라는 것이 아니므로
    # 해당 위치 값이 음수가 되어도 상관없다. 물론 상태를 출력하라고 해도, 음수인 부분은 그냥 "."처리 하면 되기 때문에 크게 중요치 않다.
##################################################
#################### 11% 시간초과 출력 코드(문제의 로직을 그대로 구현함)######################
import sys
from collections import deque
input = sys.stdin.readline

dydx = [(-1, -1), (-1, 0), (-1, 1), (0, 1), (1, 1), (1, 0), (1, -1), (0, -1)]

H, W = map(int, input().split())
board = []
q = deque()
alive = 0 # 살아남은 모래성의 개수
for i in range(H):
    board.append(list(input().rstrip()))
    for j in range(W):
        if board[i][j] != ".":
            alive += 1
            if board[i][j] != "9": # 9는 절대 안 무너지므로 큐에 넣지 않음
                q.append((i, j))

def bfs(q, left):
    next_q = deque()
    brk_q = deque() # 무너질 모래성의 좌표를 넣어서 "."으로 만듦
    while q:
        y, x = q.popleft()
        cnt = 0
        cur = int(board[y][x])
        for dy, dx in dydx:
            ny, nx = y+dy, x+dx
            if 0 <= ny < H and 0 <= nx < W:
                if board[ny][nx] == ".":
                    cnt += 1
                    if cnt >= cur: # 모래성이 쌓여있지 않은 개수가 현재 모래성의 튼튼함 이상이면
                        brk_q.append((y, x))
                        break
        else:
            next_q.append((y,x))
    
    while brk_q: # 모래성을 "."으로 만듦
        y, x = brk_q.popleft()
        board[y][x] = "."
        left -= 1 # 모래성의 수를 -1함
    return next_q, left

ans = 0
last = alive
while True:
    q, alive = bfs(q, alive)
    if last == alive:
        break
    ans += 1
    last = alive
    # for lst in board:
    #     print(*lst)
    # print("=-=-=-=-=-=-=-=-=-=-")
print(ans)

###################### 통과 코드 ##########################
# 처음 입력에 대해서 숫자로 변환하기 위해 코드가 좀 길지, 오히려 코드도 더 간단하다.
import sys
from collections import deque
input = sys.stdin.readline

dydx = [(-1, -1), (-1, 0), (-1, 1), (0, 1), (1, 1), (1, 0), (1, -1), (0, -1)]

H, W = map(int, input().split())
board = []
q = deque()
for i in range(H):
    board.append(list(input().rstrip()))
    for j in range(W):
        if board[i][j] == ".":
            q.append((0, i, j))
            board[i][j] = 0
        else:
            board[i][j] = int(board[i][j])

while q:
    t, y, x = q.popleft()
    for dy, dx in dydx:
        ny, nx = y+dy, x+dx
        if 0 <= ny < H and 0 <= nx < W:
            board[ny][nx] -= 1
            if board[ny][nx] == 0:
                q.append((t+1, ny, nx))
print(t)
