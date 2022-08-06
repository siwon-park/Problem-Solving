#공주님을 구해라!(17836번)
#######################################################
    # 문제: https://www.acmicpc.net/problem/17836
    # BFS
    # 처음에는 time 배열을 1차원의 배열로 짰으나, 그람을 먹었을 때와 안 먹었을 때 구분해줘야했었음
    # 그래도 자꾸 시간초과가 나서 이유를 몰랐는데 "<"으로 썼어야 했던걸 자꾸 "<="으로 써서 그랬었음(다음부터 유의)
#######################################################
import sys
from collections import deque
input=sys.stdin.readline
N,M,T=map(int,input().split())
board=[]
for i in range(N):
    board.append(list(map(int,input().split())))
INF=int(1e9)    
time=[[[INF,INF] for j in range(M)] for i in range(N)]
dydx=[(-1,0),(0,1),(1,0),(0,-1)]

def bfs():
    q=deque([(0,0,0,0)]) #시간, 그람, y좌표, x좌표
    time[0][0]=[0,0]
    while q:
        t,g,y,x=q.popleft()
        for dy,dx in dydx:
            ny,nx=y+dy,x+dx
            if 0<=ny<N and 0<=nx<M:
                if board[ny][nx]==0 or board[ny][nx]==2:
                    if t+1<time[ny][nx][g]: # "<="이 아니라 "<"으로 써야 했었음(값이 같을 경우엔 더 방문할 필요가 없는 셈이니까 실수임)
                        time[ny][nx][g]=t+1
                        if board[ny][nx]==2:
                            q.append((t+1,1,ny,nx))
                        else:
                            q.append((t+1,g,ny,nx))
                elif board[ny][nx]==1:
                    if g==1:
                        board[ny][nx]=0
                        if t+1<time[ny][nx][g]: # "<="이 아니라 "<"으로 써야 했었음
                            time[ny][nx][g]=t+1
                            q.append((t+1,1,ny,nx))
    if min(time[N-1][M-1])>T: # time[N-1][M-1]의 배열의 최솟값이 T보다 크다면 어떻게든 T이하로는 갈 수 없다는 의미이므로, "Fail"
        return "Fail"
    return min(time[N-1][M-1])

print(bfs())
