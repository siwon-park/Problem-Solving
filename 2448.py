# 별 찍기 - 11(2448번)
###########################################################################
    # 문제: https://www.acmicpc.net/problem/2448
    # 재귀
    # 역시 재귀는 어렵다. 규칙성을 찾는데 굉장히 오랜 시간이 걸린다.
    # 계속 연습해서 익숙해져야겠다.
    # 재귀 문제였지만, 분할정복에 더 가까운 것 같다.
###########################################################################
import sys
sys.setrecursionlimit(int(1e5))
input = sys.stdin.readline

N = int(input())
board = [[" "] * (2*N - 1) for _ in range(N)]

def recur(n, r, c):
    if n == 3:
        board[r][c] = "*"
        board[r + 1][c - 1] = "*"
        board[r + 1][c + 1] = "*"
        board[r + 2][c - 2] = "*"
        board[r + 2][c - 1] = "*"
        board[r + 2][c] = "*"
        board[r + 2][c + 1] = "*"
        board[r + 2][c + 2] = "*"
        return
    else:
        recur(n//2, r, c)
        recur(n//2, r + n//2, c - n//2)
        recur(n//2, r + n//2, c + n//2)

recur(N, 0, N-1)

for lst in board:
    print("".join(lst))
