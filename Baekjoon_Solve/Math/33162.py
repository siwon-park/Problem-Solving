import sys
input = sys.stdin.readline

x = int(input())

q, r = x // 2, x % 2
if r == 0:
    print(q)
else:
    print(q + 3)

