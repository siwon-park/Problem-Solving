#파티(1238번)
#####################################################################
    # 문제: https://www.acmicpc.net/problem/1238
    # 다익스트라 알고리즘 이용
    # 개선 전 코드는 1276ms 걸렸음. 그럴 수 밖에 없는 것이 다익스트라 알고리즘을 N+1번 돌리기 때문(1번은 X에서 각자로 되돌아가는 경우를 계산하기 위함) 
#####################################################################
######################개선 전 코드(1276ms)###########################
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
back_dist=dijkstra(X) # X에서 출발하여 각자 마을로 돌아오는 최소 거리 배열(X→?)
for i in range(1,N+1):
    max_dist=max(max_dist,dijkstra(i)[X]+back_dist[i])
print(max_dist)
#################################################################

####################개선 후 코드(80ms)###########################
    # 문제에서 단방향 그래프라고 했는데, 그점에서 착안하여 역방향 그래프를 하나 선언하는 것이 포인트
    # 주어진 정방향 그래프에서는 X에서 각자의 마을로 돌아가는 경우를 다익스트라 1번으로 계산할 수 있고,
    # 역방향 그래프에서는 각자의 마을에서 X로 가는 경우를 다익스트라 1번에 계산 가능하다.
    # 다익스트라 알고리즘은 특정 노드에서 모든 노드로 가는 최단 거리를 계산할 수 있으므로, 정방향 그래프는 X → ?인 셈이고,
    # 역방향 그래프는 ? → X인 셈이다. 다익스트라의 출발점이 둘 다 X에서 출발하기 때문에 역방향의 경우 이해 안 갈 수도 있지만,
    # 쉽게 말해, 정방향이 X에서 출발하여 각 노드로 도착하는 최단 거리를 구한다고 한다면,
    # 역방향은 X에서 출발하여 각 노드로 향하지만, 그 방향이 사실 반대인 셈이므로, 각 노드들에서 X로 몰려든다고 이해하면 된다.
#################################################################
import sys,heapq
input=sys.stdin.readline
N,M,X=map(int,input().split())
graph=[[] for i in range(N+1)] # 정방향 그래프
r_graph=[[] for i in range(N+1)] # 역방향 그래프
for i in range(M):
    a,b,T=map(int,input().split())
    graph[a].append((b,T)) # 정방향 정보를 정방향 그래프에 삽입
    r_graph[b].append((a,T)) # 역방향 정보를 역방향 그래프에 삽입
def dijkstra(n,board): # 다익스트라 함수의 변수에 graph를 넣음
    distance=[int(1e9)]*(N+1)
    q=[]
    heapq.heappush(q,(0,n))
    distance[n]=0
    while q:
        dist,cur=heapq.heappop(q)
        if distance[cur]<dist:
            continue
        for n_cur,t in board[cur]:
            cost=dist+t
            if cost<distance[n_cur]:
                distance[n_cur]=cost
                heapq.heappush(q,(cost,n_cur))
    return distance
max_dist=-int(1e9)
back_dist=dijkstra(X,graph) # X에서 출발하여 각자 마을로 돌아오는 최소 거리 배열(X→?)
go_dist=dijkstra(X,r_graph) # X에서 출발하긴 하나, 결국 방향이 원본 데이터와 반대이므로, 사실 각자 마을에서 X로 향하는 최소 거리 배열(?→X)
for i in range(1,N+1):
    max_dist=max(max_dist,go_dist[i]+back_dist[i])
print(max_dist)
