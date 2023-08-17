# 꼬인 전깃줄 (1365번)
import sys
input = sys.stdin.readline


def binary_search(lst: list, target: int) -> int:
    s = 0
    e = len(lst)
    _idx = e + 1
    while s <= e:
        mid = (s + e) // 2
        if lst[mid] > target:
            e = mid - 1
            _idx = mid
        else:
            s = mid + 1
    return _idx


N = int(input().rstrip())
arr = list(map(int, input().rstrip().split()))

lis = [arr[0]]
cnt = 0  # LIS를 만들기 위해 교체한 수의 개수
for i in range(1, N):
    num = arr[i]
    if lis[-1] < num:  # lis의 마지막 요소보다 현재 숫자가 크면 뒤에 붙임
        lis.append(num)
    else:
        idx = binary_search(lis, num)
        lis[idx] = num
        cnt += 1

print(cnt)
