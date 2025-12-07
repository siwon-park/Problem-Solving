import sys

input = sys.stdin.readline

# 분수 합 (1735번)
A, B = map(int, input().rstrip().split())
C, D = map(int, input().rstrip().split())


def gcd(a, b):
    while b:
        a, b = b, a % b
    return a

denominator = B * D
numerator = A * D + C * B

m = gcd(numerator, denominator)
print(numerator // m, denominator // m)

