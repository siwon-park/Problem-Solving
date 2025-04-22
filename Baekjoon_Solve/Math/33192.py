import sys

input = sys.stdin.readline

# Divar’s Salaries (33192번)
n = int(input().rstrip())
for i in range(n):
    x, k, h = map(int, input().rstrip().split())
    k -= h
    total = x * min(k, 140) + x * max(k - 140, 0) * 1.5 + x * 2 * h
    print(f"{int(total):,}")
