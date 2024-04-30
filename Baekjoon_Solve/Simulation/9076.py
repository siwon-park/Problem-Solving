# 점수 집계 (9076번)
import sys
input = sys.stdin.readline

T = int(input().rstrip())
for _ in range(T):
    lst = list(map(int, input().rstrip().split()))
    lst.sort()
    total = sum(lst[1:4])
    if lst[3] - lst[1] >= 4:
        print("KIN")
    else:
        print(total)

