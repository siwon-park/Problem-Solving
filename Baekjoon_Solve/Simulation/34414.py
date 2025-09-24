import sys

input = sys.stdin.readline

# Tall Enough (34414번)
N = int(input().rstrip())
flag = True
for _ in range(N):
    h = int(input().rstrip())
    if h < 48:
        flag = False

print(flag)

