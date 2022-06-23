# 점프 게임(15558번)
###########################################################################################
    # 문제: https://www.acmicpc.net/problem/15558
    # BFS, 구현
    # 간단한 문제였지만 일부 조건 때문에 디버깅에 많은 시간을 썼다.
    # 코드의 간결화를 위해 비트 XOR 연산을 사용하였다.
    # 문제를 거의 다 풀고나서 중복으로 인한 시간초과를 배제하기 위해 visited방문 체크를 하기로 했다.
    # 처음에 생각없이 1차원의 visited배열로 구성하려다가, 바로 생각해보니 점프대가 2개이므로 2차원의 visited배열을 사용해야 했다.
    # 문제에서는 사람이 점프해서 이동한 뒤에 1칸씩 사라지지만, 구현을 하다보니 먼저 1칸을 삭제한 후에 이동하는 방법으로 구현을 하였다.
    # 논리적으로는 이게 문제가 없는게, 현재 칸이 사라졌든 아니든 일단 큐에서 요소를 뽑아서 이동시키고,
    # 다시 큐에서 돌아올 때 이동한 그 칸에서 이동을 할 수 있냐, 없냐를 따지므로
    # 오히려 먼저 칸을 삭제를 하고 이동하는게 문제에서 말한 요구조건에 맞게 구현한 것이다.
    # 즉, 다음 번에 이동할 칸이 이동할 수 없는 칸이면 이동하지 못하게 하는 것과 같은 원리이다.
###########################################################################################
import sys
from collections import deque
input = sys.stdin.readline

N, K = map(int, input().split())
jump = []
jump.append(list(map(int, input().rstrip())))
jump.append(list(map(int, input().rstrip())))

def bfs():
    t = 0 # 시간 초
    disappear = [True] * N # 각 초마다 한칸씩 사라짐
    visited = [[False] * 2 for _ in range(N)]
    q = deque([(0, 0)]) # 왼쪽칸/오른쪽칸, 현재 위치
    while q:
        n = len(q)
        if t < N:
            disappear[t] = False
            t += 1
        for _ in range(n):
            d, cur = q.popleft()
            # 현재 칸이 0이거나, 이미 방문한 칸이면 이동 불가능함
            if cur >= N:
                return 1
            if (0 <= cur < N and not jump[d][cur]) or cur < 0 or visited[cur][d]:
                continue
            visited[cur][d] = True
            # 현재 칸에서 한칸 앞으로 이동
            q.append((d,  cur + 1))
            # 현재 칸에서 한칸 뒤칸 이동
            if disappear[cur - 1]:
                q.append((d, cur - 1))
            # 옆 칸으로 cur + k 칸 이동
            q.append((d^1, cur + K))

    return 0

print(bfs())
