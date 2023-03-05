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