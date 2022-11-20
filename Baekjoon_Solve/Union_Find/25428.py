# 분필 도둑 (25428번)
################################################################################
    # 문제: https://www.acmicpc.net/problem/25428
    # 분리 집합, 정렬
    # 문제를 거의 다 푼 것 같았는데, 자꾸 1%에서 틀렸습니다를 받았다.
    # 알고보니 문제 접근을 조금 잘못하고 있었다. 정확하게는 정렬 대상이 조금 잘못되었다.
    # u, v의 연결관계가 주어졌을 때 이 둘을 연결하면 u번 노드와 v번 노드의 분필 개수 중 작은 것으로 연결되며
    # 집합은 u의 집합군 개수와 v의 집합군 개수가 된다. 분필의 개수와 이를 곱해주면 최대 훔칠 수 있는 분필의 양이다.
    # 리스트에 (min(u번 노드의 분필 개수, v번 노드의 분필 개수), u, v)를 삽입하고, 분필의 개수를 기준으로 역순 정렬한다.
    # 내가 처음했던 접근법은 리스트에 (i번 교실의 분필 수, i번 교실)을 삽입하고, 분필 수를 기준으로 정렬한 다음,
    # 리스트를 순회하면서 i번 교실과 연결된 노드 중에서 연결했을 때, 분필의 수가 커진다면 연결하는 방법으로 문제를 접근하였다.
    # 정확한 반례는 알 수 없었지만, 추측컨대 이 풀이로 풀게되면 예를 들어 (2, 2, 2, ..., 2)로 묶여서 2*M개가 되는 집합군이 있는데
    # 분필이 많은 교실을 기준으로 이 교실과 인접한 교실부터 우선적으로 집합군으로 연결하게 되니, 잘못된 집합군을 먼저 형성하면서 연결되는 경우가 생기게 되어
    # 훔칠 수 있는 분필을 제대로 계산하지 못하게 되는 듯하다.
    # 리스트에 (min(u번 노드의 분필 개수, v번 노드의 분필 개수), u, v)를 삽입하고, 분필의 개수를 기준으로 역순 정렬하여 union-find를 하는 것이 포인트인 문제이다.
################################################################################
import sys
input = sys.stdin.readline


def find(x):
    if parent[x] != x:
        parent[x] = find(parent[x])
    return parent[x]


def union(a, b):
    a, b = find(a), find(b)
    if a < b:
        parent[b] = a
    else:
        parent[a] = b


INF = sys.maxsize

N = int(input())
parent = [i for i in range(N + 1)]

A = list(map(int, input().split()))

GA = [INF for _ in range(N + 1)]
max_stolen = max(A)

lst = []
for _ in range(N - 1):
    u, v = map(int, input().split())
    lst.append((min(A[u - 1], A[v - 1]), u, v))
    GA[u] = A[u - 1]
    GA[v] = A[v - 1]

lst.sort(key=lambda x: -x[0])

G = [1 for _ in range(N + 1)]  # 그룹의 수

for i in range(N - 1):
    a, u, v = lst[i]
    pu, pv = find(u), find(v)
    if pu != pv:
        pu, pv = min(pu, pv), max(pu, pv)
        tmp = G[pu] + G[pv]
        tmp_a = min(GA[pu], GA[pv])
        max_stolen = max(max_stolen, tmp * tmp_a)
        G[pu], G[pv] = tmp, tmp
        GA[pu], GA[pv] = tmp_a, tmp_a
        union(u, v)

print(max_stolen)
