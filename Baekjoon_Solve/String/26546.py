import sys
input = sys.stdin.readline

# Reverse (26546번)
N = int(input().rstrip())
for _ in range(N):
    s, i, j = input().rstrip().split()
    i = int(i)
    j = int(j)
    print(s[:i] + s[j:])
