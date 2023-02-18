# BFS 스페셜 저지(16940번)
##############################################################################################
    # 문제: https://www.acmicpc.net/problem/16940
    # BFS
    # 주어진 순서대로 BFS방문이 가능한지 체크하는 문제이다.
    # 큐에서 요소를 pop했을 때, 해당 요소의 다음 방문 가능 노드드 수만큼 반복해서
    # 주어진 순서의 다음 방문 노드가 있을 경우에 방문하는 것을 반복한다.
    # 이 과정을 다 끝낸 뒤에 i가 N보다 작으면 주어진 순서대로 방문할 수 없다는 의미이고,
    # 방문할 수 있다면 i == N이다.
    # 71%에서 틀렸습니다 판정을 받았는데, 문제에서 출발 노드가 항상 1이라고 했으므로 주어진 방문 순서의 시작이 1이 아니면
    # 0을 return하게끔 하면 된다.
##############################################################################################
import sys
from collections import deque
input = sys.stdin.readline

N = int(input())
graph = [set() for _ in range(N + 1)]
for _ in range(N - 1):
    a, b = map(int, input().split())
    graph[a].add(b)
    graph[b].add(a)

bfs_lst = list(map(int, input().split()))


def bfs():
    i = 0
    if bfs_lst[i] != 1: # 주어진 탐색 경로의 시작이 1이 아니면 0을 return
        return 0
    q = deque([bfs_lst[i]])
    visited = [False] * (N + 1)
    visited[bfs_lst[i]] = True
    i += 1
    while q:
        cur = q.popleft()
        for _ in range(len(graph[cur])):
            if i < N and not visited[bfs_lst[i]] and bfs_lst[i] in graph[cur]:
                visited[bfs_lst[i]] = True
                q.append((bfs_lst[i]))
                i += 1
    if i == N:
        return 1
    return 0

print(bfs())
