# 가장 긴 증가하는 부분 수열 2 (12015번)
###################################################################################
    # 문제: https://www.acmicpc.net/problem/12015
    # 이분탐색, LIS
    # lower bound를 직접 구하는 방식으로 풀었다.
    # 다른 사람들 풀이를 보니까 확실히 bisect_left를 쓴 게 내 풀이보다 2 ~ 3배는 빨랐다.
    # 라이브러리가 빠르긴하지만, 내가 구현한 함수와 속도 차이가 많이 나는 것을 보아
    # 코드의 어딘가에 비효율이 있는 것 같다.
###################################################################################
import sys
input = sys.stdin.readline


def lower_bound(array, start, end, target):
    idx = 0
    while start <= end:
        mid = (start + end) // 2
        if target <= array[mid]:
            end = mid - 1
            idx = mid
        else:
            start = mid + 1
    return idx


N = int(input())
A = list(map(int, input().split()))

LIS = []
l = 0  # LIS의 길이
for a in A:
    if not LIS or LIS[-1] < a:
        LIS.append(a)
        l += 1
    else:
        i = lower_bound(LIS, 0, l - 1, a)
        LIS[i] = a

print(l)
