import sys

input = sys.stdin.readline

# SUAPC 의자 준비하기 (34033번)
n, m, a, b = map(int, input().rstrip().split())

n *= 3
left = n - m
if left <= 0:
    print(0)
else:
    total = left * a + b
    print(total)

