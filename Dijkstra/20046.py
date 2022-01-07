#Road Reconstruction(20046번)
####################################################
    # 문제: https://www.acmicpc.net/problem/20046
    # 다익스트라 알고리즘
    # 2차원의 배열을 이용하는 일반적인 다익스트라 알고리즘
####################################################
import sys, heapq
input=sys.stdin.readline
m,n=map(int,input().split())
board=[]
for i in range(m):
    board.append(list(map(int,input().split())))
INF=sys.maxsize
dydx=[(-1,0),(0,1),(1,0),(0,-1)]

def dijkstra():
    if board[0][0]==-1 or board[m-1][n-1]==-1:
        return -1
    distance=[[INF]*n for i in range(m)]        
    q=[]
    heapq.heappush(q,(board[0][0],0,0))
    distance[0][0]=board[0][0]
    while q:
        dist,y,x=heapq.heappop(q)
        if distance[y][x]<dist:
            continue
        for dy,dx in dydx:
            ny,nx=y+dy,x+dx
            if 0<=ny<m and 0<=nx<n:
                if board[ny][nx]!=-1:
                    n_dist=dist+board[ny][nx]
                    if n_dist<distance[ny][nx]:
                        distance[ny][nx]=n_dist
                        heapq.heappush(q,(n_dist,ny,nx))
    if distance[m-1][n-1]!=INF:
        return distance[m-1][n-1]
    return -1
        
print(dijkstra())                        
