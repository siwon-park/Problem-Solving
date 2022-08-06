# 닭싸움 팀 정하기(1765번)
############################################################################
    # 문제: https://www.acmicpc.net/problem/1765
    # 분리집합
    # find, union으로 해결하였다.
    # graph를 나누어서 구성하였다.
    # 마지막으로 1 ~ n까지 find_parent를 해준 이유는 혹시라도 부모 테이블이 갱신이 안된 번호가 있을까봐 했다.
    # 내 친구의 친구는 내 친구이다 => 친구의 친구까지 탐색할 필요없이, 친구만 묶으면 나중에 그 친구번호를 탐색했을 때, find/union을 하니까 괜찮다.
    # 내 원수의 원수는 내 친구이다 => 이 경우에는 말 그대로 정직하게 2중 for 구문으로 접근하였다.
############################################################################
import sys
input = sys.stdin.readline

def find_parent(parent, x):
    if parent[x] != x:
        parent[x] = find_parent(parent, parent[x])
    return parent[x]

def union_parent(parent, a, b):
    a, b = find_parent(parent, a), find_parent(parent, b)
    if a < b:
        parent[b] = a
    else:
        parent[a] = b

n = int(input())
m = int(input())
parent = [i for i in range(n+1)]
graph = [[[], []] for _ in range(n+1)]
for _ in range(m):
    rel, p, q = input().split()
    p, q = int(p), int(q)
    # rel이 F이면 0번 인덱스에 넣음
    if rel == "F":
        graph[p][0].append(q)
        graph[q][0].append(p)
    # rel이 E이면 1번 인덱스에 넣음
    else:
        graph[p][1].append(q)
        graph[q][1].append(p)

for i in range(1, n+1):
    # 내 친구의 친구는 친구이다
    for j in graph[i][0]:
        if find_parent(parent, i) != find_parent(parent, j):
            union_parent(parent, i, j)
    # 내 원수의 원수는 친구이다
    for j in graph[i][1]:
        for k in graph[j][1]:
            if find_parent(parent, i) != find_parent(parent, k):
                union_parent(parent, i, k)


for i in range(1, n+1):
    find_parent(parent, i)

print(len(set(parent[1:])))
