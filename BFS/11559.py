#Puyo Puyo(11559번)
#####################################################
    # 문제: https://www.acmicpc.net/problem/11559
    # BFS, 구현, 시뮬레이션
    # 첫 시도에 시간초과가 떴으나 원인을 파악함 → 블럭이 다 안 없어지는 케이스가 있는데 그러한 케이스에서도 1연쇄가 있다고 코드를 짜서 무한 반복되는 문제가 발생했기 때문
    # 블럭을 내리는 함수와, 블럭을 4조각 이상 찾았을 경우 없애는 함수를 구현하는 것이 핵심
#####################################################
import sys
from collections import deque
input=sys.stdin.readline
board=[]
for i in range(12):
    board.append(list(input().rstrip()))
dydx=[(-1,0),(0,1),(1,0),(0,-1)]

def down_puyo(): # 블럭들을 내리는 함수
    for i in range(10,-1,-1):
        for j in range(6):
            if board[i][j]!=".":
                ni=i
                while board[ni+1][j]==".":
                    ni+=1
                    if ni==11:
                        break
                if board[ni][j]==".":
                    board[ni][j],board[i][j]=board[i][j],board[ni][j]        

def find_puyo(puyo,q,visited): # 인접한 동일 블럭 조각을 찾았을 때 제거하는 함수
    fin_que=deque()
    p_cnt=1
    while q:
        y,x=q.popleft()
        fin_que.append((y,x))
        for dy,dx in dydx:
            ny,nx=y+dy,x+dx
            if 0<=ny<12 and 0<=nx<6:
                if board[ny][nx]==puyo:
                    if not visited[ny][nx]:
                        visited[ny][nx]=True
                        q.append((ny,nx))
                        p_cnt+=1
    if p_cnt>=4:
        while fin_que:
            y,x=fin_que.popleft()
            board[y][x]="."
        return True # 인접한 동일 블럭 조각을 4개 이상 제거했으면 True 반환
    return False # 아닐 경우 False       

def find_max_concat():
    max_concat=0
    while True:
        visited=[[False]*6 for _ in range(12)]
        deleted=False
        for i in range(11,-1,-1):
            for j in range(6):
                if board[i][j]!=".":
                    if not visited[i][j]:
                        q=deque([(i,j)])
                        visited[i][j]=True
                        flag=find_puyo(board[i][j],q,visited) # 여기서 처음에 바로 아랫줄에 concat=1이라 하고 for문 밖에다 if concat==1: max_concat+=1을 했음(무한루프 발생)
                        if flag: # flag==True. 즉 1번이라도 인접한 동일 블럭을 4조각 이상 제거했다면 deleted=True가 되어 체크
                            deleted=True
        if deleted: # 동일 블럭 4조각 이상을 1세트 이상 제거했다면 이번 회차에 연쇄+1을 해주고 블럭을 내림
            max_concat+=1
            down_puyo()
        else: # 한번이라도 제거 한 것이 없으면 현재의 max_concat을 반환
            return max_concat

print(find_max_concat())
