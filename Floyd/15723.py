# n단 논법(15723번)
#########################################################################
    # 문제: https://www.acmicpc.net/problem/15723
    # 플로이드 워셜
    # 입력 방식이 조금 특이해서 그렇지, 크게 함정과 같은 막히는 부분이 없는 평범한 플로이드 워셜 문제이다.
    # 최단 거리를 구하는 것이 아니라 a에서 b까지 갈 수 있는지 체크하는 것이므로, 경유지를 통해서 갈 수 있을 때만 체크하는 방식으로 구현하였다.
    # 왜 골드 5인지 모르겠다. 아마 푼 사람이 적어서 그런 듯하다.
#########################################################################
import sys
input = sys.stdin.readline

n = int(input())
graph = [[0]*26 for _ in range(26)]

for _ in range(n):
    a, b = map(lambda x: ord(x)-97, input().rstrip().split(" is "))
    graph[a][b] = 1

for i in range(26):
    graph[i][i] = 1

for k in range(26):
    for a in range(26):
        for b in range(26):
            if graph[a][k] and graph[k][b]:
                graph[a][b] = 1

m = int(input())
for _ in range(m):
    a, b = map(lambda x: ord(x)-97, input().rstrip().split(" is "))
    if graph[a][b]:
        print("T")
    else:
        print("F")
