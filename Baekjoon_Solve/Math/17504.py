# 제리와 톰 2 (17504번)
import sys
input = sys.stdin.readline

N = int(input().rstrip())
lst = list(map(int, input().rstrip().split()))
p = lst[-1]
q = lst[-1] * lst[-2] + 1

for i in range(N - 3, -1, -1):
    p += lst[i] * q
    p, q = q, p

print(q - p, q)