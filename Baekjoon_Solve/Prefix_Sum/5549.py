# 행성 탐사 (5549번)
#################################################################################   
    # 문제: https://www.acmicpc.net/problem/5549
    # 누적합
    # '직사각형과 쿼리'라는 문제와 동일하게 3차원의 배열을 선언해서 해당하는 영역이 몇 개 나왔는지 누적하여
    # 구간에 대한 영역별 누적합을 출력하면 된다.
#################################################################################
import sys
input = sys.stdin.readline

M, N = map(int, input().split())
K = int(input())
MAP = [list(input().rstrip()) for _ in range(M)]

prefix_sum = [[[0, 0, 0] for _ in range(N + 1)] for _ in range(M + 1)]
for i in range(1, M + 1):
    for j in range(1, N + 1):
        for k in range(3):
            prefix_sum[i][j][k] = prefix_sum[i - 1][j][k] + prefix_sum[i][j - 1][k] - prefix_sum[i - 1][j - 1][k]
        if MAP[i - 1][j - 1] == "J":
            prefix_sum[i][j][0] += 1
        elif MAP[i - 1][j - 1] == "O":
            prefix_sum[i][j][1] += 1
        elif MAP[i - 1][j - 1] == "I":
            prefix_sum[i][j][2] += 1

for _ in range(K):
    a, b, c, d = map(int, input().split())
    ret = [0, 0, 0]
    for k in range(3):
        ret[k] = prefix_sum[c][d][k] - prefix_sum[a - 1][d][k] - prefix_sum[c][b - 1][k] + prefix_sum[a - 1][b - 1][k]
    print(*ret)
    
