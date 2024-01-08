# 성적 통계 (5800번)
import sys
input = sys.stdin.readline

K = int(input().rstrip())
for k in range(1, K + 1):
    print(f"Class {k}")
    lst = list(map(int, input().rstrip().split()))
    N = lst[0]
    lst = lst[1:]
    _gap = 0
    lst.sort(reverse=True)
    for i in range(1, N):
        _gap = max(_gap, lst[i - 1] - lst[i])

    print(f"Max {lst[0]}, Min {lst[-1]}, Largest gap {_gap}")
