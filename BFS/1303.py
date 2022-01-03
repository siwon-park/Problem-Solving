#전쟁-전투(1303번)
################################################
    # 문제: https://www.acmicpc.net/problem/1303
    # BFS, DFS
    # 문제에서 가로의 크기가 N이고, 세로의 크기가 M이므로 주의할 것. 앞에 오는 것이 세로일 것이라 생각하여 첫 시도에서 인덱스 에러가 발생했음
    # 별 특이한 점 없는 일반 BFS, DFS문제임
################################################
import sys
from collections import deque
input=sys.stdin.readline

M,N=map(int,input().split())
board=[]
for i in range(N):
    board.append(list(input().rstrip()))
dydx=[(-1,0),(0,1),(1,0),(0,-1)]
visited=[[False]*M for i in range(N)]

def bfs(q,color):
    cnt=1
    while q:
        y,x=q.popleft()
        for dy,dx in dydx:
            ny,nx=y+dy,x+dx
            if 0<=ny<N and 0<=nx<M:
                if board[ny][nx]==color:
                    if not visited[ny][nx]:
                        q.append((ny,nx))
                        visited[ny][nx]=True
                        cnt+=1
    return cnt*cnt

W,B=0,0
for i in range(N):
    for j in range(M):
        if not visited[i][j]:
            visited[i][j]=True
            q=deque([(i,j)])
            if board[i][j]=="W":
                W+=bfs(q,board[i][j])
            else:
                B+=bfs(q,board[i][j])    
print(W,B)
