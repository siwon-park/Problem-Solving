# 징검다리 (11561번)
##############################################################################
    # 문제: https://www.acmicpc.net/problem/11561
    # 이분탐색
    # 규칙을 지키면서 밟을 수 있는 징검다리 수의 최대를 구하는 문제
    # 1번 규칙에 의해 첫번째 점프는 원하는 만큼 건너 뛰고, 그 다음부터는 이전 점프에서 + 1씩 증가시킨 점프를 뛰어야한다.
    # mid 값을 마지막으로 점프한 칸 수라고 할 때, 최대한 밟을 수 있는 징검다리 수는 1칸씩 증가하는 등차 수열의 합으로
    # 1칸 + 2칸 + 3칸 + ... + mid칸이다. 즉, 이는 mid(mid + 1) / 2 로, 해당 값이 N보다 작거나 같은 mid를 구하면 된다.
##############################################################################
import sys
input = sys.stdin.readline


def binary_search(N):
    opt = 0
    s, e = 1, N
    while s <= e:
        mid = (s + e) // 2
        ret = (mid * (mid + 1)) / 2
        if ret <= N:
            s = mid + 1
            opt = mid
        else:
            e = mid - 1
    return opt


T = int(input().rstrip())
for tc in range(T):
    N = int(input().rstrip())
    print(binary_search(N))
