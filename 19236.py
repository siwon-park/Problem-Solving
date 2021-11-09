#청소년 상어(19236번)
#########################################################
    # 우선순위 큐, 백트랙킹 이용
    # 물고기들의 (물고기의 크기, 물고기의 방향, 물고기의 y좌표, 물고기의 x좌표)를 우선순위 큐에 담는 함수 선언
    # 물고기들을 움직이는 함수 선언(물고기를 잘 움직이게 하는 것이 이 문제의 핵심이다)
    # 이때, 주의해야할 점은 우선순위 큐에 들어가 있는 물고기의 좌표는 원본 좌표이기 때문에, 해당 좌표를 기준으로 물고기를 움직여서는 안 된다.
    # 어차피 물고기는 1번부터 움직이므로, 1번과 바꾸는 물고기의 번호는 무조건 1번보다 크다.
    # 즉, 서로 자리를 바꿨을 때, 바꾼 대상의 번호가 더 크면 큰 번호 물고기의 정보를 새로 우선순위 큐에 넣어준다.
    # 만약 중복된 숫자가 나온다 했을 때, 우선순위 큐에서 나온 y,x좌표에 해당하는 board[y][x]값이 해당 숫자가 맞으면 진행하고, 아닐경우 continue한다.
    # 그런데 여기서 두 숫자의 차이가 1이라서, 한쪽을 바꾼 다음 순서가 또 다른 한쪽이 되는 경우이면서 서로의 자리를 상호 교환(맞교환)하는 경우에 문제가 생긴다.
    # 예를 들어, 초기 위치가 3, 4였을 때: 1) 3번 차례 → 4, 3로 변경,  2) 4번 차례 → 3, 4가 됐는데, 우선 순위 큐에 4번의 정보가 원본 위치인 채로 들어있으니 또 바꿔버리는 경우가 생김
    # 즉, 우선순위 큐에서 뽑았을 때, 실제 해당하는 물고기 번호의 좌표값이 맞는지를 확인하는 절차와 바꾼 유/무를 체크하는 절차가 필요하다.
    # 그래서 check 배열을 선언해서 중복을 체크해주는 것이다.
    # 나머지는 그냥 백트랙킹 사용해서 풀면 된다. 사실 상어가 더 이상 움직일 수 없을 때 result배열에 먹은 물고기 번호의 합의 최댓값을 넣어야하지만,
    # 4X4배열에 경우의 수가 얼마 없기 때문에 그냥 넣어도 된다.
    # 반드시 유의할점!!! → 처음에 (0,0)에 있는 물고기를 바로 먹기 때문에 먹은 물고기 번호의 합의 시작은 0이 아니라 초기 board[0][0]값에서 시작한다
#########################################################
import sys,heapq,copy
input=sys.stdin.readline
board=[[] for i in range(4)]
dir_dic={1:(-1,0),2:(-1,-1),3:(0,-1),4:(1,-1),5:(1,0),6:(1,1),7:(0,1),8:(-1,1)}
for i in range(4):
    lst=list(map(int,input().split()))
    for j in range(0,7,2):
        board[i].append((lst[j],lst[j+1]))

def fish_queue(board):
    fq=[]
    for i in range(4):
        for j in range(4):
            if board[i][j][0]!=0 and board[i][j][0]!=-1:
                heapq.heappush(fq,(board[i][j][0],board[i][j][1],i,j))
    return fq

def fish_move(board,fq):
    check=[False]*17
    while fq:
        fish_no,way,y,x=heapq.heappop(fq)
        if board[y][x][0]!=fish_no:
            continue
        if check[fish_no]:
            continue
        i=0
        while i<=8:
            if way==9:
                way=1
            dy,dx=dir_dic[way]
            ny,nx=y+dy,x+dx
            if 0<=ny<4 and 0<=nx<4:
                if board[ny][nx][0]!=-1:
                    board[y][x]=(fish_no,way)
                    board[y][x],board[ny][nx]=board[ny][nx],board[y][x]
                    if board[y][x][0]>board[ny][nx][0]:
                        heapq.heappush(fq,(board[y][x][0],board[y][x][1],y,x))
                    check[fish_no]=True
                    break
            way+=1
            i+=1
first_fish=board[0][0][0]
board[0][0]=(-1,board[0][0][1])
result=[]

def dfs(board,sy,sx,cur_way,count):
    fq=fish_queue(board)
    fish_move(board,fq)
    dy,dx=dir_dic[cur_way]
    nsy,nsx=sy,sx
    result.append(count)
    for _ in range(4):
        nsy,nsx=nsy+dy,nsx+dx
        if 0<=nsy<4 and 0<=nsx<4:
            if board[nsy][nsx][0]!=0:
                tmp_board=copy.deepcopy(board)
                tmp_board[sy][sx],tmp_board[nsy][nsx]=(0,0),(-1,board[nsy][nsx][1])
                dfs(tmp_board,nsy,nsx,board[nsy][nsx][1],count+board[nsy][nsx][0])
                tmp_board[sy][sx],tmp_board[nsy][nsx]=board[sy][sx],board[nsy][nsx]
                
dfs(board,0,0,board[0][0][1],first_fish)
print(max(result))
