import sys
input = sys.stdin.readline

N = int(input())
arr = list(map(int, input().split()))


def find_next_permute():
    idx = -1
    for i in range(N - 1, 0, -1):
        if arr[i] > arr[i - 1]:
            idx = i - 1
            break
    if idx == -1:
        return [-1]
    lst1 = arr[:idx]
    lst2 = arr[idx + 1:]
    num = arr[idx]
    _min = 10001
    midx = 0
    for j in range(len(lst2) - 1, -1, -1):
        if _min > lst2[j] > num:
            _min = lst2[j]
            midx = j
    num, lst2[midx] = lst2[midx], num
    lst2.sort()
    return lst1 + [num] + lst2


print(*find_next_permute())