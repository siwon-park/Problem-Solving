# 얼마? (9325번)
import sys
input = sys.stdin.readline

T = int(input().rstrip())
for tc in range(T):
    s = int(input().rstrip())
    n = int(input().rstrip())
    for _ in range(n):
        q, p = map(int, input().rstrip().split())
        s += q * p
    print(s)

