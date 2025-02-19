import sys
input = sys.stdin.readline

# Easy-to-Solve Expressions (25784번)
a, b, c = map(int, input().rstrip().split())

def check(n1: int, n2: int, n3: int) -> int:
    if n1 + n2 == n3 or n1 + n3 == n2 or n2 + n3 == n1:
        return 1
    elif n1 * n2 == n3 or n1 * n3 == n2 or n2 * n3 == n1:
        return 2
    return 3

print(check(a, b, c))

