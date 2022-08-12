# 귀찮은 해강이(24391번)
#############################################################################################
    # 문제: https://www.acmicpc.net/problem/24391
    # 분리집합
    # 어이없는 실수 때문에 2번이나 틀렸다. lst를 활용해야하는데, 그냥 parent만 사용하고 있었고, 이를 뒤늦게 발견하였다...
    # 일반적인 분리집합 문제로, 입력으로 오는 i와 j에 대해서 집합을 구해준 다음에 lst에 대해서 인덱스 i와 i+1에 대해서
    # 서로 다른 집합군일 경우에 cnt += 1을 해주면 된다.
#############################################################################################
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

N, M = map(int, input().split())
parent = [i for i in range(N + 1)]
for _ in range(M):
    i, j = map(int, input().split())
    if find(i) != find(j):
        union(i, j)

lst = list(map(int, input().split()))
cnt = 0
for i in range(N - 1):
    if find(parent[lst[i]]) != find(parent[lst[i + 1]]):
        cnt += 1

print(cnt)
