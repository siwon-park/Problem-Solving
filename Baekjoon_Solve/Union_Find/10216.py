# Count Circle Groups(10216번)
###################################################################################
    # 문제: https://www.acmicpc.net/problem/10216
    # 분리집합(union-find)
    # 몇 가지 함정이 있고, 시간복잡도를 신경써야하는 문제이다
    # 정렬도 필요없었고, 계산도 최대한 간단하게 하고, 매번 루트노드를 체크하지 말고, 마지막에 체크를 해야 시간제한을 통과할 수 있다.
    # 문제를 보자마자 분리집합 문제로 풀어야 한다는 것은 알았는데, 시간초과 때문에 많은 시간을 소비했다.
###################################################################################
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

T = int(input())
for tc in range(T):
    N = int(input())
    parent = [i for i in range(N)]
    lst = []
    for _ in range(N):
        x, y, r = map(int, input().split())
        lst.append((r, x, y))

    for i in range(N):
        r1, x1, y1 = lst[i]
        for j in range(i):
            r2, x2, y2 = lst[j]
            if (x1 - x2)**2 + (y1 - y2)**2 <= (r1 + r2)**2: # 루트 씌울 필요 없이 제곱으로만 계산하고, 루트 노드 확인을 당장 하지 않고 조건만 맞다면 무조건 합친다
                union(i, j)

    for i in range(N):
        find(i)
    print(len(set(parent)))
