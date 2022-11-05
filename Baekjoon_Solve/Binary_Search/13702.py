# 이상한 술집 (13702번)
###############################################################################
    # 문제: https://www.acmicpc.net/problem/13702
    # 이분 탐색, 매개변수 탐색
    # 일반적인 유형의 매개변수 탐색 문제이다.
###############################################################################
import sys
input = sys.stdin.readline

N, K = map(int, input().split())
maks = [int(input()) for _ in range(N)]
s = 0
e = 2**31 - 1
opt = 0
while s <= e:
    mid = (s + e) // 2
    cnt = 0
    for i in range(N):
        cnt += maks[i] // mid

    if cnt >= K:
        opt = mid
        s = mid + 1
    else:
        e = mid - 1

print(opt)
