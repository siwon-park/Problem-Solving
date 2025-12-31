import sys

input = sys.stdin.readline

# 현대모비스와 함께하는 부품 관리 (24724번)
t = int(input().rstrip())
for x in range(1, t + 1):
    print(f"Material Management {x}")
    n = int(input().rstrip())
    a, b = map(int, input().rstrip().split())
    for _ in range(n):
        u, v = map(int, input().rstrip().split())
    print("Classification ---- End!")
