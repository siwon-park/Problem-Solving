# 감시(15683번)
############################################################
    # 문제: https://www.acmicpc.net/problem/15683
    # 브루트포스, 구현, 시뮬레이션
    # 완전 탐색 문제를 풀면서 느낀 것 두 가지: 1) 나는 완전 탐색에 약하다. 2) 완전 탐색을 효율적으로 구현하려면 모든 경우의 수를 구한 다음 뭔가 구현하는 것이 아니라
    # DFS나 백트랙킹에서 하듯이 넣었다 뺐다 하면서 모든 경우의 수를 고려하는 방식이 더 빠르고 효율적이다.(물론 가지치기가 된다면 금상첨화)
    # Pypy3 통과, Python3 시간초과
    # 이 풀이의 코드 로직은 간단하다. 어차피 5번 감시 카메라는 상하좌우 모든 방향을 감시하므로 5번 카메라가 있을 때는, 5번 카메라의 감시방향까지 전부 다 마킹한 채로 시작한다.
    # 그 후 나머지 카메라에 대해 모든 경우의 수를 구하고(단, 2번 카메라는 경우의 수가 2개이다.)
    # 경우의 수만큼 board를 대상으로 카메라의 감시 영역을 마킹하여 최소 사각지대를 구하였다.
    # 2차원 배열 복사를 위해 deepcopy를, 순열에서 경우의 수를 받아왔을 때, 뽑아야하는게 FIFO이기 때문에 deque를 사용하였다.
############################################################
import sys
from copy import deepcopy
from collections import deque
input = sys.stdin.readline

N, M = map(int, input().split())
board = []
oq = deque()
tmp_q = []
arr = []
ret = []
def permute(s, lst):
    if s == len(arr):
        ret.append(lst[:])
        return
    for num in arr[s]:
        permute(s+1, lst+[num])

def spread(y, x, dydx):
    cnt = 0
    for dy, dx in dydx:
        ny, nx = y+dy, x+dx
        while (0 <= ny < N and 0 <= nx < M):
            if board[ny][nx] == 6:
                break
            elif board[ny][nx] == 0:
                board[ny][nx] = "#"
                cnt += 1
            ny += dy
            nx += dx
    return cnt

empty = 0
dydx = [(-1, 0), (0, 1), (1, 0), (0, -1)]
for i in range(N):
    board.append(list(map(int, input().split())))
    for j in range(M):
        if board[i][j]:
            if board[i][j] == 5:
                tmp_q.append((i, j))
            elif board[i][j] != 6:
                oq.append((i, j))
                if board[i][j] == 2:
                    arr.append([(1, 2), (2, 2)])
                else:
                    arr.append([(1, board[i][j]), (2, board[i][j]), (3, board[i][j]), (4, board[i][j])])
        else:
            empty += 1

# 5번 카메라에 대해 감시 영역 체크
while tmp_q:
    y, x = tmp_q.pop()
    empty -= spread(y, x, dydx)

dydx1 = [[(-1, 0)], [(0, 1)], [(1, 0)], [(0, -1)]] # 1번 카메라
dydx2 = [[(-1, 0), (1, 0)], [(0, -1), (0, 1)]]  # 2번 카메라
dydx3 = [[(-1, 0), (0, 1)], [(0, 1), (1, 0)], [(1, 0), (0, -1)], [(0, -1), (-1, 0)]]  # 3번 카메라
dydx4 = [[(0, -1), (-1, 0), (0, 1)], [(-1, 0), (0, 1), (1, 0)], [(0, 1), (1, 0), (0, -1)], [(1, 0), (0, -1), (-1, 0)]]  # 4번 카메라

# 남은 카메라에 대해 모든 경우의 수를 고려해 감시 영역을 체크
permute(0, [])
o_board = deepcopy(board)
dydxs = [[], dydx1, dydx2, dydx3, dydx4]
min_empty = int(1e9)
for perm in ret:
    tmp_empty = empty
    board = deepcopy(o_board)
    q = deepcopy(oq)
    for k, c in perm:
        dydx = dydxs[c][k-1]
        y, x = q.popleft()
        tmp_empty -= spread(y, x, dydx)
    min_empty = min(min_empty, tmp_empty)
print(min_empty)
