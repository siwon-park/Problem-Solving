# 친구(1058번)
##################################################################################
    # 문제: https://www.acmicpc.net/problem/1058
    # 플로이드-워셜
    # a != b이면서, graph[a][b] == 'Y'이거나 graph[a][k]와 graph[b][k]가 둘 다 'Y'인 경우 f[a][b] = 1을 체크함
    # sum(f[i])가 i의 2친구 수이다.
##################################################################################
import sys
input = sys.stdin.readline

N = int(input())
graph = [list(input().rstrip()) for _ in range(N)]

f = [[0]*N for _ in range(N)]

for k in range(N):
    for a in range(N):
        for b in range(N):
            if a == b:
                continue
            if graph[a][b] == "Y":
                f[a][b] = 1
            elif graph[a][k] == "Y" and graph[k][b] == "Y":
                f[a][b] = 1

max_f = 0
for i in range(N):
    max_f = max(max_f, sum(f[i]))
print(max_f)
