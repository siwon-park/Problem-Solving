import sys

input = sys.stdin.readline

# WARBOY (26082번)
A, B, C = map(int, input().rstrip().split())
print((B // A) * 3 * C)

