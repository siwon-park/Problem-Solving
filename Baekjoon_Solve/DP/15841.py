# Virus Outbreak (15841번)
import sys
input = sys.stdin.readline


def recur(n: int) -> int:
    if memo[n] != -1:
        return memo[n]
    memo[n] = recur(n - 1) + recur(n - 2)
    return memo[n]


memo = [-1] * 491
memo[0], memo[1] = 0, 1
recur(490)

while True:
    n = int(input().rstrip())
    if n == -1:
        break
    print(f'Hour {n}: {memo[n]} cow(s) affected')
