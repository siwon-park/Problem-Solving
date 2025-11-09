import sys

input = sys.stdin.readline

# Milk Pails (Bronze) (11999번)
x, y, m = map(int, input().rstrip().split())
_max = 0
for i in range(m // x + 1):
    for j in range(m // y + 1):
        total = i * x + j * y
        if total <= m:
            _max = max(_max, total)

print(_max)

