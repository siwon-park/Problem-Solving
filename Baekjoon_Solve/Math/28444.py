import sys

input = sys.stdin.readline

# HI-ARC=? (28444번)
h, i, a, r, c = map(int, input().rstrip().split())
_first = h * i
_second = a * r * c
print(_first - _second)

