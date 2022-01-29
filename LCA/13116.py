# 30번(13116번)
###################################################
    # 문제: https://www.acmicpc.net/problem/13116
    # LCA(최소 공통 조상)
    # 완전 이진 트리; 1개의 부모 노드에 2개의 자식 노드가 있고, 부모 노드의 번호가 i라면 자식 노드의 번호는 각 각 2*i, 2*i+1이다.
    # 규칙을 찾으면 쉽게 풀 수 있는 문제라고 하는데, 잘 모르겠다. 그래서 최소 공통 조상 알고리즘을 통해 해결하였다.
###################################################
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

def lca(a,b):
    while depth[a]!=depth[b]:
        if depth[a]>depth[b]:
            a=parent[a]
        else:
            b=parent[b]
    while a!=b:
        a=parent[a]
        b=parent[b]
    return a

depth=[0]*1024
check=[False]*1024
parent=[0]*1024
graph=[[] for i in range(1024)]
for a in range(1,512):
    graph[a].append(2*a)
    graph[a].append(2*a+1)

dfs(1,0)

T=int(input())
for _ in range(T):
    A,B=map(int,input().split())
    print(lca(A,B)*10)
