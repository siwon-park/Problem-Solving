# 양파 실험 (32369번)
import sys
input = sys.stdin.readline

N, A, B = map(int, input().rstrip().split())
a, b = 1, 1
while N > 0:
    a += A
    b += B
    if a < b:
        a, b = b, a
    elif a == b:
        b -= 1
    N -= 1

print(a, b)

