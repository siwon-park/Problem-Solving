# 행복한 소수 (10434번)
import sys
input = sys.stdin.readline

is_prime = [True] * 10001
is_prime[1] = False

for i in range(2, 10001):
    if is_prime[i]:
        j = 2
        while i * j < 10001:
            is_prime[i * j] = False
            j += 1

P = int(input().rstrip())
for _ in range(P):
    t, m = map(int, input().rstrip().split())
    num = m
    is_happy = False
    visited = [False] * 10001

    while True:
        prime = 0
        while num > 0:
            q = num % 10
            prime += (q ** 2)
            num //= 10

        if prime == 1:
            is_happy = True
            break
        if not visited[prime]:
            visited[prime] = True
        else:
            break
        num = prime

    ans = "NO"
    if is_prime[m] and is_happy:
        ans = "YES"

    print(t, m, ans)
