#스타트 택시(19238번)
########################################################
    # BFS 너비우선탐색 사용
    # 어려운 난이도의 문제는 아니었지만, 고려해야할 예외 사항(승객들의 목적지가 다 같거나, 출발위치==승객위치이거나 등등..)들이 많아서 시간을 많이 잡아 먹었음
    # 승객의 좌표와 도착지를 입력 받을 때, 2차원의 배열을 하나 따로 생성해서 해당 승객의 좌표에 해당하는 인덱스 값에 도착지 값을 넣어줬고, 승객 위치만 따로 승객큐(cq)에 담음
    # 승객을 찾는 find_customer함수 선언
    # 방문을 체크하는 visited배열과 거리를 마킹하는 used배열을 만듦(초기값은 무한의 값인 INF선언).
    # q값에 거리를 넣어도 되지만, used배열을 만드는 이유는 승객은 남았는데 해당 승객들에게 도달하지 못하는 경우를 고려하기 위해서임
    # find_customer함수에서 BFS 탐색을 끝낸 후, 승객의 좌표를 담은 cq배열에 대해 해당 승객의 좌표에 해당하는 used 배열의 값이 INF(무한)이 아닐 경우에만 최종 후보 리스트에 삽입
    # 최종 후보 리스트를 거리값, 열, 행 기준으로 우선순위 정렬 실시하고 반환
    # 승객을 목적지까지 데려다 주는 take_away함수 선언
    # BFS탐색을 통해 목적지까지 데려다 줄 수 있으면 해당 목적지 위치 값과 거리값을 반환함. 그렇지 않을 경우, 마지막 위치 값과 50만을 반환하게 한다
    # 50만을 반환하는 이유는 도달하지 못하니까 바로 남은 연료 값을 음수로 만들기 위함임
    # F(연료)가 0이상인 동안 while 구문을 반복함
    # 최종 후보 리스트에는 아무것도 안 담기는데, 아직 잔여 승객이 남았다면 -1 출력하고, 그게 아니라면 현재 연료 F를 출력하고 break
    # 가장 우선순위에 있는 승객을 태우러 갔는데 F가 0보다 작으면 -1출력하고 break
    # 연료가 남았다면 승객을 태운 뒤 해당 승객의 목적지까지 데려다 주고, 사용한 연료 값 만큼 빼주는데, 0보다 작아지면 -1을 출력하고 break
    # 다 데려다줬는데 0 이상이면 데려다 주는데 사용한 연료량x2만큼 더 해주고 시작 위치를 현재 위치로 하고 루프를 반복
########################################################
import sys
from collections import deque
input=sys.stdin.readline
N,M,F=map(int,input().split())
dydx=[(-1,0),(0,1),(1,0),(0,-1)]
board=[]
for i in range(N):
    board.append(list(map(int,input().split())))
sy,sx=map(int,input().split())
sy,sx=sy-1,sx-1
c_board=[[(-1,-1) for i in range(N)] for i in range(N)]
cq=[]
for i in range(M):
    cy,cx,ty,tx=map(int,input().split())
    c_board[cy-1][cx-1]=(ty-1,tx-1)
    cq.append((cy-1,cx-1))
INF=int(1e9)

def find_customer(si,sj,cq):
    c_lst=[]
    q=deque([(si,sj,0)])
    visited=[[False]*N for i in range(N)]
    used=[[INF]*N for i in range(N)]
    used[si][sj]=0
    visited[si][sj]=True
    while q:
        y,x,dist=q.popleft()
        for dy,dx in dydx:
            ny,nx=y+dy,x+dx
            if 0<=ny<N and 0<=nx<N:
                if board[ny][nx]==0:
                    if not visited[ny][nx]:
                        q.append((ny,nx,dist+1))
                        visited[ny][nx]=True
                        used[ny][nx]=used[y][x]+1
    for cy,cx in cq:
        if used[cy][cx]!=INF:
            c_lst.append((cy,cx,used[cy][cx]))
    c_lst.sort(key=lambda x:(x[2],x[0],x[1]))
    return c_lst

def take_away(si,sj,ty,tx):
    q=deque([(si,sj,0)])
    visited=[[False]*N for i in range(N)]
    visited[si][sj]=True
    while q:
        y,x,dist=q.popleft()
        if (y,x)==(ty,tx):
            cq.remove((si,sj))
            return y,x,dist
        for dy,dx in dydx:
            ny,nx=y+dy,x+dx
            if 0<=ny<N and 0<=nx<N:
                if board[ny][nx]==0:
                    if not visited[ny][nx]:
                        q.append((ny,nx,dist+1))
                        visited[ny][nx]=True
    return y,x,500000

while F>=0:
    clst=find_customer(sy,sx,cq)
    if not clst:
        if cq:
            print(-1)
        else:
            print(F)
        break
    cy,cx,used1=clst[0]
    F-=used1
    if F<0:
        print(-1)
        break
    ty,tx=c_board[cy][cx]
    ay,ax,used2=take_away(cy,cx,ty,tx)
    F-=used2
    if F<0:
        print(-1)
        break
    F+=used2*2
    sy,sx=ay,ax
