#주난의 난(14497번)
#################################################
    # 문제: https://www.acmicpc.net/problem/14497
    # 다익스트라 알고리즘
    # 다음좌표가 1일 때 jump+1한 값이 최단 거리 테이블의 다음좌표보다 작으면 해당 값을 갱신해주고
    # 그게 아니라면 jump값이 최단 거리 테이블의 다음좌표보다 작으면 값을 갱신
    # 최종 출력에서 초코바를 가지고 있는 친구의 위치의 최단 거리 테이블 값+1을 해주면 됨
#################################################
import sys, heapq
input=sys.stdin.readline
N,M=map(int,input().split())
y1,x1,y2,x2=map(int,input().split())
board=[]
for i in range(N):
    board.append(list(input().rstrip()))
INF=sys.maxsize
dydx=[(-1,0),(0,1),(1,0),(0,-1)]

def dijkstra():
    q=[]
    heapq.heappush(q,(0,y1-1,x1-1))
    distance=[[INF]*M for i in range(N)]
    distance[y1-1][x1-1]=0
    while q:
        jumped,y,x=heapq.heappop(q)
        if distance[y][x]<jumped:
            continue
        for dy,dx in dydx:
            ny,nx=y+dy,x+dx
            if 0<=ny<N and 0<=nx<M:
                if board[ny][nx]=="1":
                    if jumped+1<distance[ny][nx]:
                        distance[ny][nx]=jumped+1
                        heapq.heappush(q,(jumped+1,ny,nx))
                else:
                    if jumped<distance[ny][nx]:
                        distance[ny][nx]=jumped
                        heapq.heappush(q,(jumped,ny,nx))
    return distance

d=dijkstra()
print(d[y2-1][x2-1]+1)
