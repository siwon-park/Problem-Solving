#현수막(14716번)
############################################################
    # 문제: https://www.acmicpc.net/problem/14716
    # BFS, DFS
############################################################
import sys
from collections import deque
input=sys.stdin.readline
M,N=map(int,input().split())
board=[]
dydx=[(-1,0),(0,1),(1,0),(0,-1),(-1,-1),(-1,1),(1,1),(1,-1)]
for i in range(M):
    board.append(list(map(int,input().split())))
visited=[[False]*N for i in range(M)]
cnt=0
for i in range(M):
    for j in range(N):
        if board[i][j]==1:
            if not visited[i][j]:
                visited[i][j]=True
                cnt+=1
                q=deque([(i,j)])
                while q:
                    y,x=q.popleft()
                    for dy,dx in dydx:
                        ny,nx=y+dy,x+dx
                        if 0<=ny<M and 0<=nx<N:
                            if board[ny][nx]==1:
                                if not visited[ny][nx]:
                                    q.append((ny,nx))
                                    visited[ny][nx]=True
print(cnt)                                
