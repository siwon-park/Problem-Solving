import sys

input = sys.stdin.readline

# 오각형, 오각형, 오각형… (1964번)
n = int(input().rstrip())
ans = (3 * (n ** 2) + 5 * n) / 2 + 1
print(int(ans) % 45678)
