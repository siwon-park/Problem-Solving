import sys

input = sys.stdin.readline

# Quick Estimates (13297번)
n = int(input().rstrip())
for _ in range(n):
    print(len(input().rstrip()))

