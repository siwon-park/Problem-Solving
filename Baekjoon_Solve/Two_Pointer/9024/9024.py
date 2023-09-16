# 두 수의 합 (9024번)
import sys
input = sys.stdin.readline

t = int(input().rstrip())  # tc
for tc in range(t):
    n, k = map(int, input().rstrip().split())
    lst = list(map(int, input().rstrip().split()))
    lst.sort()
    s = 0
    e = n - 1
    diff = int(1e9)  # 두 수의 차이의 절댓값
    cnt = 0
    while s < e:
        _sum = lst[s] + lst[e]
        if abs(k - _sum) < diff:  # 합이 k와 가깝다 == 두 수의 차이의 절댓값이 0과 가깝다
            diff = abs(k - _sum)
            cnt = 1
        elif abs(k - _sum) == diff:
            cnt += 1
        if _sum > k:  # 두 수의 합이 k보다 크면 합을 줄여서 탐색
            e -= 1
        else:  # 두 수의 합이 k 이하면 합을 늘려서 탐색
            s += 1

    print(cnt)
