# 이건 꼭 풀어야 해! (17390번)
##############################################################################
    # 문제: https://www.acmicpc.net/problem/17390
    # 누적합
    # 정렬한 다음 누적합 배열을 구하고, 주어지는 쿼리에 대한 구간 합을 계산하여 출력하면 된다.
##############################################################################
import sys
input = sys.stdin.readline

N, Q = map(int, input().split())
A = list(map(int, input().split()))
A.sort()

prefix_sum = [0] * (N + 1)

for i in range(1, N + 1):
    prefix_sum[i] = prefix_sum[i - 1] + A[i - 1]

for _ in range(Q):
    L, R = map(int, input().split())
    print(prefix_sum[R] - prefix_sum[L - 1])
