import sys

input = sys.stdin.readline

# Abby's Absolutes  (34308번)
N, K = map(int, input().rstrip().split())
lst = list(map(int, input().rstrip().split()))
ret = []
for i in range(K):
    num = lst[i]
    if abs(num - 1) <= abs(num - N):
        ret.append(1)
    else:
        ret.append(N)

print(*ret)

