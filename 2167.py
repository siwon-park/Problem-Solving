# 2차원 배열의 합(2167번)
########################################################################################
    # 문제: https://www.acmicpc.net/problem/2167
    # 누적합
    # 일반적인 2차원 누적 배열 합을 구하는 문제이다
    # 실버라고 예상하고 풀었는데 브론즈 1이어서 조금 의외였다
########################################################################################
import sys
input = sys.stdin.readline

N, M = map(int, input().split())
board = [list(map(int, input().split())) for _ in range(N)]
K = int(input())
queries = [tuple(map(int, input().split())) for _ in range(K)]

pre_sum = [[0 for _ in range(M + 1)] for _ in range(N + 1)]

for r in range(1, N + 1):
    for c in range(1, M + 1):
        pre_sum[r][c] = pre_sum[r - 1][c] + pre_sum[r][c - 1] + board[r - 1][c - 1] - pre_sum[r - 1][c - 1]

for i, j, x, y in queries:
    total_sum = pre_sum[x][y] - pre_sum[x][j - 1] - pre_sum[i - 1][y] + pre_sum[i - 1][j - 1]
    print(total_sum)
