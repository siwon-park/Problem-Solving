import sys, math

input = sys.stdin.readline

# 강의평 (34845번)
N, X = map(int, input().rstrip().split())
lst = list(map(int, input().rstrip().split()))
_sum = sum(lst)

ans = (X * N - _sum) / (100 - X)
if ans <= 0:
    print(0)
else:
    print(math.ceil(ans))

