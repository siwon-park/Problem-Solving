# 공항(10775번)
##########################################################################
    # 문제: https://www.acmicpc.net/problem/10775
    # 분리집합(find만 사용)
    # g를 우선적으로 연결하되, g-1, g-2, ... 이렇게 연결해 나간다
    # 이 때 parent[pn] = pn - 1로 만드는 것이 포인트이다.
    # 처음 몇번은 시간 초과를 받았는데 10^10의 시간으론 풀 수 없기 때문이다.
##########################################################################
import sys
sys.setrecursionlimit(int(1e5))
input = sys.stdin.readline

def find(x):
    if parent[x] != x:
        parent[x] = find(parent[x])
    return parent[x]

G = int(input())
P = int(input())
planes = [0]
for _ in range(P):
    g = int(input())
    planes.append(g)

parent = [i for i in range(G + 1)]

dock_cnt = 0
for i in range(1, P + 1):
    g = planes[i]
    pn = find(g)
    if pn == 0:
        break
    parent[pn] = pn - 1 # 현재 부모의 부모노드를 pn-1로 둔다. 즉, 다음번에 pn이 들어왔을 때는 pn-1에 도킹하기 위함이다
    dock_cnt += 1

print(dock_cnt)
