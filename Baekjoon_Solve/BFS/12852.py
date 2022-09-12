# 1로 만들기2(12852번
###############################################################################
    # 문제: https://www.acmicpc.net/problem/12852
    # BFS
    # 경로 역추적을 적용시키는게 포인트이다.
    # DP보다 빠른 풀이이다.
    # parent[nxt] = cur을 적용시키는 이유는 나중에 1부터 출발해서 N까지 경로를 역추적하기 위함이다.
###############################################################################
import sys
from collections import deque
input = sys.stdin.readline

N = int(input())
INF = int(1e9)
parent = [0 for i in range(N + 1)]

def bfs():
    q = deque([(0, N)])
    while q:
        cnt, cur = q.popleft()
        if cur == 1:
            return cnt
        if cur % 3 == 0 and not parent[cur // 3]:
            q.append((cnt + 1, cur // 3))
            parent[cur // 3] = cur
        if cur % 2 == 0 and not parent[cur // 2]:
            q.append((cnt + 1, cur // 2))
            parent[cur // 2] = cur
        if cur - 1 >= 1 and not parent[cur - 1]:
            q.append((cnt + 1, cur - 1))
            parent[cur - 1] = cur
    return -1

def find_path(start):
    while start != N:
        route.append(parent[start])
        start = parent[start]

cnt = bfs()
print(cnt)

route = [1]
find_path(1)
print(*route[::-1])
