# 5의 수난 (23037번)
import sys
input = sys.stdin.readline

n = int(input().rstrip())
ans = 0
while n > 0:
    ans += (n % 10) ** 5
    n //= 10

print(ans)

