import sys

input = sys.stdin.readline

# The Second Largest Integer (20976번)
A, B, C = map(int, input().rstrip().split())
print(sorted([A, B, C])[1])

