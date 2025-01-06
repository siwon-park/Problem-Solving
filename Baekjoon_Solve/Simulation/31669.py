# 특별한 학교 탈출 (31669번)
import sys
input = sys.stdin.readline

N, M = map(int, input().rstrip().split())
graph = []
for i in range(N):
    graph.append(input().rstrip())

ans = -1
for i in range(M):
    flag = False
    for j in range(N):
        if graph[j][i] == 'O':
            flag = True
    if not flag:
        ans = i + 1
        break

if ans == -1:
    print("ESCAPE FAILED")
else:
    print(ans)

