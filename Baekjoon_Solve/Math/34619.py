import sys

input = sys.stdin.readline

# 소대 배정 (34619번)
a, b, n, k = map(int, input().rstrip().split())
p = (k - 1) // n
ans1 = p // b + 1
ans2 = p % b + 1

print(ans1, ans2)

