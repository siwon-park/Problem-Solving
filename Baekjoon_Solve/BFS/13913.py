# 숨바꼭질 4 (13913번)
#############################################################################
    # 문제: https://www.acmicpc.net/problem/13913
    # BFS
    # 2가지 실수를 했는데, 질문게시판이 아니었으면 눈치를 못채서 찾는데 오랜 시간이 걸렸을 것 같다.
    # 첫번째 가장 큰 실수는 BFS에서 cur +-1, cur * 2의 범위를 구할 때 0 <= x < 100000으로 설정하고 있었다.
    # 10만까지는 가야하므로 100001이어야 하는데 실수를 하고 있었다.
    # 두번째 실수 역시 BFS함수에서 하고 있었는데, 메모리 save를 위해 visited배열을 쓰지 않고 path배열만 사용하려고 했는데
    # path[M] = 0이면 방문하지 말아야 하나, path[M] = False인 것과 같은 로직이기 때문에 방문해서 path배열을 덮어쓰고 있었고
    # path를 활용해 route를 구하는 곳에서 무한 루프 및 잘못된 답을 계산하고 있었다.
    # path배열을 조정해도 됐지만, 그냥 visited배열을 만들어서 해결하였다.
#############################################################################
import sys
from collections import deque
input = sys.stdin.readline

N, K = map(int, input().split())
visited = [False] * 100001
visited[N] = True
path = [False] * 100001
path[N] = -1

def bfs():
    q = deque([N])
    while q:
        cur = q.popleft()
        if cur == K:
            return
        if 0 <= cur - 1 < 100001 and not visited[cur - 1]:
            q.append(cur - 1)
            path[cur - 1] = cur
            visited[cur - 1] = True
        if 0 <= cur + 1 < 100001 and not visited[cur + 1]:
            q.append(cur + 1)
            path[cur + 1] = cur
            visited[cur + 1] = True
        if 0 <= cur * 2 < 100001 and not visited[cur * 2]:
            q.append(cur * 2)
            path[cur * 2] = cur
            visited[cur * 2] = True
    return

def find_path(K):
    route = [K]
    end = K
    while path[end] != -1:
        route.append(path[end])
        end = path[end]

    return route

bfs()
r = find_path(K)
print(len(r) - 1)
print(*r[::-1])
