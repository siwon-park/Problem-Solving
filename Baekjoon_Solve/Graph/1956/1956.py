import sys
input = sys.stdin.readline

V, E = map(int, input().split())
INF = int(1e9)
graph = [[INF] * (V + 1) for i in range(V + 1)]
for i in range(E):
    a, b, c = map(int, input().split())
    graph[a][b] = c
for k in range(1, V + 1):
    for a in range(1, V + 1):
        for b in range(1, V + 1):
            cost = graph[a][k] + graph[k][b]
            if cost < graph[a][b]:
                graph[a][b] = cost
answer = INF
for i in range(1, V + 1):
    answer = min(answer, graph[i][i])
if answer == INF:
    answer = -1    
print(answer)