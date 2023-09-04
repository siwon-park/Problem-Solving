import sys
from collections import deque
input = sys.stdin.readline
K = int(input())
for i in range(K):
    V, E = map(int, input().split())
    visited = [0] * (V + 1)
    graph = [[] for _ in range(V +1)]
    for j in range(E):
        a, b = map(int, input().split())
        graph[a].append(b)
        graph[b].append(a)
    flag = True
    for j in range(1, V + 1):
        if visited[j] == 0:
            q = deque([j])
            visited[j] = 1
            while q:
                cur = q.popleft()
                for next in graph[cur]:
                    if visited[next] == 0:
                        q.append(next)
                        visited[next] = visited[cur] + 1
                    elif visited[next] == visited[cur]:
                        flag = False
    if flag:
        print("YES")
    else:
        print("NO")