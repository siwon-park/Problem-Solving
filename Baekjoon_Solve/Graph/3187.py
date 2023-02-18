#양치기 꿍(3187번)
#################################################
    # 문제: https://www.acmicpc.net/problem/3187
    # BFS, DFS
    # k,v일 때를 구분하고 나눠서 돌리지 않고, "#"와 "."이 아닐 때, 한꺼번에 돌리면서 k와 v를 카운트하였음
    # 카운트한 것이 더 많은 쪽만 더해주면 
#################################################
import sys
from collections import deque
input=sys.stdin.readline
R,C=map(int,input().split())
board=[]
dydx=[(-1,0),(0,1),(1,0),(0,-1)]
for i in range(R):
    board.append(list(input().rstrip()))
visited=[[False]*C for i in range(R)]

def bfs(i,j):
    k_cnt,v_cnt=0,0
    if board[i][j]=="k":
        k_cnt+=1
    else:
        v_cnt+=1
    q=deque([(i,j)])
    visited[i][j]=True        
    while q:
        y,x=q.popleft()
        for dy,dx in dydx:
            ny,nx=y+dy,x+dx
            if 0<=ny<R and 0<=nx<C:
                if board[ny][nx]!="#":
                    if not visited[ny][nx]:
                        q.append((ny,nx))
                        visited[ny][nx]=True
                        if board[ny][nx]=="v":
                            v_cnt+=1
                        elif board[ny][nx]=="k":
                            k_cnt+=1
    return k_cnt, v_cnt

t_k_cnt,t_v_cnt=0,0                             
for i in range(R):
    for j in range(C):
        if board[i][j]!="#" and board[i][j]!=".":
            if not visited[i][j]:
                tmp_k,tmp_v=bfs(i,j)
                if tmp_k>tmp_v:
                    t_k_cnt+=tmp_k
                else:
                    t_v_cnt+=tmp_v
print(t_k_cnt,t_v_cnt)                        
