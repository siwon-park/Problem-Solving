# 2023은 무엇이 특별할까? (31090번)
import sys
input = sys.stdin.readline

T = int(input().rstrip())
for _ in range(T):
    N = int(input().rstrip())
    nn = N % 100
    if (N + 1) % nn == 0:
        print("Good")
    else:
        print("Bye")

