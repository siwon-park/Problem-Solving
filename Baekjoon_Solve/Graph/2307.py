# 도로검문(2307번)
#########################################################
    # 문제: https://www.acmicpc.net/problem/2307
    # 다익스트라 알고리즘
    # Roadblock(9988번)과 거의 같은 문제
    # 최단 거리 경로를 찾고, 해당 경로의 간선을 하나씩 빼면서 최단 경로에 있는 간선의 개수만큼 다익스트라 알고리즘을 돌리면 됨
    # 로직 자체는 크게 차이가 없으나, 내 알고리즘의 실행 속도는 매우 느린편이다.(4800ms대) 분명 시간 차이를 크게 만드는 요소가 있겠지... 향후 개선이 필요할 듯?
#########################################################
import sys,heapq
input=sys.stdin.readline
INF=sys.maxsize

N,M=map(int,input().split())
graph=[[] for i in range(N+1)]
for i in range(M):
    a,b,t=map(int,input().split())
    graph[a].append((b,t))
    graph[b].append((a,t))

path=[[] for i in range(N+1)]
path[1]=0
check=True

def dijkstra(a,b):
    q=[]
    distance=[INF]*(N+1)
    distance[1]=0
    heapq.heappush(q,(0,1))
    while q:
        d,cur=heapq.heappop(q)
        if distance[cur]<d:
            continue
        for nxt,cost in graph[cur]:
            if (cur,nxt)==(a,b) or (cur,nxt)==(b,a):
                continue
            nxt_cost=d+cost
            if nxt_cost<distance[nxt]:
                distance[nxt]=nxt_cost
                heapq.heappush(q,(nxt_cost,nxt))
                if check:
                    path[nxt]=cur
    return distance

cur_short_path=dijkstra(0,0)[N]
check=False

nxt_short_path=0
for i in range(2,N+1):
    a,b=i,path[i]
    nxt_short_path=max(nxt_short_path,dijkstra(a,b)[N])

if nxt_short_path==INF:
    print(-1)
else:
    print(nxt_short_path-cur_short_path)
