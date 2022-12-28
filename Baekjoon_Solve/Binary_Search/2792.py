# 보석 상자 (2792번)
"""
    문제: https://www.acmicpc.net/problem/2792
    이분탐색, 매개변수 탐색
    평범한 매개변수 탐색 문제로, 각 학생별로 같은 색의 보석만 가지게 하기 위해서는
    주어지는 각 보석의 개수를 이분탐색을 통해 찾고자 하는 값으로 나눈 값을 올림하면 된다.
    최솟값을 찾아야하므로, 올림한 값을 더했을 때 N보다 작거나 같으면 e를 줄여서 cnt를 늘린다.(나누는 값이 작아지므로 cnt가 커진다.)
    cnt는 최대 N까지 증가하게 되고, 이 때의 나누는 값이 질투심의 최솟값이다.
"""
import sys, math
input = sys.stdin.readline


def binary_search(lst: list, n: int, m: int) -> int:
    opt = 0
    s, e = 1, max(lst)
    while s <= e:
        mid = (s + e) // 2
        cnt = 0
        for i in range(m):
            cnt += math.ceil(lst[i] / mid)
        if cnt <= n:
            e = mid - 1
            opt = mid
        else:
            s = mid + 1
    return opt


N, M = map(int, input().rstrip().split())
arr = [int(input().rstrip()) for _ in range(M)]

ans = binary_search(arr, N, M)
print(ans)
