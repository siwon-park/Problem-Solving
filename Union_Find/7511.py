# 소셜 네트워킹 어플리케이션(7511번)
####################################################################################
    # 문제: https://www.acmicpc.net/problem/7511
    # 분리 집합(union-find)
    # 등장하는 친구 관계에 해당하는 노드 간 union을 실시한 다음
    # 확인해야할 친구 관계에 해당하는 노드 간 find를 해주면 된다.
####################################################################################
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

T = int(input()) # 테케
for tc in range(1, T+1):
    n = int(input()) # 유저 수
    k = int(input()) # 친구 관계 수
    parent = [i for i in range(n)]
    for _ in range(k):
        a, b = map(int, input().split())
        union_parent(a, b)
    print(f"Scenario {tc}:")
    m = int(input())
    for _ in range(m):
        u, v = map(int, input().split())
        if find_parent(u) == find_parent(v):
            print(1)
        else:
            print(0)
    print()
