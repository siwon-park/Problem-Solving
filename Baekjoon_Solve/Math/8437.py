import sys

input = sys.stdin.readline

# Julka (8437번)
N = int(input().rstrip())
M = int(input().rstrip())

print((N + M) // 2)
print((N - M) // 2)
