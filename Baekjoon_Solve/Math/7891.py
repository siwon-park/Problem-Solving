import sys

input = sys.stdin.readline

# 7891번
n = int(input().rstrip())
for i in range(n):
    x, y = map(int, input().rstrip().split())
    print(x + y)

