#연구소2(17141번)
########################################################
    # 문제: https://www.acmicpc.net/problem/17141
    # BFS, 브루트포스 알고리즘
    # 바이러스가 다 퍼졌을 때, 
########################################################
import sys
from collections import deque
from itertools import combinations
input=sys.stdin.readline
N,M=map(int,input().split())
board=[]
virus=[]
dydx=[(-1,0),(0,1),(1,0),(0,-1)]
empt_cnt=0
for i in range(N):
    board.append(list(map(int,input().split())))
    for j in range(N):
        if board[i][j]==2:
            virus.append((i,j))
            empt_cnt+=1 # M개의 위치 외에 board[i][j]는 바이러스를 퍼뜨릴 수 있는 빈 공간이 되는 것이므로 board[i][j]==2일 때도 empt_cnt+=1
        elif board[i][j]==0:
            empt_cnt+=1
INF=sys.maxsize

def find_min_time(virus):
    t=INF
    for v_pos in list(combinations(virus,M)):
        q=deque(v_pos)
        time=[[INF]*N for i in range(N)]
        for i,j in v_pos:
            time[i][j]=0
        tmp_t=0 # -INF로 했더니 바이러스를 놓자마자 모든 칸이 다 채워지는 경우에는 0을 출력해야하나 -INF를 출력해버림. 따라서 초기값은 0으로 설정해야함
        cnt=empt_cnt-M # 바이러스를 M개 놓았으니 M을 빼줘야함
        while q:
            y,x=q.popleft()
            for dy,dx in dydx:
                ny,nx=y+dy,x+dx
                if 0<=ny<N and 0<=nx<N:
                    if board[ny][nx]==0 or board[ny][nx]==2: # 처음 바이러스를 퍼뜨린 위치가 아닌 가능성 있는 위치도 2이므로 board[ny][nx]==2일 때도 고려
                        if time[ny][nx]==INF: # 다음 갈 곳이 time배열이 INF면 첫 방문이므로 그 때에만 cnt-=1을 해줌
                            cnt-=1
                        if time[y][x]+1<time[ny][nx]:
                            time[ny][nx]=time[y][x]+1
                            q.append((ny,nx))
                            tmp_t=max(time[ny][nx],tmp_t) # 바이러스가 퍼지는 최대 시간을 갱신                      
        if cnt==0: # cnt가 0개가 되었을 때, 바이러스가 다 퍼진 것이므로 최솟값을 갱신한다                     
            t=min(t,tmp_t)      
    if t==INF:
        return -1                
    return t

print(find_min_time(virus))                            
