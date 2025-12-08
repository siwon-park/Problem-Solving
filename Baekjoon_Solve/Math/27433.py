import sys

input = sys.stdin.readline

# 팩토리얼 2 (27433번)
N = int(input().rstrip())

def factorial(n):
    if n <= 1:
        return 1
    return n * factorial(n - 1)

print(factorial(N))

