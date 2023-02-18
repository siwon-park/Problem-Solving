# 샘터(18513번)
###########################################################################################
    # 문제: https://www.acmicpc.net/problem/18513
    # BFS
    # 큐에 (현재 위치, 샘터의 위치) 형태로 담아서 BFS를 돌려서 처리하였다.
    # 처음에 샘터의 범위 == 집을 지을 수 있는 범위라고 해석해서 max_x, min_x 값을 주고, nx의 범위 체크도 했었는데,
    # 집을 지을 수 있는 범위에 대한 조건은 없어서 해당 조건을 삭제하였다.
    # 너비 우선 탐색 특성 상 가장 먼저 방문한 노드는 최단 거리이므로, 역시 마찬가지로 기준 샘터 위치에서 도착한 곳이
    # 아직 방문하지 않은 곳이라면, 샘터까지의 거리가 최단으로 되는 곳이다. 따라서 거기에 집을 짓는다.
    # 집을 지을 수 있는 곳의 범위가 -1억 ~ 1억을 넘을 수도 있으므로, 배열로 visited 방문체크를 하지 않고 O(1)의 시간으로 해결하기 위해
    # 집합형으로 선언하고 체크하였다.
    # 그리고 집을 지을 때마다 cnt += 1을 하여, cnt == K가 되는 순간 break를 하고, flag 변수를 사용해서 큐까지 종료하도록 설계하였다.
###########################################################################################
import sys
from collections import deque
input = sys.stdin.readline

N, K = map(int, input().split())
lst = list(map(int, input().split()))
visited = set()
q = deque()
for i in range(N):
    q.append((lst[i], lst[i]))
    visited.add(lst[i])

# max_x = int(1e8) # 샘터 위치의 max값
# min_x = -int(1e8) # 샘터 위치의 min값
cnt = 0 # 집의 개수
dist = 0 # 거리
flag = False

while q:
    x, std_x = q.popleft()
    if flag:
        break
    for dx in [-1, 1]:
        nx = x + dx
        # if min_x <= nx <= max_x: # 처음에 집을 지을 수 있는 범위 == 샘터의 범위라고 해석해서 해당 조건을 추가하였으나 삭제함
        if nx not in visited:
            q.append((nx, std_x))
            visited.add(nx)
            cnt += 1
            dist += abs(nx - std_x)
            if cnt == K:
                flag = True
                break

print(dist)
