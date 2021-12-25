#알파벳(1987번)
##########################################
    # 문제: https://www.acmicpc.net/problem/1987
    # DFS(깊이 우선 탐색)
    # 문자를 숫자로 변환하여 해당 숫자 값을 visited 배열의 인덱스로 사용함
    # 질문게시판을 보면서 새롭게 안 사실: list와 dic의 탐색에서 dic 탐색의 최악의 경우는 O(n)이 걸릴 수도 있음
    # list의 원소의 삽입 삭제는 O(n)이 맞지만 탐색/값 변경은 O(1)이고, 파이썬 딕셔너리는 hashmap 기반이고, 시간복잡도는 Best O(1), Worst O(n)임
##########################################
import sys
input=sys.stdin.readline
R,C=map(int,input().split())
board=[]
for i in range(R):
    board.append(list(input().rstrip()))
dydx=[(-1,0),(0,1),(1,0),(0,-1)]
visited=[False]*26
def char_to_num(i,j):
    return ord(board[i][j])-ord('A')	
visited[char_to_num(0,0)]=True
result=0
def dfs(y,x,cnt):
    global result
    for dy,dx in dydx:
        ny,nx=y+dy,x+dx
        if 0<=ny<R and 0<=nx<C:
            if not visited[char_to_num(ny,nx)]:
                visited[char_to_num(ny,nx)]=True
                dfs(ny,nx,cnt+1)
                visited[char_to_num(ny,nx)]=False
            else:
                if cnt>result:
                    result=cnt     
dfs(0,0,1)
print(result)            
