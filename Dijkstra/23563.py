#벽 타기(23563번)
##################################################
    # 문제: https://www.acmicpc.net/problem/23563
    # 다익스트라 알고리즘
    # "벽에 인접한 칸에서 벽에 인접한 칸으로 이동하면 `벽을 타고 이동`한다"가 핵심 포인트
    # 3차원의 최단 거리 배열을 만듦(distance[y좌표][x좌표][벽 인접 유뮤]). 벽 인접 유무는 0 또는 1로 표시함.
##################################################
import sys,heapq
input=sys.stdin.readline
H,W=map(int,input().split())
board=[]
for i in range(H):
    board.append(list(input().rstrip()))
    for j in range(W):
        if board[i][j]=="S":
            si,sj=i,j
        elif board[i][j]=="E":
            ti,tj=i,j
            board[i][j]="." # dijkstra함수 내에서 if board[i][j]=="E"와 같은 조건을 추가적으로 넣지 않기 위해 E위치의 값을 "."으로 초기화시켜줌            

dydx=[(-1,0),(0,1),(1,0),(0,-1)]
INF=sys.maxsize

sw=0 # 기본값은 0, 만약 출발지의 위치가 벽에서 인접한 곳이면 sw=1로 변경
for dy,dx in dydx:
    sy,sx=si+dy,sj+dx
    if 0<=sy<H and 0<=sx<W:
        if board[sy][sx]=="#":
            sw=1
            break
            
distance=[[[INF,INF] for j in range(W)] for i in range(H)]
def dijkstra():
    q=[]
    heapq.heappush(q,(0,sw,si,sj))
    distance[si][sj]=[0,0]
    while q:
        d,w,y,x=heapq.heappop(q)
        if distance[y][x][w]<d:
            continue
        if (y,x)==(ti,tj):
            return min(distance[y][x])
        for dy,dx in dydx:
            ny,nx=y+dy,x+dx
            if 0<=ny<H and 0<=nx<W:
                if board[ny][nx]==".":
                    if w==0: # 현재 위치가 벽에서 인접한 곳이 아닐 경우
                        wall=False
                        for dy,dx in dydx:
                            if 0<=ny+dy<H and 0<=nx+dx<W:
                                if board[ny+dy][nx+dx]=="#":
                                    wall=True
                                    break
                        if wall: # 다음 이동할 위치가 벽과 인접할 곳일 경우, w를 1로 변경하여 우선순위 큐에 삽입. 단, 최단거리배열 갱신 때는 현재의 w 사용
                            if d+1<distance[ny][nx][w]:
                                distance[ny][nx][w]=d+1
                                heapq.heappush(q,(d+1,1,ny,nx))
                        else:
                            if d+1<distance[ny][nx][w]:
                                distance[ny][nx][w]=d+1
                                heapq.heappush(q,(d+1,w,ny,nx))        
                    elif w==1: # 현재 위치가 벽에서 인접한 곳일 경우
                        wall=False
                        for dy,dx in dydx:
                            if 0<=ny+dy<H and 0<=nx+dx<W:
                                if board[ny+dy][nx+dx]=="#":
                                    wall=True
                                    break
                        if wall: # 다음 이동할 위치가 벽과 인접한 곳일 경우 벽 타기 가능
                            if d<distance[ny][nx][w]:
                                distance[ny][nx][w]=d
                                heapq.heappush(q,(d,w,ny,nx))
                        else: # 다음 이동할 위치가 벽과 인접한 곳이 아닐 경우, w를 0으로 변경하여 우선순위 큐에 삽입. 단, 최단거리배열 갱신때는 현재의 w사용 
                            if d+1<distance[ny][nx][w]:
                                distance[ny][nx][w]=d+1
                                heapq.heappush(q,(d+1,0,ny,nx))       
    return distance
print(dijkstra())
