# 풍선 공장(15810번)
###############################################################
    # 문제: https://www.acmicpc.net/problem/15810
    # 이분탐색, 매개변수 탐색
    # e의 범위를 너무 크게 잡아버리면 시간초과가 난다.
    # 문제에서 주어진 M과 N의 max값에 따르면 e는 최대 int(1e12)가 되지만,
    # 사실 min(A) * M이 가장 최소 e다. 가장 빨리 풍선을 부는 사람이 M개의 풍선을 모두 다 부는 경우를 의미한다.
###############################################################
import sys
input = sys.stdin.readline

N, M = map(int, input().split())
A = list(map(int, input().split()))
s = min(A)
e = s * M
opt = 0
while s <= e:
    mid = (s + e) // 2
    cnt = 0  # 풍선의 개수
    flag = False
    for i in range(N):
        cnt += mid // A[i]
        if cnt >= M:
            flag = True
            break

    if flag:
        e = mid - 1
        opt = mid
    else:
        s = mid + 1

print(opt)
