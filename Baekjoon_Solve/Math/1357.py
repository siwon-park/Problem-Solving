# 뒤집힌 덧셈 (1357번)
import sys
input = sys.stdin.readline


def rev(x: int) -> int:
    n = 0
    while x > 0:
        n = n * 10 + x % 10
        x //= 10
    return n


a, b = map(int, input().rstrip().split())
print(rev(rev(a) + rev(b)))

