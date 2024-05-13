# 탄산 음료 (5032번)
import sys
input = sys.stdin.readline

e, f, c = map(int, input().rstrip().split())
total = e + f
ans = 0
while total // c > 0:
    q = total // c
    r = total % c
    ans += q
    total = q + r

print(ans)

