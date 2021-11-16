#알고스팟(1261번)
#############################################
    # 문제: https://www.acmicpc.net/problem/1261
    # 다익스트라 알고리즘 이용
    # 벽은 언제든지 부술 수 있기 때문에, 어떻게든 도착지(M,N)에는 도착할 수 있음. 다음 이동할 곳이 벽이냐 아니냐에 따라 처리만 다르게 해주면 됨
    # 만약 다음 이동할 곳이 벽일경우(board[ny][nx]==1), 다음 이동할 곳에 도착했을 때의 벽을 부순 횟수(distance[ny][nx]) 보다
    # 현재 부수고 온 횟수+1(b=broken+1)가 더 작으면 우선순위 큐에 삽입
    # 만약 다음 이동할 곳이 벽이 아니라면, 현재 부수고 온 횟수(broken)과 다음 이동할 곳의 벽을 부순 횟수(distance[ny][nx])를 비교하여,
    # 현재 부수고 온 횟수가 더 작으면 우선순위 큐에 삽입
#############################################
import sys,heapq
input=sys.stdin.readline
N,M=map(int,input().split())
board=[]
for i in range(M):
    board.append(list(map(int,list(input().rstrip()))))
dydx=[(-1,0),(0,1),(1,0),(0,-1)]
INF=int(1e9)
distance=[[INF]*N for i in range(M)]
def djikstra(i,j):
    q=[]
    heapq.heappush(q,(0,i,j))
    distance[i][j]=0
    while q:
        broken,y,x=heapq.heappop(q)
        if distance[y][x]<broken:
            continue
        if (y,x)==(M-1,N-1):
            return distance[y][x]
        for dy,dx in dydx:
            ny,nx=y+dy,x+dx
            if 0<=ny<M and 0<=nx<N:
                if board[ny][nx]==1:
                    b=broken+1
                    if distance[ny][nx]>b:
                        distance[ny][nx]=b
                        heapq.heappush(q,(b,ny,nx))
                else:
                    if distance[ny][nx]>broken:
                        distance[ny][nx]=broken
                        heapq.heappush(q,(broken,ny,nx))
print(djikstra(0,0))
