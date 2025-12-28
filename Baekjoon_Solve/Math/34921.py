import sys

input = sys.stdin.readline

# 덕후 (34921번)
a, t = map(int, input().rstrip().split())
print(max(0, 10 + 2 * (25 - a + t)))

