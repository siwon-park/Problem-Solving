#악덕 영주 혜유(20010번)
##################################################
    # 문제: https://www.acmicpc.net/problem/20010
    # 최소 스패닝 트리(크루스칼 알고리즘), 다익스트라 알고리즘(BFS도 가능)
    # 최소 비용은 최소 스패닝 트리를 연결하는 비용을 구하면 되고, 마을과 마을 간 최악의 비용은 BFS나 다익스트라 알고리즘을 통해 계산 가능함
##################################################
import sys,heapq
input=sys.stdin.readline

def find_parent(parent,x):
    if parent[x]!=x:
        parent[x]=find_parent(parent,parent[x])
    return parent[x]

def union_parent(parent,a,b):
    a,b=find_parent(parent,a),find_parent(parent,b)
    if a<b:
        parent[b]=a
    else:
        parent[a]=b

N,K=map(int,input().split())
edges=[]
for i in range(K):
    a,b,c=map(int,input().split())
    edges.append((c,a,b))
edges.sort()
result=0
parent=[i for i in range(N)]
graph=[[] for i in range(N)]
for edge in edges:
    cost,a,b=edge
    if find_parent(parent,a)!=find_parent(parent,b):
        union_parent(parent,a,b)
        graph[a].append((b,cost))
        graph[b].append((a,cost))
        result+=cost
print(result)
INF=sys.maxsize
def dijkstra(S):
    q=[]
    heapq.heappush(q,(0,S))
    distance=[INF]*N
    distance[S]=0
    while q:
        dist,cur=heapq.heappop(q)
        if distance[cur]<dist:
            continue
        for nxt,cost in graph[cur]:
            nxt_dist=dist+cost
            if nxt_dist<distance[nxt]:
                distance[nxt]=nxt_dist
                heapq.heappush(q,(nxt_dist,nxt))
    return max(distance)
worst=0    
for i in range(N):
    worst=max(worst,dijkstra(i))
print(worst)    
