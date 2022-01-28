# 가장 가까운 공통 조상(3584번)
########################################################
    # 문제: https://www.acmicpc.net/problem/3584
    # 최소 공통 조상(LCA)
    # 일반적인 최소 공통 조상을 찾는 알고리즘을 통해 풀 수 있는 문제
    # 루트노드를 어떻게 찾을까 고민하다가 그래프에 간선 정보를 넣을 때, 부모 테이블에 대한 정보도 갱신하면서 보니까
    # 부모 테이블에 값이 0인 인덱스가 루트 노드인 것을 알아서 해당 노드에서 깊이 우선 탐색하여 깊이를 알아내고
    # lca를 찾는 알고리즘을 통해 해결하였음
########################################################
import sys
sys.setrecursionlimit(int(1e5))
input=sys.stdin.readline

def dfs(cur, d):
    check[cur]=True
    depth[cur]=d
    for nxt in graph[cur]:
        if not check[nxt]:
            parent[nxt]=cur
            dfs(nxt, d+1)

def lca(a, b):
    while depth[a]!=depth[b]:
        if depth[a]>depth[b]:
            a=parent[a]
        else:
            b=parent[b]
    while a!=b:
        a=parent[a]
        b=parent[b]
    return a

T=int(input())

for _ in range(T):
    N=int(input())
    parent=[0]*(N+1)
    check=[False]*(N+1)
    depth=[0]*(N+1)
    graph=[[] for _ in range(N+1)]
    for i in range(N-1):
        a,b=map(int,input().split())
        graph[a].append(b)
        graph[b].append(a)
        parent[b]=a
    for i in range(1,N+1):
        if parent[i]==0:
            pn=i
    dfs(pn,0)
    a,b=map(int,input().split())
    print(lca(a,b))
