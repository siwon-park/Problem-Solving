import sys
input = sys.stdin.readline

N = int(input().rstrip())
P = list(map(int, input().rstrip().split()))


def binary_search(p: list, n: int) -> int:
    s, e = 1, sum(p)
    ans = 1
    while s <= e:
        mid = (s + e) // 2
        c = 0
        total = mid
        flag = True

        for i in range(n):
            if total + (c // 10) < p[i]:
                flag = False
                break
            if total >= p[i]:
                total -= p[i]
                c += p[i]
            else:
                c -= (p[i] - total) * 10
                c += total
                total = 0

        if flag:
            e = mid - 1
            ans = mid
        else:
            s = mid + 1

    return ans


print(binary_search(P, N))