#장애물 달리기(16156번)
#############################################################
    # 문제: https://www.acmicpc.net/problem/16156
    # 다익스트라 알고리즘
    # 처음에 메모리 초과가 떴었음. 구현 방식은 3차원의 최단 거리 배열을 이용 distance[y좌표][x좌표][번호]
    # 근데 이렇게 하면 배열 크기가 1.25억이고, 큐에 너무 많이 삽입되어 메모리 초과가 난 듯 하다.
    # 올바른 풀이 방법은 목적지에서 출발지까지 최단 거리를 계산해 가면서 해당 위치(i,0)에 도착하면 finish[i]+=1을 해주는 것이다.
    # 여기서 헷갈릴 수도 있는 점이 출발점은 최단 거리에 포함 안 시킨다고 해서 graph[i][0]=0으로 바꾸면 안 된다.
    # 왜냐하면 어떤 목적지에서 출발지로 제일 처음 도착한 노드가 남아 있는 출발지를 해당 최단 거리로 먼저 방문해버리는 문제가 발생한다.
    
    # 그럼 출발점을 최단 거리에 포함시키지 않는다를 어떻게 이해하면 되는가?
    # 곰곰히 생각해보면 어떤 목적지에서 어떤 출발지까지의 거리가 최단 거리라면 그 최단 거리 값에서 목적지까지 가는 값 하나를 빼나, 출발지에 있는 숫자를 빼나
    # 목적지-출발지까지의 최단거리라는 사실은 변함이 없다. 만약에 변한다? 그럼 그것은 애초에 최단 거리가 아니라는 소리다.
    # 즉, 출발지의 값을 빼는 것이나 목적지까지 가는 값을 빼는 것이나 같다는 의미이다. 그리고 목적지에서 출발할 경우 사실 상 목적지가 공통 출발지이므로,
    # 최단 거리에 목적지 값이 포함되나 안 되나 똑같다. 어차피 어떤 출발지에서 해당 목적지까지 최단 거리로 도착할 때, 해당 목적지 값은 공통적으로 가산되기 때문이다.
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
    distance[i][M-1]=graph[i][M-1] # 목적지에서 출발하므로 목적지의 최단거리 테이블 값을 목적지 값으로 초기화 시켜준다
    heapq.heappush(q,(graph[i][M-1],i,M-1,i)) # 목적지 값, y좌표, x좌표, 목적지 번호
 
dydx=[(-1,0),(0,1),(1,0),(0,-1)]

def dijkstra(q):
    finish=[0]*N
    while q:
        dist,y,x,no=heapq.heappop(q)
        if distance[y][x]<dist:
            continue
        if x==0: # x좌표가 0이라면 출발지에 도착한 것이므로
            finish[no]+=1 # 해당 목적지 번호를 finish 배열 인덱스로하여 +=1을 해준다
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
