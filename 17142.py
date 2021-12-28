#연구소3(17142번)
####################################################
    # 문제: https://www.acmicpc.net/problem/17142
    # 구현
    # 몇가지 예외? 처리를 하는 것 빼곤 크게 어려운 부분은 없었음.
    # 바이러스인 칸을 지날 때, 비활성화 바이러스일 경우에만 time[ny][nx]=time[y][x]+1을 해줬음
    # 퍼지는 최대 시간을 기록하는 것은 board[ny][nx]==0인 경우에만 해줬음. 왜냐하면 비활성화 바이러스인 칸을 지날 때도 기록하면, 해당 칸은 사실 바이러스가 이미 채워져 있는
    # 상태임에도 그 칸까지 퍼지는 시간을 최대 시간으로 보기 때문. 비활성화 바이러스인 칸에 시간을 +1해주는 것은 해당 비활성화 바이러스가 활성화되기까지의 시간임
####################################################
import sys
from collections import deque
from itertools import combinations
input=sys.stdin.readline
N,M=map(int,input().split())
board=[]
virus=[]
dydx=[(-1,0),(0,1),(1,0),(0,-1)]
empty_size=0
INF=int(1e9)
for i in range(N):
    board.append(list(map(int,input().split())))
    for j in range(N):
        if board[i][j]==2:
            virus.append((i,j))
        elif board[i][j]==0:
            empty_size+=1

def bfs(lst,time,empty):
    q=deque()
    spread_time=0
    visited=[[False]*N for i in range(N)]
    for i,j in lst:
        q.append((i,j))
        visited[i][j]=True
    while q:
        y,x=q.popleft()
        for dy,dx in dydx:
            ny,nx=y+dy,x+dx
            if 0<=ny<N and 0<=nx<N:
                if board[ny][nx]==0:
                    if time[ny][nx]==0 or time[y][x]+1<time[ny][nx]:
                        if time[ny][nx]==0:
                            empty-=1
                        time[ny][nx]=time[y][x]+1
                        spread_time=max(spread_time,time[ny][nx])
                        q.append((ny,nx))
                elif board[ny][nx]==2:
                    if not visited[ny][nx]:
                        visited[ny][nx]=True
                        time[ny][nx]=time[y][x]+1
                        q.append((ny,nx))
    if empty==0:
        return spread_time
    return INF     
                       
def spread(virus):
    min_time=INF
    for cand in list(combinations(virus,M)):
        time_table=[[0]*N for i in range(N)]
        min_time=min(min_time,bfs(cand,time_table,empty_size))
    if min_time==INF:
        return -1    
    return min_time    
print(spread(virus))
