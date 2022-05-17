# 고인물이 싫어요(25187번)
############################################################################################
    # 문제: https://www.acmicpc.net/problem/25187
    # BFS, 분리집합(find, union)
    # 각 집합의 최상단 부모 노드 번호를 키값으로 하고 [고인물 수, 청정물 수] 리스트를 값으로 가지는 딕셔너리를 활용하였다.
    # 방문하지 않은 노드일 경우에 BFS탐색을 하면서 find와 union을 사용하였다. 그리고 딕셔너리의 고인물, 청정물 수를 갱신해주었다.
    # 이 때, 큐에 제일 처음 삽입한 노드 키값을 기준으로 딕셔너리를 갱신해주었다. 그 이유는 그렇게 안해서 틀린 것도 있었지만,
    # 방문을 순차적으로 시행하였으니, 방문하지 않아서 제일 처음 큐에 삽입한 노드가 제일 빠른 번호고 그 번호를 부모로 해도 괜찮기 때문이다.
############################################################################################
import sys
from collections import deque
input = sys.stdin.readline

def find_parent(x):
    if parent[x] != x:
        parent[x] = find_parent(parent[x])
    return parent[x]

def union_parent(a, b):
    a, b = find_parent(a), find_parent(b)
    if a < b:
        parent[b] = a
    else:
        parent[a] = b

N, M, Q = map(int, input().split())
W = [0] + list(map(int, input().split())) # 0번 인덱스 추가
parent = [i for i in range(N + 1)] # 집합군을 표현할 부모 테이블
w_dict = dict()
for i in range(1, N+1):
    w_dict[i] = [0, 0] # 고인물, 청정수

graph = [[] for _ in range(N + 1)]
for _ in range(M):
    u, v = map(int, input().split())
    graph[u].append(v)
    graph[v].append(u)

query = []
for _ in range(Q):
    query.append(int(input().rstrip()))

visited = [False] * (N + 1)
for i in range(1, N + 1):
    if not visited[i]:
        q = deque([i])
        visited[i] = True
        w_dict[i][W[i]] += 1 # 어차피 1부터 출발하니까 i가 부모가 될 수 밖에 없다
        while q:
            cur = q.popleft()
            for nxt in graph[cur]:
                if find_parent(cur) != find_parent(nxt):
                    union_parent(cur, nxt)
                    visited[nxt] = True
                    q.append(nxt)
                    w_dict[i][W[nxt]] += 1

for q in query:
    p = find_parent(q)
    if w_dict[p][0] < w_dict[p][1]:
        print(1)
    else:
        print(0)
# print(w_dict)
