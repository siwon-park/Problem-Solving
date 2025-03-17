import sys

input = sys.stdin.readline

# Fan Death (15633번)
n = int(input().rstrip())
_sum = 0
for i in range(1, n + 1):
    if n % i == 0:
        _sum += i

print(_sum * 5 - 24)

