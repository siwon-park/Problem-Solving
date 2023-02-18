# 좀비 바이러스(24513번)
###############################################################
    # 문제: https://www.acmicpc.net/problem/24513
    # BFS, 그래프 이론
    # Python3는 5%에서 시간초과, Pypy3는 560m/s로 통과(풀 당시 제출한 사람 중 파이썬으로 통과한 사람이 1명 뿐이었다. ㄷㄷ)
    # 1번 바이러스와 2번 바이러스가 만났을 때 항상 3번이 되는 것이 아님을 유의해야한다. 서로 동시에 퍼져서 만났을 때 3번으로 바뀌게 되는 것이다.
    # 1번과 2번이 동시에 퍼진다고 했는데, 1번을 먼저 퍼지게 한 다음 2번을 퍼지게 했을 때, 특정 조건이 맞으면 3번 바이러스로 바꾸는 로직을 적용하였다.
    # 여기서 말하는 조건이란 타임 테이블에 기록된 숫자인데, 1번이 일단 먼저 사방으로 퍼지면 퍼진 곳의 숫자는 현재 1번의 타임테이블에 기록된 숫자에 +1을 시킨 값이다.
    # 이제 그 다음 2번이 퍼지게 되는데, 만약 2번이 사방으로 퍼졌을 때, 해당 위치가 1번이 기록되었는데 그 차이가 1이라면, 1번이 바로 방금전에 퍼졌다는 의미이므로,
    # 사실상 동시에 퍼져서 만나게 되는 곳이라는 의미이다. 따라서 그곳에 3을 기록해주고 3번 바이러스의 개수인 cnt3 += 1을 해준다.
###############################################################
import sys
from collections import deque
input = sys.stdin.readline

N, M = map(int, input().split())
board = []
cnt1, cnt2 = 0, 0

for i in range(N):
    board.append(input().rstrip().split())
    for j in range(M):
        if board[i][j] == "1":
            # 1번 바이러스의 좌표를 기록
            q1 = deque([(i, j)])
        elif board[i][j] == "2":
            # 2번 바이러스의 좌표를 기록
            i2, j2 = i, j
            q2 = deque([(i, j)])
dydx = [(-1, 0), (0, 1), (1, 0), (0, -1)] # 상우하좌 이동값

def spread_v(q, cnt):
    global cnt3
    spread_q = deque()
    while q:
        y, x = q.popleft()
        if board[y][x] == "3":
            continue
        cnt += 1  # cnt1 또는 cnt2를 증가
        for dy, dx in dydx:
            ny, nx = y+dy, x+dx
            if 0 <= ny < N and 0 <= nx < M:
                if board[ny][nx] == "0":
                    spread_q.append((ny,nx))
                    board[ny][nx] = board[y][x]
                    time_table[ny][nx] = time_table[y][x] + 1
                elif board[ny][nx] != board[y][x] and board[ny][nx] != "3" and time_table[ny][nx] == time_table[y][x] + 1:
                    board[ny][nx] = "3"  # 3번 바이러스는 1번과 2번이 만났을 때 발생함
                    cnt3 += 1
    return spread_q, cnt

cnt3 = 0 
time_table = [[0]*M for _ in range(N)] # 로직상 1번이 퍼지고 2번이 퍼졌을 때 3번이 되어야 하므로,
# 같은 기간 안에 퍼졌을 때 1번과 2번이 만난다면 1번의 타임 테이블 숫자는 2번보다 1크다

while True:
    q1, cnt1 = spread_v(q1, cnt1)
    q2, cnt2 = spread_v(q2, cnt2)
    if not q1 and not q2: # 1번 바이러스의 큐와 2번 바이러스의 큐가 둘 다 비었다면 바이러스는 더 이상 퍼질 수 없으므로 break함
        break
print(cnt1, cnt2, cnt3)
