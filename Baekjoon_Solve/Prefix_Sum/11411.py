#  합 구하기 (11441번)
#############################################################################
    # 문제: https://www.acmicpc.net/problem/11441
    # 누적 합
    # 일반적인 1차원 배열 누적 합 문제
#############################################################################
import sys
input = sys.stdin.readline

N = int(input())
lst = [0] + list(map(int, input().split()))
for i in range(1, N + 1):
    lst[i] += lst[i - 1]

M = int(input())
for _ in range(M):
    i, j = map(int, input().split())
    print(lst[j] - lst[i - 1])
