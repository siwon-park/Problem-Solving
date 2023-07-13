# 게임 (1072번)
import sys
input = sys.stdin.readline


def binary_search(n: int, m: int, t: int) -> int:
    s = 1
    e = n
    ans = -1
    while s <= e:
        mid = (s + e) // 2
        if ((m + mid) * 100) // (n + mid) > t:  # 타겟값보다 작다면 mid를 줄임
            e = mid - 1
            ans = mid
        else:
            s = mid + 1
    return ans


x, y = map(int, input().rstrip().split())
print(binary_search(x, y, (y * 100) // x))