# 친구비(16562번)
#######################################################################
    # 문제: https://www.acmicpc.net/problem/16562
    # 그래프 이론
    # 어려운 난이도의 문제는 아니었는데, 뭔가 함정이 있을 것이라고 생각하고 효율성을 고려해서 풀다보니
    # 푸는데 오래 걸렸다. 아마 내가 최악의 경우를 계산하는 방법이 아직 익숙치 않거나 계산하는 방법이 잘못되었을 가능성이 크다.
    # 내가 생각한 최악의 경우는 주어지는 비용이 모두 내림차순이고, 모든 노드가 일자로 연결된 상태면 매번 BFS로 모든 노드를 탐색해야하는데
    # 이 코드로 내가 생각한 최악의 경우를 고려한다면 O(NM)이 걸리기 때문에 N, M <= 1만이기 때문에 시간초과가 날 것이라 생각했다. 
    # 그런데 문제의 테스트 케이스에 그런 경우는 없나보다...
#######################################################################
import sys
from collections import deque
input = sys.stdin.readline

N, M, K = map(int, input().split())
A = list(map(int, input().split()))
graph = [[] for _ in range(N + 1)]

for _ in range(M):
    v, w = map(int, input().split())
    graph[v].append(w)
    graph[w].append(v)

def bfs():
    INF = sys.maxsize
    visited = [INF] * (N + 1)
    visited[0] = 0
    min_cost = 0
    for i in range(1, N + 1):
        if A[i-1] < visited[i]:
            if visited[i] == INF:
                min_cost += A[i-1]
            else:
                min_cost += (A[i-1] - visited[i])
            visited[i] = A[i-1]
            q = deque([i])
            while q:
                cur = q.popleft()
                for nxt in graph[cur]:
                    if A[i-1] < visited[nxt]:
                        visited[nxt] = A[i-1]
                        q.append(nxt)

    if min_cost <= K:
        return min_cost
    return "Oh no"

print(bfs())
