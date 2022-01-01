#면접보는 승범이네(17835번)
#####################################################
    # 문제: https://www.acmicpc.net/problem/17835
    # 다익스트라 알고리즘
    # 각 출발지에서 면접장까지 가는 거리를 구하는 것이 아니라, 면접장에서 각 출발지까지 가는 거리를 구하는 것이 반복을 피할 수 있음
    # 따라서 단방향 간선정보를 입력 받을 때, 그래프에 반대 방향으로 역으로 정보를 넣는다.
    # 그런데 면접장이 여러군데여서 처음에는 다익스트라를 K번 놀리는 실수를 범했다. 
    # 1<=K<=N이므로, 다익스트라를 K번 돌리고, N번 비교를 해주면서 최종적인 최단 거리 테이블을 만들게하면 최악의 경우 N^2임
    # 생각해보면 어차피 각 면접장에서 각 출발지까지의 최단거리를 찾는 것이므로, 큐에 하니씩만 넣고 다익스트라를 개별적으로 돌리는 것이 아니라
    # 큐에 면접장 위치를 다 넣고, 자기자신의 거리를 0으로 초기화하여 다익스트라를 1번만 돌려도 된다
#####################################################
import sys,heapq
input=sys.stdin.readline
N,M,K=map(int,input().split())
graph=[[] for i in range(N+1)]
INF=sys.maxsize
for i in range(M):
    U,V,C=map(int,input().split())
    graph[V].append((U,C)) # 각 면접장에서 출발하는 것이므로, 역방향으로 삽입함
cities=list(map(int,input().split()))

def dijkstra():
    distance=[INF]*(N+1)
    q=[]
    for S in cities: # 각 면접장의 위치와 거리를 우선순위 큐에 전부 삽입함
        heapq.heappush(q,(0,S))
        distance[S]=0
    while q:
        dist,cur=heapq.heappop(q)
        if distance[cur]<dist:
            continue
        for nxt,cost in graph[cur]:
            nxt_cost=dist+cost
            if nxt_cost<distance[nxt]:
                distance[nxt]=nxt_cost
                heapq.heappush(q,(nxt_cost,nxt))
    return distance

d=dijkstra()
max_dist=0
for i in range(N,0,-1): # 최단 거리 중 가장 큰 값을 찾으면서, 그러한 값을 가진 가장 작은 도시번호를 찾아야하므로, 역순으로 반복구문을 돌림
    if d[i]>=max_dist:
        max_dist=d[i]
        city_no=i
print(city_no)
print(max_dist)
