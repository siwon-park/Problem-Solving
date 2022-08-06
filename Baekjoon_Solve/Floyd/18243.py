# Small World Network(18243번)
#########################################################################
    # 문제: https://www.acmicpc.net/problem/18243
    # 플로이드-워셜
    # 플로이드 워셜 알고리즘을 통해서 a에서 b까지 가는 최단 거리를 구한 뒤에
    # graph[a][b]가 6을 초과하면 Big World!를 그렇지 않으면 Small World!를 출력하면 된다.
#########################################################################
import sys
from collections import deque
input = sys.stdin.readline

N, K = map(int, input().split())
INF = int(1e9)
graph = [[INF]*(N+1) for _ in range(N+1)]
for i in range(1, N+1):
    graph[i][i] = 0

for _ in range(K):
    A, B = map(int, input().split())
    graph[A][B] = 1
    graph[B][A] = 1

def Floyd():
    for k in range(1, N+1):
        for a in range(1, N+1):
            for b in range(1, N+1):
                dist = graph[a][k] + graph[k][b]
                if dist < graph[a][b]:
                    graph[a][b] = dist

Floyd()

def check():
    for a in range(1, N+1):
        for b in range(1, N+1):
            if graph[a][b] > 6:
                return "Big World!"
    return "Small World!"

print(check())
