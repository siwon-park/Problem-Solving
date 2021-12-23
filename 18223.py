#민준이와 마산 그리고 건우(18223번)
#####################################################
    # 문제: https://www.acmicpc.net/problem/18223
    # 다익스트라 알고리즘
    # 마산의 남자 민준이가 가는 최단 경로에 건우가 있으면 "SAVE HIM"을 출력하고, 아니면 가차 없이 "GOOD BYE"를 출력해야한다.
    # 그렇다면 최단 거리를 일일히 기록을 해야할까 싶은데, 사실 최단 경로는 여러 개일 수도 있고 경로를 찾는 과정에서 P(건우의 위치)가 나왔을 때 어떤 처리를 해줘야하기 때문에
    # 조금 복잡해질 수도 있다.
    # 하지만 최단 경로를 일일히 기록하지 않고 간단하게 푸는 방법이 있는데, 출발 위치를 달리하여 다익스트라를 2번 돌리는 것이다.
    # 바로 P의 위치에서 출발하여 얻을 수 있는 최단 거리 테이블과 1에서 출발하여 얻을 수 있는 최단거리 테이블을 비교하는 것이다.
    # 즉, (P에서 출발하여 1까지 가는 거리 + P에서 출발하여 V까지 가는 거리)와 1에서 출발해서 V까지 가는 거리가 같다면
    # V까지 가는 어떤 최단 경로에는 P가 포함된 경로가 반드시 있다는 의미이다.
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
