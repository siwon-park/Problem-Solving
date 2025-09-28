import sys

input = sys.stdin.readline

# Acquiring SW-IT Corn (34529번)
X, Y, Z = map(int, input().rstrip().split())
U, V, W = map(int, input().rstrip().split())

print(X * (U // 100) + Y * (V // 50) + Z * (W // 20))

