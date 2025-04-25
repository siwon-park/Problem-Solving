import sys

input = sys.stdin.readline

# Generalized FizzBuzz (32801번)
n, a, b = map(int, input().rstrip().split())
fbz, fz, bz = 0, 0, 0
for i in range(1, n + 1):
    if i % a == 0 and i % b == 0:
        fbz += 1
    elif i % a == 0:
        fz += 1
    elif i % b == 0:
        bz += 1

print(fz, bz, fbz)

