# 지름길(1446번)
#########################################################################
    # 문제: https://www.acmicpc.net/problem/1446
    # 다이나믹 프로그래밍, 다익스트라
    # 간만에 메모이제이션으로 DP문제를 해결하였다
    # 도로의 길이가 최대 1만이므로 1만 + 1개 요소를 가진 2차원 리스트를 선언하고 해당 인덱스에 지름길 정보를 역으로 저장하였다.(메모이제이션을 하기 위해 역으로 저장함)
    # 그리고 D+1 크기의 메모배열을 선언하고 요소의 값들을 sys.maxsize값으로 초기화시키고 메모이제이션을 하였다.
    # 나머지는 밑에 코드 옆 주석을 참조
#########################################################################
import sys
sys.setrecursionlimit(int(1e5))
input = sys.stdin.readline

N, D = map(int, input().split())
short_cut = [[] for _ in range(10001)]
for _ in range(N):
    a, b, d = map(int, input().split()) # 출발위치, 도착위치, 거리
    short_cut[b].append((a, d)) # 도착위치에서 출발 위치로 감

INF = sys.maxsize
memo = [INF] * (D+1)
memo[0] = 0

def dfs(k):
    if k == 0:
        return 0
    if memo[k] != INF:
        return memo[k]
    path = 1 # dfs(k-1)을 더해온 값이 전부 0이면 k-1에서 k로 가는 거리는 1이기에 1부터 시작
    path += dfs(k-1) # 리턴값을 누적해옴
    if short_cut[k]:
        for nxt, dist in short_cut[k]:
            path = min(path, dfs(nxt) + dist)
    memo[k] = path
    return memo[k]

print(dfs(D))
