#어른 상어(19237번)
##################################################################
    # 문제: https://www.acmicpc.net/problem/19237
    # 구현 문제
    # 처음에 어떻게 접근할지 헤멨음. 왜냐하면 방향 정보와 냄새, 냄새가 남은 시간 등 신경써야할 정보가 많았기 때문
    # 해결했던 방법은 방향 정보 배열과 냄새에 대한 3차원 배열을 따로 선언하는 것이었음
    # 이번 문제를 풀면서 다시 느낀거지만, 이러한 스킬들(정보만 체크하는 새로운 배열을 선언하는 등)을 항상 염두해둬야겠음.
    # 구현이나 BFS, DFS라고 해서 항상 해당 주어진 배열에서 노는게 아니기 때문.
    
    # 처음에는 모든 좌표에 대해 접근하면 시간 초과가 날 것 같다는 느낌이 들어서 상어의 좌표를 받고 옮긴 뒤 새로운 상어 좌표 배열을 반환하는 식으로 풀려고했는데,
    # 이 또한 쉽지 않았던게 큰 상어가 있는 위치에 작은 상어가 들어가게 되는데, 이동을 큰 상어가 먼저하게 되면 새로운 상어 좌표 배열에서 해당 정보를 삭제하기가 쉽지 않았다.
    # (상어 좌표에 (상어번호, 상어의 y, 상어의 x, 상어의 방향)을 담는 식으로 했는데, 새로운 상어 좌표에서 큰 번호의 상어 좌표 위치는 알 수 있어도, 방향 정보를 기억하지 못하기에
    # 삭제하려면 상어 좌표 배열을 다 뒤져야하는 상황이 생기기 때문)
##################################################################
import sys
from collections import deque,defaultdict
input=sys.stdin.readline
N,M,k=map(int,input().split())
board=[]
# 배열에 대한 정보를 입력 받음
for i in range(N):
    board.append(list(map(int,input().split())))
    
# 배열을 하나 선언해서 방향 정보를 담음    
srk_way=list(map(int,input().split()))

# 상어의 방향에 따른 우선순위 방향을 담는 딕셔너리형 자료 선언(defaultdict)
srk_way_dic=defaultdict(list)
for i in range(M):
    for _ in range(4):
        srk_way_dic[i+1].append(list(map(int,input().split()))) #i+1이 상어의 번호임
dydx=[(-1,0),(1,0),(0,-1),(0,1)]

# 냄새에 대한 정보를 담을 3차원 배열을 선언 [0,0]에서 앞의 값은 해당 냄새의 주인인 상어의 번호, 뒤의 값은 남은 시간 값임
smell_board=[[[0,0] for j in range(N)] for i in range(N)]

# 냄새 배열을 업데이트 해주는 함수 선언
def update_smell_board():
    for i in range(N):
        for j in range(N):
            if smell_board[i][j][1]>0: # 냄새의 시간이 0보다 크면 -1씩 해줌
                smell_board[i][j][1]-=1
            if board[i][j]!=0: # 현재 상어의 위치에 해당하는 냄새 배열에 상어 번호와 k값을 넣어줌(상어가 이동하면 해당 위치에 이 값을 넣어야 하기 떄문)
                smell_board[i][j]=[board[i][j],k]
                
# 상어의 이동 함수 선언                
def sharks_move():
    new_board=[[0]*N for i in range(N)] # 임시 배열을 선언한다. 이유는 작은 상어가 큰 상어가 있는 곳에 들어갔을 때, 그것의 처리를 쉽게 하기 위함임
    for y in range(N):
        for x in range(N):
            if board[y][x]!=0:
                cur_dir=srk_way[board[y][x]-1]
                ways=srk_way_dic[board[y][x]][cur_dir-1]
                flag=False
                for w in ways:
                    dy,dx=dydx[w-1]
                    ny,nx=y+dy,x+dx
                    if 0<=ny<N and 0<=nx<N:
                        if smell_board[ny][nx][1]==0: # 냄새가 없는 빈 영역이면 이동
                            srk_way[board[y][x]-1]=w # 방향 배열에 현재 이동하는 방향의 정보로 최신화 시켜줌
                            if new_board[ny][nx]==0: # 아예 빈 영역이면 그냥 이동
                                new_board[ny][nx]=board[y][x]
                            else:
                                new_board[ny][nx]=min(new_board[ny][nx],board[y][x]) # 해당 위치에 상어가 이미 있다면, 작은 상어가 들어감
                            flag=True #냄새가 없는 빈 영역에 이동했다면 True로 바꿈
                            break
                if not flag: # 우선순위에 따른 4방향을 다 돌았는데 빈 영역이 없다면, 자기 자신의 냄새가 있는 곳으로 가야함
                    for w in ways:
                        dy,dx=dydx[w-1]
                        ny,nx=y+dy,x+dx
                        if 0<=ny<N and 0<=nx<N:
                            if smell_board[ny][nx][0]==board[y][x]:
                                srk_way[board[y][x]-1]=w
                                new_board[ny][nx]=board[y][x]
                                break
    return new_board
    
time=0
while True:
    update_smell_board()
    next_board=sharks_move()
    board=next_board
    time+=1
    check=True # 1번 상어만 남았는지 체크하기 위함
    for i in range(N):
        for j in range(N):
            if board[i][j]>1: # 1번보다 큰 번호를 가진 상어가 있다면 check를 False로 바꾸고 break
                check=False
                break
    if check: # 1밖에 안 남았다면 해당 time을 출력하고 break
        print(time)
        break
    if time>=1000: # 1000초 이상이면 -1을 출력하고 break
        print(-1)
        break
