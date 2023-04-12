import sys
from bisect import bisect_left
input = sys.stdin.readline

A, B, C = map(int, input().split())

# 집합으로 요소를 받음
lst1 = list(set(map(int, input().split())))
lst2 = list(set(map(int, input().split())))
lst3 = list(set(map(int, input().split())))
A, B, C = len(lst1), len(lst2), len(lst3)

# 정렬
lst1.sort()
lst2.sort()
lst3.sort()

ans = int(1e9)
for i in range(A):
    a = lst1[i]

    # a와 절댓값 차이가 가장 작은 b를 찾음
    b_idx = bisect_left(lst2, a)
    b_idx = B - 1 if b_idx == B else b_idx
    b = lst2[b_idx]
    if b_idx - 1 >= 0:
        if abs(a - lst2[b_idx - 1]) < abs(a - b):
            b = lst2[b_idx - 1]

    # a와 b 중 절댓값 차이가 가장 작은 c를 찾음
    c_idx1 = bisect_left(lst3, a)
    c_idx2 = bisect_left(lst3, b)
    c_idx1 = C - 1 if c_idx1 == C else c_idx1
    c_idx2 = C - 1 if c_idx2 == C else c_idx2

    c1 = lst3[c_idx1]
    c2 = lst3[c_idx2]
    if c_idx1 - 1 >= 0:
        if abs(a - lst3[c_idx1 - 1]) < abs(a - c1):
            c1 = lst3[c_idx1 - 1]
    if c_idx2 - 1 >= 0:
        if abs(b - lst3[c_idx2 - 1]) < abs(b - c2):
            c2 = lst3[c_idx2 - 1]

    ret1 = abs(max(a, b, c1) - min(a, b, c1))
    ret2 = abs(max(a, b, c2) - min(a, b, c2))

    ans = min(ans, ret1, ret2)

print(ans)