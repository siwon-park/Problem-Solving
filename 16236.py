#아기상어(16236번)
########################################################
    # 구현, 시뮬레이션, BFS문제
    # 현재 상어의 좌표에서 먹을 수 있는 물고기들을 BFS로 찾아서 배열에 해당 물고기의 좌표와 그곳으로 가는 데 걸린 시간을 담는다. 
    # 배열을 마지막에 거리순, y좌표, x좌표 우선순위로 정렬한다.
    # 먹을 수 있는 물고기가 담긴 배열의 가장 첫번째 물고기를 먹고 해당 물고기의 위치에 9를, 상어의 원래 위치에는 0으로 넣는다.
    # 상어는 1초에 1칸씩 이동 가능하므로, 해당 물고기를 먹으면 해당 물고기까지 가는 거리만큼 시간을 더 해준다.
    # 만약 현재 사이즈에서 먹은 물고기 수가 현재 크기와 같다면 현재 크기+1을 해주고 먹은 물고기 수를 0으로 초기화해준다.     
    # 다시 현재 위치에서 먹을 수 있는 물고기를 찾아서, 먹을 수 있는 물고기가 없을 때까지 반복한다.
########################################################
import sys
from collections import deque
input=sys.stdin.readline
N=int(input())
board=[]
baby_shark,fishes=[],[]
dydx=[(-1,0),(0,1),(1,0),(0,-1)]
for i in range(N):
    board.append(list(map(int,input().split())))
    for j in range(N):
        if board[i][j]==9:
            baby_shark.append((i,j))
        elif board[i][j]!=0:
            fishes.append((i,j))

def find_edible(shark_y,shark_x,shark_size):
    q=deque([(shark_y,shark_x,0)]) # 여기서 0은 상어의 크기가 아니라 거리임
    edibles=[]
    visited=[[False]*N for i in range(N)]
    visited[shark_y][shark_x]=True
    while q:
        cur_y,cur_x,cur_dist=q.popleft()
        for dy,dx in dydx:
            ny,nx=cur_y+dy,cur_x+dx
            if 0<=ny<N and 0<=nx<N:
                if not visited[ny][nx]:
                    if board[ny][nx]<=shark_size:
                        q.append((ny,nx,cur_dist+1))
                        visited[ny][nx]=True
                        if board[ny][nx]!=0 and board[ny][nx]<shark_size:
                            edibles.append((ny,nx,cur_dist+1))
    if edibles:
        edibles.sort(key=lambda x: (x[2],x[0],x[1])) #거리가 짧은 순, y좌표가 작은 순, x좌표가 작은 순으로 정렬
    return edibles
s_y,s_x,cur_size=baby_shark[0][0],baby_shark[0][1],2
edibles=find_edible(s_y,s_x,cur_size)
times=0
eat_counts=0
while edibles:
    i,j,dist=edibles.pop(0)
    times+=dist
    board[i][j]=9
    board[s_y][s_x]=0
    eat_counts+=1
    if eat_counts==cur_size:
        cur_size+=1
        eat_counts=0
    edibles=find_edible(i,j,cur_size)
    s_y,s_x=i,j
print(times)
