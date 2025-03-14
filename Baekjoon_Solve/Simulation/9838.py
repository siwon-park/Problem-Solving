import sys

input = sys.stdin.readline

# XMAS (9838번)
n = int(input().rstrip())
lst = [0 for _ in range(n)]
for i in range(n):
    m = int(input().rstrip()) - 1
    lst[m] = i + 1

for i in range(n):
    print(lst[i])

