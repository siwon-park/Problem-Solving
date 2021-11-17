#파티(1238번) #1276ms소모 개선이 필요할듯
import sys,heapq
input=sys.stdin.readline
N,M,X=map(int,input().split())
graph=[[] for i in range(N+1)]
for i in range(M):
    a,b,T=map(int,input().split())
    graph[a].append((b,T))
def dijkstra(n):
    distance=[int(1e9)]*(N+1)
    q=[]
    heapq.heappush(q,(0,n))
    distance[n]=0
    while q:
        dist,cur=heapq.heappop(q)
        if distance[cur]<dist:
            continue
        for n_cur,t in graph[cur]:
            cost=dist+t
            if cost<distance[n_cur]:
                distance[n_cur]=cost
                heapq.heappush(q,(cost,n_cur))
    return distance
max_dist=-int(1e9)
back_dist=dijkstra(X)
for i in range(1,N+1):
    max_dist=max(max_dist,dijkstra(i)[X]+back_dist[i])
print(max_dist)
