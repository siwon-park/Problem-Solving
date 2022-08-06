# 내 선물을 받아줘(15559번)
##########################################################################
    # 문제: https://www.acmicpc.net/problem/15559
    # DFS, 분리집합
    # 분리집합(서로소)을 활용한 풀이
    # 처음에 분리집합으로 접근해서 문제를 풀고나니까 더 빠른 풀이가 있길래 봤더니 DFS로도 접근이 가능했다
    # DFS풀이가 분리집합보다 메모리, 속도 측면에서 많은 이점이 있었다. 풀이는 DFS에 올림
    # 분리집합 풀이는 2차원의 배열이기 때문에 1차원의 부모 배열을 만들고
    # 그 부모 배열에 기록된 숫자에 접근하기 위한 2차원의 배열을 만들었다.
    # 총 만들어지는 집합의 개수는 최종적으로 부모 배열을 집합으로 만들어 해당 len을 구해도 되지만
    # union()할 때마다, cnt를 ++하여 간선의 개수를 구하고, 모든 노드의 수(N*M)에서 cnt를 빼주면 된다.
    # 시간적으로 이 방법이 더 이득일 것 같아서 사용하였다.
##########################################################################
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
board = [list(input().rstrip()) for _ in range(N)]

dydx = [(-1, 0), (0, 1), (1, 0), (0, -1)]
W = {'N': 0, 'E': 1, 'S': 2, 'W': 3}

parent = [i for i in range(N*M)]

nums = [[i for i in range(M*j, M*j + M)] for j in range(N)]
cnt = 0
for y in range(N):
    for x in range(M):
        k = W[board[y][x]]
        ny, nx = y + dydx[k][0], x + dydx[k][1]
        if 0 <= ny < N and 0 <= nx < M:
            a, b = parent[nums[y][x]], parent[nums[ny][nx]]
            if find(a) != find(b):
                union(a, b)
                cnt += 1

print(N*M - cnt)
