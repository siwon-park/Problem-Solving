# 주지수 (15724번)
"""
    문제: https://www.acmicpc.net/problem/15724
    누적합
    2차원의 배열 누적합을 구하는 문제
"""
import sys
input = sys.stdin.readline

N, M = map(int, input().split())
arr = []
for _ in range(N):
    arr.append(list(map(int, input().split())))

memo = [[0 for _ in range(M + 1)] for _ in range(N + 1)]
for i in range(1, N + 1):
    for j in range(1, M + 1):
        memo[i][j] = memo[i - 1][j] + memo[i][j - 1] - memo[i - 1][j - 1] + arr[i - 1][j - 1]

K = int(input())
for _ in range(K):
    y1, x1, y2, x2 = map(int, input().split())
    ans = memo[y2][x2] - memo[y1 - 1][x2] - memo[y2][x1 - 1] + memo[y1 - 1][x1 - 1]
    print(ans)
