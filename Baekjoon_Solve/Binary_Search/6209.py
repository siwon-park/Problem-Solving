# 제자리 멀리뛰기 (6209번)
####################################################################
    # 문제: https://www.acmicpc.net/problem/6209
    # 이분탐색, 매개변수 탐색
    # 케이크 자르기(17179번)와 비슷한 유형의 문제
    # cnt가 n - m보다 클 때 s의 값을 증가시켜서 mid 값을 늘려서 탐색하는데
    # n - m 이상이 아니고, n - m보다 커야하는 이유는 lst의 마지막에 d를 요소로 추가했기 때문이다.
    # 즉, 따라서 n개의 주어진 돌 + d(1)에서 m개의 돌을 제거하고 나면 그 수는 n + 1 - m 이다.
    # for 구문을 반복하면서 현재위치 - 마지막 위치의 값이 찾고자하는 점프 길이 이상일 경우에만 cnt += 1을 하여
    # 해당 cnt가 n + 1 - m 이상, 또는 n - m보다 클 경우에 구간을 수정하여 탐색하면 된다.
####################################################################
import sys
input = sys.stdin.readline

d, n, m = map(int, input().split())
lst = [int(input().rstrip()) for _ in range(n)] + [d]
s = 1
e = max(lst)

lst.sort()

jump = 0
while s <= e:
    mid = (s + e) // 2
    cnt = 0
    last = 0  # 현재 위치
    for i in range(n + 1):
        if lst[i] - last >= mid:
            cnt += 1
            last = lst[i]

    if cnt > n - m:
        s = mid + 1
        jump = mid
    else:
        e = mid - 1

print(jump)
