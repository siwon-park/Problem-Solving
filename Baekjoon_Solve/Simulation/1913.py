# 달팽이(1913번)
########################################################
    # 문제: https://www.acmicpc.net/problem/1913
    # 구현
    # 달팽이 배열을 만들기 위해 델타값(dy,dx)를 활용해서 다음 위치가 범위를 벗어나는 경우에 방향을 회전하는 방식으로 구현함
    # num이 1일 경우에 처리를 해줘야 했던 예외가 있었음
########################################################
import sys
input = sys.stdin.readline

N = int(input())
num = int(input())
dydx = [(1,0), (0,1), (-1,0), (0,-1)]
n = N*N
y, x = 0, 0
board = [[0]*N for i in range(N)]
board[y][x] = n
if n == num:
    ans = 1,1
n -= 1
k = 0
while n > 0:
    dy, dx = dydx[k]
    ny, nx = y+dy, x+dx
    if 0 <= ny < N and 0 <= nx < N and board[ny][nx] == 0:
        board[ny][nx] = n
        if n == num:
            ans = ny+1, nx+1  
        n -= 1
        y, x = ny, nx
    elif ny < 0 or ny >= N or nx < 0 or nx >= N or board[ny][nx] != 0:
        k += 1
        if k == 4:
            k = 0
for lst in board:
    print(*lst)
print(*ans)
