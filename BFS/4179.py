# 불!(4179번)
####################################################
    # 문제: https://www.acmicpc.net/problem/4179
    # BFS
####################################################
import sys
from collections import deque
input=sys.stdin.readline
R,C=map(int,input().split())
board=[]
INF=sys.maxsize
fq=deque()
fire_table=[[INF]*C for i in range(R)]
for i in range(R):
    board.append(list(input().rstrip()))
    for j in range(C):
        if board[i][j]=="J":
            jy,jx=i,j
            board[i][j]="."
        elif board[i][j]=="F":
            fq.append((i,j))
            fire_table[i][j]=0
            board[i][j]="."
dydx=[(-1,0),(0,1),(1,0),(0,-1)]

def spread():
    while fq:
        y,x=fq.popleft()
        for dy,dx in dydx:
            ny,nx=y+dy,x+dx
            if 0<=ny<R and 0<=nx<C:
                if board[ny][nx]==".":
                    if fire_table[y][x]+1<fire_table[ny][nx]:
                        fire_table[ny][nx]=fire_table[y][x]+1
                        fq.append((ny,nx))

def bfs():
    q=deque([(0,jy,jx)])
    visited=[[False]*C for i in range(R)]
    visited[jy][jx]=True
    while q:
        cnt,y,x=q.popleft()
        for dy,dx in dydx:
            ny,nx=y+dy,x+dx
            if 0<=ny<R and 0<=nx<C:
                if board[ny][nx]==".":
                    if cnt+1<fire_table[ny][nx]:
                        if not visited[ny][nx]:
                            q.append((cnt+1,ny,nx))
                            visited[ny][nx]=True
            else:
                return cnt+1
    return "IMPOSSIBLE"
    
spread()
print(bfs())
