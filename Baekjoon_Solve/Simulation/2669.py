# 직사각형 네개의 합집합의 면적 구하기 (2669번)
import sys
input = sys.stdin.readline

graph = [[0 for _ in range(101)] for _ in range(101)]

for i in range(4):
    x1, y1, x2, y2 = map(int, input().rstrip().split())
    for x in range(x1, x2):
        for y in range(y1, y2):
            graph[y][x] = 1

ans = 0
for i in range(101):
    for j in range(101):
        ans += graph[i][j]

print(ans)

