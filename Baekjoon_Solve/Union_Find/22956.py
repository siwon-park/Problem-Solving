# 소나기 (22956번)
################################################################################################
    # 문제: https://www.acmicpc.net/problem/22956
    # 정말 어려워서 많이 헤맸다. 12%에서 자꾸 틀렸습니다를 받았다.
    # 2차원의 부모 배열과, 비가 내린 배열 등을 활용해서 논리적으로 알고리즘을 짰다고 했으나 12%에서 자꾸 틀렸습니다였다.
    # 질문 게시판에서 다른 사람이 올린 코드를 보고 비슷하게 짜서 겨우 통과했다.
    # 덕분에 2차원의 배열로 선언했던 부분을 1차원으로 변환하는 스킬?을 배우게 되었다.
    # 비는 내렸던 위치에 그대로 내릴 수 있으므로, 내린 위치의 부모를 합치면 안 됨을 유의해야한다.
    # 좀 더 침착하게 잘 생각해서 짰다면 많은 시간을 허비하지 않고 풀 수 있었을 것 같다.
################################################################################################
import sys
sys.setrecursionlimit(int(1e5))
input = sys.stdin.readline

dydx = [(-1, 0), (0, 1), (1, 0), (0, -1)]


def find(x):
    if parent[x] != x:
        parent[x] = find(parent[x])
    return parent[x]


def union(a, b):
    a, b = find(a), find(b)
    if a == b:
        return False
    if H[a] > H[b]:
        a, b = b, a
    elif H[a] == H[b] and old[a] > old[b]:
        a, b = b, a
    parent[b] = a
    return True


N, M, Q = map(int, input().split())
H = []
for _ in range(N):
    H.extend(list(map(int, input().split())))

queries = []
for _ in range(Q):
    a, b, c = map(int, input().split())
    queries.append((a, b, c))

old = [100001 for _ in range(N * M + M + 1)]  # 오래된 정도
parent = [i for i in range(N * M + M + 1)]  # 부모 테이블

d = 1

for query in queries:
    y, x, c = query
    y -= 1
    x -= 1
    n = y * M + x
    H[n] -= c
    old[n] = d
    for dy, dx in dydx:
        ny, nx = y + dy, x + dx
        pn = ny * M + nx
        if 0 <= ny < N and 0 <= nx < M and old[pn] != 100001:
            if not union(pn, n) and H[n] < H[pn]:
                parent[n] = n
                union(pn, n)
            elif not union(pn, n) and H[n] == H[pn]:
                if old[n] < old[pn]:
                    parent[n] = n
                    union(pn, n)
    P = find(n)
    print(P // M + 1, P % M + 1)
    d += 1
