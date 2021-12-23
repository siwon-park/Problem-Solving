#민준이와 마산 그리고 건우(18223번)
#####################################################
    # 문제: https://www.acmicpc.net/problem/18223
    # 다익스트라 알고리즘
    # 마산의 남자 민준이가 가는 최단 경로에 건우가 있으면 "SAVE HIM"을 출력하고, 아니면 가차 없이 "GOOD BYE"를 출력해야한다.
    # 그렇다면 최단 거리를 일일히 기록을 해야할까 싶은데, 사실 최단 경로는 여러 개 일 수도 있고
    # 그렇다고 P(건우의 위치)가 나왔을 때 뭔가 어드밴티지를 줘버리면 그 이후에 계산하는 거리가 최단거리가 아닐 수도 있다.
    # 
#####################################################
import sys, heapq
input=sys.stdin.readline
V,E,P=map(int,input().split())
INF=sys.maxsize
graph=[[] for i in range(V+1)]
for i in range(E):
    a,b,c=map(int,input().split())
    graph[a].append((b,c))
    graph[b].append((a,c))

def dijkstra(S):
    distance=[INF]*(V+1)
    q=[]
    heapq.heappush(q,(0,S))
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
    return distance
P_dist=dijkstra(P)
N_dist=dijkstra(1)
if P_dist[1]+P_dist[V]==N_dist[V]:
    print("SAVE HIM")
else:
    print("GOOD BYE")    
