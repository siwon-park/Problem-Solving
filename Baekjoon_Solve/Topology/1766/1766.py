import sys, heapq
input = sys.stdin.readline
N, M = map(int, input().split())
graph = [[] for i in range(N+1)]
indegree = [0] * (N+1)
for i in range(M):
    A, B = map(int, input().split())
    graph[A].append(B)
    indegree[B] += 1

def topology_sort():
    result = []
    q = []
    for i in range(1, N+1):
        if indegree[i] == 0:
            heapq.heappush(q, i)     
    while q:
        cur = heapq.heappop(q)
        result.append(cur)
        for nxt in graph[cur]:
            indegree[nxt] -= 1
            if indegree[nxt] == 0:
                heapq.heappush(q, nxt)         
    return result

print(*topology_sort())