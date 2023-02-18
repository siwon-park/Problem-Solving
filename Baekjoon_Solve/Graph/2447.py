# 별 찍기 - 10(2447번)
####################################################################################
    # 문제: https://www.acmicpc.net/problem/2447
    # 재귀, 분할정복
    # 재귀호출과 분할정복에 익숙해지려고 이 문제를 풀었다.
    # 단순히 재귀호출하라고 하면 좀 생각해서 풀 수 있었을 것 같은데, 분할정복으로 풀고 싶어서
    # 다른 사람의 풀이를 조금 참고하였다.
####################################################################################
import sys
sys.setrecursionlimit(int(1e5))
input = sys.stdin.readline

N = int(input())
board = [[" "] * N for _ in range(N)]

# 영역을 분할하여 가운데는 채우지 않음(r + nxt_size, c + nxt_size)
def recur(size, r, c):
    if size == 1:
        board[r][c] = "*"
        return
    nxt_size = size // 3
    recur(nxt_size, r, c)
    recur(nxt_size, r + nxt_size, c)
    recur(nxt_size, r + nxt_size*2, c)
    recur(nxt_size, r, c + nxt_size)
    recur(nxt_size, r, c + nxt_size*2)
    recur(nxt_size, r + nxt_size, c + nxt_size*2)
    recur(nxt_size, r + nxt_size*2, c + nxt_size)
    recur(nxt_size, r + nxt_size*2, c + nxt_size*2)

recur(N, 0, 0)

for lst in board:
    print("".join(lst))
