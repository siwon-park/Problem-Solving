# 끝나지 않는 파티(11265번)
############################################################################################
    # 문제: https://www.acmicpc.net/problem/11265
    # 플로이드-워셜
    # 오랜만에 풀어보는 플로이드 워셜 문제였다
    # N <= 500이므로 시간 안에 충분히 풀 수 있다
    # 주어진 graph를 플로이드 워셜 알고리즘을 통해 최단 거리 graph배열을 만들어서
    # M개의 쿼리에 대해 답을 출력하면 된다.
    # A->B로 가는 경로에 대해 탐색해야하니까 graph[A - 1][B - 1]이다. graph[B - 1][A - 1]은 B -> A이다.
############################################################################################
import sys
input = sys.stdin.readline

N, M = map(int, input().split())
graph = [list(map(int, input().split())) for _ in range(N)]
for k in range(N):
    for a in range(N):
        for b in range(N):
            if graph[a][k] + graph[k][b] < graph[a][b]:
                graph[a][b] = graph[a][k] + graph[k][b]

for _ in range(M):
    A, B, C = map(int, input().split())
    if graph[A - 1][B - 1] <= C:
        print("Enjoy other party")
    else:
        print("Stay here")
