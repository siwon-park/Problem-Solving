# 은하 철도(17250번)
###############################################################################
    # 문제: https://www.acmicpc.net/problem/17250
    # union-find, 분리집합
    # 철도가 연결될 때마다 해당 철도를 이용할 수 있는 행성들의 수를 출력하라는 것을 보고 분리집합, union-find 문제임을 알았다
    # 크게 고려해야할 다른 변수는 없는 일반적인 난이도의 문제이다.
###############################################################################
import sys
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

N, M = map(int, input().split())

rail_dict = dict()
for i in range(N):
    rail_dict[i + 1] = int(input().rstrip())

parent = [i for i in range(N + 1)]

for _ in range(M):
    a, b = map(int, input().split())
    pa, pb = find_parent(a), find_parent(b)
    if pa != pb:
        if pa < pb:
            rail_dict[pa] += rail_dict[pb]
            rail_dict[pb] = 0
        else:
            rail_dict[pb] += rail_dict[pa]
            rail_dict[pa] = 0
        union_parent(a, b)
    print(rail_dict[find_parent(a)])
