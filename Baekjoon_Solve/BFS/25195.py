# Yes or yes(25195번)
###################################################################################
    # 문제: https://www.acmicpc.net/problem/25195
    # BFS
    # i번째 노드까지 가는데 펜의 방문횟수를 최소로하여 방문하게 한 다음
    # 현재 위치에서 더 이상 갈 수 없고, 펜 방문 횟수가 0인 지점이 있으면 "yes"를 return 하고 그게 아니라면 "Yes"를 return하게 했다.
    # 처음에 75%에서 틀렸습니다를 받았는데, elif구문과 처음에 fans에 대한 정보를 입력할 때 visited도 1로 마킹해줬더니 통과할 수 있었다.
    # 아마 visited는 상관없고 elif에 not fans[nxt]가 없어서 그랬던 것 같다.
###################################################################################
import sys
from collections import deque
input = sys.stdin.readline

N, M = map(int, input().split())
graph = [[] for _ in range(N + 1)]
for _ in range(M):
    u, v = map(int, input().split())
    graph[u].append(v)

S = int(input())
s = list(map(int, input().split()))
INF = sys.maxsize
visited = [INF] * (N + 1)
fans = [0] * (N + 1)

for i in range(S):
    fans[s[i]] = 1
    visited[s[i]] = 1

def bfs():
    if fans[1]:
        q = deque([(1, 1)])
        visited[1] = 1
    else:
        q = deque([(0, 1)])
        visited[1] = 0
    while q:
        fan, cur = q.popleft()
        for nxt in graph[cur]:
            if fans[nxt] and fan + 1 < visited[nxt]:
                visited[nxt] = fan + 1
                q.append((fan + 1, nxt))
            elif not fans[nxt] and fan < visited[nxt]:
                visited[nxt] = fan
                q.append((fan, nxt))

    for i in range(1, N + 1):
        if not graph[i] and not visited[i]: # 현재 위치에서 더 이상 갈 수 있는 곳이 없고, 현재 위치의 팬 마주침 횟수가 0이면 "yes"이다.
            return "yes"
    return "Yes"

print(bfs())
