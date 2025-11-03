import sys

input = sys.stdin.readline

# 홀수일까 짝수일까 (5988번)
N = int(input().rstrip())
for i in range(N):
    num = input().rstrip()
    n = int(num[-1])
    if n % 2 == 0:
        print("even")
    else:
        print("odd")

