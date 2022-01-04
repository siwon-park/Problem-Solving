#음식물 피하기(1743번)
####################################################
    # 문제: https://www.acmicpc.net/problem/1743
    # BFS
####################################################
import sys
from collections import deque
input=sys.stdin.readline
N,M,K=map(int,input().split())
board=[["."]*M for i in range(N)]
for i in range(K):
    r,c=map(lambda x: int(x)-1,input().split())
    board[r][c]="#"
visited=[[False]*M for i in range(N)]
dydx=[(-1,0),(0,1),(1,0),(0,-1)]

def bfs(q):
    size=1
    while q:
        y,x=q.popleft()
        for dy,dx in dydx:
            ny,nx=y+dy,x+dx
            if 0<=ny<N and 0<=nx<M:
                if board[ny][nx]=="#":
                    if not visited[ny][nx]:
                        size+=1
                        q.append((ny,nx))
                        visited[ny][nx]=True
    return size    

max_size=-sys.maxsize
for i in range(N):
    for j in range(M):
        if board[i][j]=="#":
            if not visited[i][j]:
                visited[i][j]=True
                q=deque([(i,j)])
                max_size=max(max_size,bfs(q))
print(max_size)                
