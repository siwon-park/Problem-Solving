#일요일 아침의 데이트(1445번)
#####################################################
    # 문제: https://www.acmicpc.net/problem/1445
    # 다익스트라 알고리즘 이용
    # 쓰레기를 지나는 칸을 최소로 하되, 그 수가 같다면 쓰레기 옆을 지나는 칸의 개수를 최소화 시켜야함
    # 따라서 distance table은 튜플 형태의 요소를 가진 2차원의 배열로 선언
    # board에 대한 정보를 입력받으면서, 쓰레기의 좌표 위치를 배열에 담고, 시작위치와 도착위치를 기억한다.
    # 쓰레기 좌표들에 대해서 범위 내 상하좌우가 "."이면 그것을 "*"로 바꿔준다.
    # 그 이후에는 다익스트라 함수를 만들어서 해결하면 된다. 우선순위 큐에는 (지나간 쓰레기 칸의 개수, 지나간 쓰레기 옆 칸의 개수, y좌표, x좌표) 순으로 넣는다.
#####################################################
import sys,heapq
input=sys.stdin.readline
N,M=map(int,input().split())
board=[]
trash=[]
dydx=[(-1,0),(0,1),(1,0),(0,-1)]
for i in range(N):
    board.append(list(input().rstrip()))
    for j in range(M):
        if board[i][j]=="g":
            trash.append((i,j))
        elif board[i][j]=="S":
            si,sj=i,j
        elif board[i][j]=="F":
            ti,tj=i,j

for i,j in trash:            
    for di,dj in dydx:
        ni,nj=i+di,j+dj
        if 0<=ni<N and 0<=nj<M:
            if board[ni][nj]==".":
                board[ni][nj]="*"
                
INF=int(1e9)
distance=[[(INF,INF)]*M for i in range(N)]
def dijkstra():
    q=[]
    heapq.heappush(q,(0,0,si,sj))
    distance[si][sj]=(0,0)
    while q:
        g_count,g_near,y,x=heapq.heappop(q)
        if distance[y][x][0]<g_count and distance[y][x][1]<g_near:
            continue
        for dy,dx in dydx:
            ny,nx=y+dy,x+dx
            if 0<=ny<N and 0<=nx<M:
                if board[ny][nx]=="g": # 쓰레기 칸(g)를 지났을 경우
                    G=g_count+1
                    if G<distance[ny][nx][0]:
                        distance[ny][nx]=(G,g_near)
                        heapq.heappush(q,(G,g_near,ny,nx))
                elif board[ny][nx]=="*": # 쓰레기 옆 칸을 지났을 경우
                    GN=g_near+1
                    cur_g,cur_gn=distance[ny][nx]
                    if g_count<=cur_g and GN<cur_gn:
                        distance[ny][nx]=(g_count,GN)
                        heapq.heappush(q,(g_count,GN,ny,nx))
                else: # 나머지 칸을 지났을 경우
                    if g_count<distance[ny][nx][0] and g_near<distance[ny][nx][1]: # (처음에 이 조건을 안 넣어서 무한 루프가 발생했음)
                        distance[ny][nx]=(g_count,g_near)
                        heapq.heappush(q,(g_count,g_near,ny,nx))
    return distance                    
d=dijkstra()
print(*d[ti][tj])    
