# 페르시아의 왕들 (10599번)
import sys
input = sys.stdin.readline

while True:
    a, b, c, d = map(int, input().rstrip().split())
    if a == 0 and b == 0 and c == 0 and d == 0:
        break
    print(c - b, d - a)

