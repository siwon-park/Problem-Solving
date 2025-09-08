import sys

input = sys.stdin.readline

# 홀짝홀짝 (31867번)
n = int(input().rstrip())
k = input().rstrip()
even, odd = 0, 0
for i in range(n):
    if int(k[i]) % 2:
        odd += 1
    else:
        even += 1

if odd > even:
    print(1)
elif odd < even:
    print(0)
else:
    print(-1)

