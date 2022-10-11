# 통신망 분할(17398번)
##########################################################################################
    # 문제: https://www.acmicpc.net/problem/17398
    # 분리집합
    # 문제를 푸는 아이디어가 대단한 문제였다. 사실 어떻게 풀지 몰라서 몇 가지 시도를 하다가 감이 안 와서 힌트를 봤다.
    # 핵심은 자르는 선들을 제외하고 나머지 간선들로 통신망을 연결하고
    # 자르는 선들을 역순으로 연결하면서 서로 연결되는 집합 군들의 개수를 곱한 값을 cost에 누적해준다.
    # union 연산을 하기 전에 그룹에 속한 집합의 개수를 갱신해줘야하는 것도 포인트이다.
    # 문제를 풀기 위한 아이디어를 생각하기 쉽지 않은 문제였다.
##########################################################################################
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

N, M, Q = map(int, input().split())
parent = [i for i in range(N + 1)]

P = [1] * (N + 1) # 속한 집합의 개수
queries = dict()
for i in range(M):
    X, Y = map(int, input().split())
    queries[i + 1] = (X, Y)

is_cut = [False] * (M + 1)
cut = []
for _ in range(Q):
    A = int(input().rstrip())
    cut.append(A)
    is_cut[A] = True

for i in list(queries.keys()):
    X, Y = queries[i]
    if is_cut[i]:
        continue
    if find(X) != find(Y):
        x = min(find(X), find(Y))
        y = max(find(X), find(Y))
        P[parent[x]] += P[parent[y]]
        P[parent[y]] = 0
        union(X, Y)

cost = 0

while cut: # 자르는 선을 역순으로 연결함
    c = cut.pop()
    X, Y = queries[c]
    if find(X) != find(Y):
        x = min(find(X), find(Y))
        y = max(find(X), find(Y))
        cost += P[x] * P[y]
        P[x] += P[y]
        P[y] = 0
        union(X, Y)

print(cost)
