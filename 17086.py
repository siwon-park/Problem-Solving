#아기 상어2(17086번)
####################################################
    # 브루트포스 알고리즘, BFS 탐색 이용
    # board[i][j]==0인 모든 좌표에 대해 가장 가까운 1까지의 거리가 가장 큰 값을 구하면 됨
    # 통과 시간이 6000ms대여서 개선이 필요해 보임
####################################################
import sys
from collections import deque
input=sys.stdin.readline
N,M=map(int,input().split())
dydx=[(-1,0),(0,1),(1,0),(0,-1),(1,1),(-1,-1),(-1,1),(1,-1)]
board=[]
for i in range(N):
    board.append(list(map(int,input().split())))
def find_safe_dist(i,j):
    q=deque([(i,j,0)])
    visited=[[False]*M for i in range(N)]
    visited[i][j]=True
    while q:
        y,x,dist=q.popleft()
        if board[y][x]==1:
            return dist
        for dy,dx in dydx:
            ny,nx=y+dy,x+dx
            if 0<=ny<N and 0<=nx<M:
                if not visited[ny][nx]:
                    visited[ny][nx]=True
                    q.append((ny,nx,dist+1))
    return 0
def max_safe_dist():
    msd=-int(1e9)
    for i in range(N):
        for j in range(M):
            if board[i][j]==0:
                sd=find_safe_dist(i,j)
                if sd>msd:
                    msd=sd
    return msd
print(max_safe_dist())          
