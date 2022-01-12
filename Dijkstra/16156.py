#장애물 달리기(16156번)
#############################################################
    # 문제: https://www.acmicpc.net/problem/16156
    # 다익스트라 알고리즘
    # 처음에 메모리 초과가 떴었음. 구현 방식은 3차원의 최단 거리 배열을 이용 distance[y좌표][x좌표][번호]
    # 근데 이렇게 하면 배열 크기가 1.25억이고, 큐에 너무 많이 삽입되어 메모리 초과가 난 듯 하다.
    # 올바른 풀이 방법은 목적지에서 출발지까지 최단 거리를 계산해 가면서 해당 위치(i,0)에 도착하면 finish[i]+=1을 해주는 것이다.
    # 여기서 헷갈릴 수도 있는 점이 출발점은 최단 거리에 포함 안 시킨다고 해서 graph[i][0]=0으로 바꾸면 안 된다.
    # 왜냐하면 어떤 목적지에서 출발지로 제일 처음 도착한 노드가 남아 있는 출발지를 해당 최단 거리로 먼저 방문해버리는 문제가 발생한다.
#############################################################
import sys, heapq
input=sys.stdin.readline
N,M=map(int,input().split())
graph=[]
INF=sys.maxsize
distance=[[INF]*M for i in range(N)]
q=[]
for i in range(N):
    graph.append(list(map(int,input().split())))
    distance[i][M-1]=graph[i][M-1]
    heapq.heappush(q,(graph[i][M-1],i,M-1,i))
 
dydx=[(-1,0),(0,1),(1,0),(0,-1)]

def dijkstra(q):
    finish=[0]*N
    while q:
        dist,y,x,no=heapq.heappop(q)
        if distance[y][x]<dist:
            continue
        if x==0:
            finish[no]+=1
        for dy,dx in dydx:
            ny,nx=y+dy,x+dx
            if 0<=ny<N and 0<=nx<M:
                nxt_dist=dist+graph[ny][nx]
                if nxt_dist<distance[ny][nx]:
                    distance[ny][nx]=nxt_dist
                    heapq.heappush(q,(nxt_dist,ny,nx,no))                                   
    return finish
g=dijkstra(q)    
for i in range(N):
    print(g[i])            
