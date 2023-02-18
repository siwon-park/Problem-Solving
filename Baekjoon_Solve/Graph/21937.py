# 작업(21937번)
#############################################################################
    # 문제: https://www.acmicpc.net/problem/21937
    # DFS
    # 처음에 일의 선행관계가 주어져서 위상정렬인가하고 봤더니 DFS문제였다.
    # 그러고나서 문제를 딱 보니까 주어진 관계를 역으로 하여 깊이 우선 탐색을 해야하는 것을 알고 그렇게 푸는데 3% 에서 틀렸습니다 판정을 받았다.
    # 그 이유는 단방향 관계이니 방문을 따로 표시해줄 필요가 없다고 생각했는데, 3번 예시를 그려보니까 2번과 3번 작업을 하기 전에 1번 작업을 해야하므로
    # 1번에 대해서는 1번만 카운트를 해야한다. 따라서 중복 체크를 해줘야했다. visited배열을 만들고 푸니까 통과할 수 있었다.
#############################################################################
import sys
sys.setrecursionlimit(int(1e6))
input = sys.stdin.readline

N, M = map(int, input().split())
graph = [[] for _ in range(N + 1)]
for _ in range(M):
    A, B = map(int, input().split())
    graph[B].append(A)
visited = [False] * (N + 1)

X = int(input())

def dfs(cur):
    global cnt
    if visited[cur]:
        return
    visited[cur] = True
    cnt += 1
    for nxt in graph[cur]:
        dfs(nxt)

cnt = 0
dfs(X)

print(cnt - 1) # 1을 빼줘야하는 이유는 dfs로 탐색할 때, 제일 처음 자기자신을 카운트하기 때문임
