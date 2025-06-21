import sys

input = sys.stdin.readline

# 제곱수? (34027번)
T = int(input().rstrip())
for i in range(T):
    n = int(input().rstrip())
    sqrt = int(n ** (1 / 2))
    if sqrt ** 2 == n:
        print(1)
    else:
        print(0)

