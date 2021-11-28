#다리 만들기(2146번)
##################################################
    # 문제: https://www.acmicpc.net/problem/2146
    # BFS 너비 우선 탐색 이용, 6684ms 소모 -> 코드 개선 필요
    # 각 섬의 번호를 매긴 뒤에 각 섬의 가장자리 좌표만 담아서, 가장 자리 좌표에서 출발해서 번호가 다른 섬으로 갈 수 있는 최소 거리를 구했음
##################################################
import sys
from collections import deque
input=sys.stdin.readline
N=int(input())
board=[]
dydx=[(-1,0),(0,1),(1,0),(0,-1)]
for i in range(N):
    board.append(list(map(int,input().split())))
# 각 섬의 번호를 매기는 함수    
def marking():
    isl_no=1
    borders=set() # 각 섬별로 가장자리의 좌표를 담기 위한 빈 집합 선언
    check=[[False]*N for i in range(N)]
    for i in range(N):
        for j in range(N):
            if not check[i][j]:
                if board[i][j]==1:
                    check[i][j]=True
                    q=deque([(i,j)])
                    board[i][j]=isl_no
                    while q:
                        y,x=q.popleft()
                        for dy,dx in dydx:
                            ny,nx=y+dy,x+dx
                            if 0<=ny<N and 0<=nx<N:
                                if board[ny][nx]==1:
                                    if not check[ny][nx]:
                                        check[ny][nx]=True
                                        q.append((ny,nx))
                                        board[ny][nx]=isl_no
                                elif board[ny][nx]==0: # 상하좌우 이동한 좌표가 0이면 가장자리에 있다는 의미이므로 집합에 담는다
                                    borders.add((y,x))
                    isl_no+=1
    return borders
brds=marking()
# 각 섬의 가장자리 좌표에서 다른 섬으로 가는 다리의 길이 리스트를 반환하는 함수
def build_bridge(borders):
    bridges=[]
    for i,j in borders:
        visited=[[False]*N for i in range(N)]
        q=deque([(i,j,0)])
        visited[i][j]=True
        cur_zone=board[i][j] # 현재 섬의 번호
        while q:
            y,x,b=q.popleft()
            for dy,dx in dydx:
                ny,nx=y+dy,x+dx
                if 0<=ny<N and 0<=nx<N:
                    if board[ny][nx]==0:
                        if not visited[ny][nx]:
                            q.append((ny,nx,b+1))
                            visited[ny][nx]=True
                    elif board[ny][nx]!=0 and board[ny][nx]!=cur_zone: # 상하좌우 이동한 좌표가 0도 아니고 현재 섬의 번호와 다르면 다른 섬에 도착한 것임
                        bridges.append(b) # 여기서 b+1을 하면 안 됨. board[ny][nx]==0인 경우에만 다리를 놓는 개념이므로, 다리의 길이는 b임
                        break # 다른 섬에 도착했다면 break를 함. (i,j)에서 출발했을 때, 가장 짧은 다리 길이이므로
    return bridges
brdgs=build_bridge(brds)
print(min(brdgs))
