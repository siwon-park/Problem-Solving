import sys

input = sys.stdin.readline

# 2의 제곱인가? (11966번)
_power = [1 << i for i in range(31)]

n = int(input().rstrip())
if n in _power:
    print(1)
else:
    print(0)

