# 달이 차오른다, 가자(1194번)
#########################################################
    # 문제: https://www.acmicpc.net/problem/1194
    # BFS, 비트마스킹
    # 문제가 너무 안 풀려서 보니까 갖고 있는 전체 열쇠의 상태를 고려하는 문제였다.
    # 열쇠는 총 6종류이므로 갖고 있는 열쇠의 상태(조합)은 총 64개(1<<6)개가 나온다.
    # 현재 갖고 있는 열쇠 상태에 따라 비트연산을 하여 BFS탐색을 실시하면 된다.
    # 열쇠 상태는 000000 ~ 111111이며, 0은 갖고있지 않음을, 1은 갖고 있음을 의미함
#########################################################
import sys
from collections import deque
input = sys.stdin.readline

N, M = map(int, input().split())
board = []
dydx = [(-1, 0), (0, 1), (1, 0), (0, -1)]
q = deque()
INF = sys.maxsize
visited = [[[INF]*(1<<6) for j in range(M)] for i in range(N)]
for i in range(N):
    board.append(list(input().rstrip()))
    for j in range(M):
        if board[i][j] == "0":
            q.append((0, 0, i, j))
            board[i][j] = "."
            visited[i][j][0] = 0

def bfs(q):
    while q:
        d, k, y, x= q.popleft()
        for dy, dx in dydx:
            ny, nx = y+dy, x+dx
            if 0 <= ny < N and 0 <= nx < M and board[ny][nx] != "#":
                if board[ny][nx] == "1":
                    return d+1
                elif board[ny][nx] == ".":
                    if d+1 < visited[ny][nx][k]:
                        visited[ny][nx][k] = d+1
                        q.append((d+1, k, ny, nx))
                elif "a" <= board[ny][nx] <= "f":
                    new_key = k|(1<<(ord(board[ny][nx]))-ord("a")) # 1을 왼쪽 시프트 연산하여(0 ~ 5만큼) 비교함 (000001, 000010, 000100, 001000, 010000, 100000)
                    # 만약 자릿수 중 둘 중 하나가 1이면 새로운 키가 나오는 것임
                    if d+1 < visited[ny][nx][new_key]:
                        visited[ny][nx][new_key] = d+1
                        q.append((d+1, new_key, ny, nx))
                elif "A" <= board[ny][nx] <= "F":
                    if k & (1<<(ord(board[ny][nx])-ord("A"))): # 1을 왼쪽 시프트 연산하여(0 ~ 5만큼) 자릿수 비교, 전부 불일치일 경우 0이므로 False임  
                        if d+1 < visited[ny][nx][k]:
                            visited[ny][nx][k] = d+1
                            q.append((d+1, k, ny, nx))
    return -1            
print(bfs(q))
