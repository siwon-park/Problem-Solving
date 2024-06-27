# 기상캐스터 (10709번)
import sys
input = sys.stdin.readline

H, W = map(int, input().rstrip().split())
graph = [[-1 for _ in range(W)] for _ in range(H)]

for i in range(H):
    line = input().rstrip()
    for j in range(W):
        if line[j] == 'c':
            graph[i][j] = 0
        else:
            if j > 0 and graph[i][j - 1] != -1:
                graph[i][j] = graph[i][j - 1] + 1

for i in range(H):
    print(*graph[i])

