# LCA(11437번)
######################################################
  # 문제: https://www.acmicpc.net/problem/11437
  # 최소 공통 조상(LCA)
  # Python으로 통과 못해서 Pypy로 풀었음
  # 현재 구현한 알고리즘이 O(MN)으로 해결되는 알고리즘이라 O(NlogN)으로 해결하는 알고리즘을 찾거나 조금 더 빠른 알고리즘을 찾아야 할듯하다.
######################################################
import sys
sys.setrecursionlimit(int(1e5))
input=sys.stdin.readline

N=int(input())

depth=[0]*(N+1)
check=[False]*(N+1)
graph=[[] for i in range(N+1)]
parent=[0]*(N+1)

def init():
    for i in range(N-1):
        a,b=map(int,input().split())
        graph[a].append(b)
        graph[b].append(a)

def dfs(cur, d):
    check[cur]=True
    depth[cur]=d
    for nxt in graph[cur]:
        if not check[nxt]:
            parent[nxt]=cur
            dfs(nxt, d+1)

init()
dfs(1,0)

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

M=int(input())

for i in range(M):
    a,b=map(int,input().split())
    print(lca(a,b))
