# 인기도 조사 (2835번)
import sys
input = sys.stdin.readline


def time_convert(time: str) -> int:
    hh, mm, ss = map(int, time.split(':'))
    return hh * 60 * 60 + mm * 60 + ss


def lazy_propagation(s: int, e: int, n: int) -> None:
    if lazy[n] != 0:
        tree[n] += (e - s + 1) * lazy[n]
        if s != e:
            lazy[n * 2] += lazy[n]
            lazy[n * 2 + 1] += lazy[n]
        lazy[n] = 0


def update(s: int, e: int, n: int, l: int, r: int) -> None:
    lazy_propagation(s, e, n)
    if r < s or e < l:
        return
    if l <= s and e <= r:
        lazy[n] += 1
        lazy_propagation(s, e, n)
        return
    mid = (s + e) // 2
    update(s, mid, n * 2, l, r)
    update(mid + 1, e, n * 2 + 1, l, r)
    tree[n] = tree[n * 2] + tree[n * 2 + 1]


def count(s: int, e: int, n: int, l: int, r: int):
    lazy_propagation(s, e, n)
    if r < s or e < l:
        return 0
    if l <= s and e <= r:
        return tree[n]
    mid = (s + e) // 2
    return count(s, mid, n * 2, l, r) + count(mid + 1, e, n * 2 + 1, l, r)


MAX = 24 * 60 * 60
tree = [0] * (MAX * 4)
lazy = [0] * (MAX * 4)

N = int(input())
for _ in range(N):
    start, _, end = input().split()
    start = time_convert(start)
    end = time_convert(end)

    if start <= end:
        update(1, MAX, 1, start + 1, end + 1)
    else:
        update(1, MAX, 1, start + 1, MAX)
        update(1, MAX, 1, 1, end + 1)

Q = int(input())
for _ in range(Q):
    start, _, end = input().split()
    start = time_convert(start)
    end = time_convert(end)
    range_val = end - start + 1
    ret = 0
    if start <= end:
        ret += count(1, MAX, 1, start + 1, end + 1)
    else:
        ret += count(1, MAX, 1, start + 1, MAX)
        ret += count(1, MAX, 1, 1, end + 1)
        range_val += MAX
    print(f"{ret / range_val:.10f}")