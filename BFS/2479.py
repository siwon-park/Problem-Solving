# 경로 찾기(2479번)
################################################################################################
    # 문제: https://www.acmicpc.net/problem/2479
    # BFS
    # BFS 탐색 최단 경로를 출력하는 문제이다
    # 비트가 다른 개수 == 해밍 거리, 해밍 경로는 해밍 거리가 1인 경로로 이루어진 경로를 말한다.
    # 먼저 이진코드 입력에 대해 해밍 거리가 1인 노드 번호를 그래프 연결정보로 저장한다
    # 그리고 BFS탐색을 통해서 A -> B까지 갈 수 있는지 탐색하면서 경로를 기록한다
    # 만약 갈 수 없다면 path배열에 있는 수는 B 하나이므로, path[-1] == path[0] 또는 path[0] != A이면 갈 수 없으므로 -1을 반환하고
    # 갈 수 있으면 path 배열을 출력하면 된다.
################################################################################################
import sys
from collections import deque
input = sys.stdin.readline

# 비트가 다른 개수 == 해밍거리
# 해밍 경로 == 해밍거리가 1인 경로
N, K = map(int, input().split())

lst = [input().rstrip() for _ in range(N)]
visited = [False] * (N + 1)

A, B = map(int, input().split())

graph = [[] for _ in range(N + 1)]
for i in range(N - 1):
    a = lst[i]
    for j in range(i + 1, N):
        b = lst[j]
        cnt = 0
        for k in range(K):
            if a[k] != b[k]:
                cnt += 1
                if cnt > 1:
                    break
        else:
            graph[i + 1].append(j + 1)
            graph[j + 1].append(i + 1)

def bfs():
    q = deque([A])
    visited[A] = True
    path = [B] # 최단 경로
    p = [0] * (N + 1) # 경로의 부모를 기록하기 위한 배열
    while q:
        cur = q.popleft()
        if cur == B:
            break
        for nxt in graph[cur]:
            if not visited[nxt]:
                visited[nxt] = True
                q.append(nxt)
                p[nxt] = cur

    end = B
    while p[end]:
        path.append(p[end])
        end = p[end]
    if path[-1] == path[0]:
        return [-1]
    return path[::-1]

print(*bfs())
