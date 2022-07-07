# MooTube(Gold) (15586번)
#######################################################################################
    # 문제: https://www.acmicpc.net/problem/15586
    # 분리집합, 오프라인 쿼리
    # 그냥 분리집합 문제인줄 알고 덤볐다가, 도저히 모르겠어서 검색을 해보니 오프라인 쿼리에 대한 개념을 알아야 풀 수 있는 문제였다.
    # 오프라인 쿼리란 간단히 말해서 주어진 쿼리를 내가 의도한 대로 재배치(재정렬)하는 것이다.
    # 그럼 이 문제에서 우리는 쿼리를 어떻게 정렬해야하는가?
    # k 이상의 유사도를 가진 동영상을 추천해야하므로 간선 정보를 유사도를 기준으로 내림차순 정렬하고
    # 쿼리도 역시 쿼리에서 묻는 유사도를 기준으로 내림차순 정렬한다.
#######################################################################################
import sys
sys.setrecursionlimit(int(1e5))
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

N, Q = map(int, input().split())
edges = []
parent = [i for i in range(N + 1)]
usa_num = [1] * (N + 1)

for _ in range(N - 1):
    p, q, r = map(int, input().split())
    edges.append((r, p, q))
edges.sort(key=lambda x: -x[0])

queries = []
for i in range(Q):
    k, v = map(int, input().split())
    queries.append((k, i, v))
queries.sort(key=lambda x: -x[0]) # 쿼리를 정렬

ret = [0] * Q
idx = 0
for k, i, v in queries:
    for j in range(idx, N - 1):
        usa, a, b = edges[j]
        if usa < k:
            idx = j # j를 탐색했을 때 break를 했으므로 idx는 j가 됨
            break
        total = usa_num[find(a)] + usa_num[find(b)]
        if find(a) != find(b):
            union(a, b)
            usa_num[find(a)] = total
    ret[i] = usa_num[find(v)] - 1

print(*ret, sep="\n")
