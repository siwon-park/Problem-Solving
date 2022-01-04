#침투(13565번)
##########################################################
    # 문제: https://www.acmicpc.net/problem/13565
    # BFS
    # 일반적인 BFS, y+1이 M을 초과하면 전류가 반대편까지 침투가 가능하다는 뜻이므로 바로 return "YES"를 함
    # 또한 처음 큐에 삽입하는 요소도 첫번째 줄에 있는 0에 대해서만 탐색해도 됨
##########################################################
import sys
from collections import deque
input=sys.stdin.readline
M,N=map(int,input().split())
board=[]
dydx=[(-1,0),(0,1),(1,0),(0,-1)]
for i in range(M):
    board.append(list(map(int,list(input().rstrip()))))
visited=[[False]*N for i in range(M)]

def bfs():
    for j in range(N):
        if board[0][j]==0:
            if not visited[0][j]:
                q=deque([(0,j)])
                visited[0][j]=True
                while q:
                    y,x=q.popleft()
                    if y+1>=M:
                        return "YES"
                    for dy,dx in dydx:
                        ny,nx=y+dy,x+dx
                        if 0<=ny<M and 0<=nx<N:
                            if board[ny][nx]==0 and not visited[ny][nx]:
                                visited[ny][nx]=True
                                q.append((ny,nx))
    return "NO"

print(bfs())        
