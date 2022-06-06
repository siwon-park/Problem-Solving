# 중량제한(1939번)
#############################################################################
    # 문제: https://www.acmicpc.net/problem/1939
    # 분리집합
    # find와 union을 활용하여 해결하였다.
    # 실수하나 때문에 많은 시간을 낭비했는데, 출발 지점의 부모와 도착 지점의 부모가 같냐를 비교할 때
    # parent[s] == parent[t]로 비교하고 있었다.
    # parent 테이블이 아니고 find 함수를 통해서 호출해야하는데 그 이유는 부모 테이블은
    # S와 T의 부모의 부모가 갱신된 상태, 즉 최신이 아닐 수 있기 때문이다. 왜냐하면 애초에 union함수를 호출하면 제일 위에있는 부모끼리 합쳐지는 것이기 때문이다.
    # 그래서 find함수를 통해서 S와 T를 호출하게 되면 최상단 부모끼리 현재 같은 집합군인지 올바른 비교가 가능하게 된다.
    # 그래도 100% 정도? 에서 틀렸습니다 판정을 받았는데, 논리상 코드를 잘 못 짰다(노드 수 2개, 간선 수 1개면 출력이 안 된다.)
#############################################################################
import sys
sys.setrecursionlimit(int(1e6))
input = sys.stdin.readline

def find_parent(a):
    if parent[a] != a:
        parent[a] = find_parent(parent[a])
    return parent[a]

def union_parent(a, b):
    a, b = find_parent(a), find_parent(b)
    if a < b:
        parent[b] = a
    else:
        parent[a] = b

N, M = map(int, input().split())
parent = [i for i in range(N + 1)]
edges = []
for _ in range(M):
    A, B, C = map(int, input().split())
    edges.append((C, A, B))

edges.sort(key=lambda x: -x[0])

S, T = map(int, input().split())

for edge in edges:
    cost, a, b = edge
    if find_parent(a) != find_parent(b):
        union_parent(a, b)
        if find_parent(S) == find_parent(T): # 실수한 부분(parent[S] == parent[T]로 호출하고 있었다.)
            print(cost)
            break

####################### 논리상 오류가 있는 코드 ######################### 
max_weight = 0

for edge in edges:
    cost, a, b = edge
    if find_parent(S) == find_parent(T): 
        print(max_weight)
        break
    else:
        if find_parent(a) != find_parent(b):
            union_parent(a, b)
            max_weight = cost
######################################################
