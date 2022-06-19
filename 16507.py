# 어두운 건 무서워(16507번)
#######################################################################################################
    # 문제: https://www.acmicpc.net/problem/16507
    # 누적합
    # 2차원의 배열 누적합 문제이다. 지난 번에 2차원의 배열에서 누적합에 따른 구간합을 구하는 원리를 배운 뒤에 풀어서 쉽게 풀 수 있었다.
    # 누적합 계산을 용이하게 하기 위해 격자판의 0행과 0열은 모두 0으로 초기화시켜주었다.
    # 게다가 문제에서 주어지는 쿼리 값(r1, c1, r2, c2)이 0행과 0열을 염두해둔 것처럼 행렬 인덱스 값 + 1씩 주어졌기 때문에
    # 주어진 값을 그대로 사용해서 풀면 된다.
    # 2차원의 격자판에서 누적합을 구하는 공식은 board[r][c] = board[r-1][c] + board[r][c-1] - board[r-1][c-1] + board[r][c] 이다.
    # 그리고 구간합을 구하는 공식은 board[r2][c2] - board[r2][c1-1] - board[r1-1][c2] + board[r1-1][c1-1]으로 사용했는데
    # 아마 r1, c1의 포함여부에 따라 -1을 해줘야할 수도 안 해줘야할 수도 있다.
#######################################################################################################
import sys
input = sys.stdin.readline

R, C, Q = map(int, input().split())
board = [[0] * (C + 1)]
for _ in range(R):
    board.append([0] + list(map(int, input().split())))
queries = [list(map(int, input().split())) for _ in range(Q)]

for r in range(1, R + 1):
    for c in range(1, C + 1):
        board[r][c] = board[r-1][c] + board[r][c-1] - board[r-1][c-1] + board[r][c]

for query in queries:
    r1, c1, r2, c2 = query
    prefix_sum = board[r2][c2] - board[r2][c1-1] - board[r1-1][c2] + board[r1-1][c1-1]
    total = (r2 - r1 + 1) * (c2 - c1 + 1)
    avg = prefix_sum // total
    print(avg)
