# DFS 스페셜 저지(16964번)
import sys
from collections import defaultdict
sys.setrecursionlimit(int(1e5))
input = sys.stdin.readline

N = int(input())
visited = [False] * (N + 1)
graph = defaultdict(set)
for _ in range(N - 1):
    a, b = map(int, input().split())
    graph[a].add(b)
    graph[b].add(a)
ret = list(map(int, input().split()))

ans = []
i = 0
def dfs(cur):
    global i
    visited[cur] = True
    ans.append(cur)
    i += 1
    for nxt in graph[cur]:
        if i < N and ret[i] in graph[cur]:
            if not visited[ret[i]]:
                dfs(ret[i])

dfs(1)

if ret == ans:
    print(1)
else:
    print(0)
