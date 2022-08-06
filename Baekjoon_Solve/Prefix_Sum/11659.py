# 구간 합 구하기 4(11659번)
###################################################################
    # 문제: https://www.acmicpc.net/problem/11659
    # 구간 합, 누적 합
    # 누적 합을 구한 다음에 A, B 구간을 입력 받았을 때, 구간의 B - A-1을 하면 된다.
###################################################################
import sys
input = sys.stdin.readline

N, M = map(int, input().split())
lst = list(map(int, input().split()))
prefix_sum = [0] * (N+1)
for i in range(1, N+1):
    prefix_sum[i] = prefix_sum[i-1] + lst[i-1]

for _ in range(M):
    A, B = map(int, input().split())
    print(prefix_sum[B] - prefix_sum[A-1])
