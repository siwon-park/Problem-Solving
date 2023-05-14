import sys
# 제자리 멀리뛰기 (6209번)
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