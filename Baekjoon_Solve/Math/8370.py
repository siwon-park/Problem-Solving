import sys

input = sys.stdin.readline

# Plane (8370번)
n1, k1, n2, k2 = map(int, input().rstrip().split())
print(n1 * k1 + n2 * k2)
