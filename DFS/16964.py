# DFS 스페셜 저지(16964번)
##########################################################################################
    # 문제: https://www.acmicpc.net/problem/16964
    # DFS
    # 잘 설계했다고 생각했는데 6%에서 자꾸 틀렸고, 생각보다 반례가 많았다.
    # 그래서 문제로 주어진 결과 순서대로 탐색할 수 있는지 우선 체크하는 방식으로 설계하였다.
    # 그런데 또 반례가 발견되었고, 그래서 아예 for구문으로 현재 위치에서 갈 수 있는 다음 노드에 대해서
    # 현재 들어가야할 결과 노드가 현재 노드에서 갈 수 있는 다음 위치에 있으면 탐색하게 끔 구성하였다.
    # 73%에서 시간초과가 나서 이를 해결하기 위해 defaultdict(set)을 사용하였다.(기존에는 리스트였기 때문에 in으로 탐색하니 시간이 오래 걸렸다고 생각한다.)
##########################################################################################
import sys
from collections import defaultdict
sys.setrecursionlimit(int(1e5))
input = sys.stdin.readline

N = int(input())
visited = [False] * (N + 1)
graph = defaultdict(set)
for _ in range(N - 1):
    a, b = map(int, input().split())
    graph[a].add(b)
    graph[b].add(a)
ret = list(map(int, input().split()))

ans = []
i = 0
def dfs(cur):
    global i
    visited[cur] = True
    ans.append(cur)
    i += 1
    for nxt in graph[cur]:
        if i < N and ret[i] in graph[cur]:
            if not visited[ret[i]]:
                dfs(ret[i])

dfs(1)

if ret == ans:
    print(1)
else:
    print(0)
