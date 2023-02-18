#그림(1926번)
###################################################
    # 문제: https://www.acmicpc.net/problem/1926
    # BFS 이용
    # 3회나 시도했는데, 첫번째는 예외처리를 못했음; 그림이 0개일 경우 최대 넓이는 0이어야함.
    # 두번째 인덱스 에러; n x m 배열인데 visited배열의 열 개수를 n으로 선언했었음.
###################################################
import sys
from collections import deque
input=sys.stdin.readline
n,m=map(int,input().split())
board=[]
for i in range(n):
    board.append(list(map(int,input().split())))
visited=[[False]*m for i in range(n)]
dydx=[(-1,0),(0,1),(1,0),(0,-1)]
max_width=-int(1e9)
count=0
for i in range(n):
    for j in range(m):
        if board[i][j]==1:
            if not visited[i][j]:
                visited[i][j]=True
                q=deque([(i,j)])
                width=1
                while q:
                    y,x=q.popleft()
                    for dy,dx in dydx:
                        ny,nx=y+dy,x+dx
                        if 0<=ny<n and 0<=nx<m:
                            if board[ny][nx]==1:
                                if not visited[ny][nx]:
                                    q.append((ny,nx))
                                    width+=1
                                    visited[ny][nx]=True
                count+=1
                max_width=max(max_width,width)
if count==0:
    max_width=0
print(count)
print(max_width)                                    
