# 페르마의 크리스마스 정리 (4913번)
"""
    문제: https://www.acmicpc.net/problem/4913
    소수, 에라토스테네스의 체, 누적합
    효율성을 위해 누적합으로 풀어야한다.
    잔실수 때문에 아니 진짜 왜맞틀을 많이 시전했다.
    에라토스테네스의 체를 통해 소수 판별과 동시에 소수의 개수를 누적한다.
    동시에 해당 소수가 제곱수로 나눠질 수 있는지 여부를 누적한다.
    문제에서 주어진 페르마의 정리에 따르면 if p is expressible as p = 4c + 1라고 했으므로
    소수가 4로 나눴을 때, 나머지가 1이라면 제곱수가 가능하다. 단, 이 때 2는 1^2 + 1^2로 나타낼 수 있어 예외임을 유의해야한다.
    그렇지 않으면 1 3을 입력했을 때 1 3 2 1이 나와야 하는데, 1 3 2 0이 나온다.
"""
import sys
input = sys.stdin.readline

MAX = int(1e6) + 1
is_prime = [True] * MAX
is_prime[0] = is_prime[1] = False
prime_count = [0] * MAX
sqrt_count = [0] * MAX
sqrt_count[2] = 1

for i in range(2, MAX):
    ret = False
    if is_prime[i]:
        j = 2
        while i * j < MAX:
            is_prime[i * j] = False
            j += 1
        prime_count[i] = prime_count[i - 1] + 1
        if i % 4 == 1:
            sqrt_count[i] = sqrt_count[i - 1] + 1
    prime_count[i] = max(prime_count[i], prime_count[i - 1])
    sqrt_count[i] = max(sqrt_count[i], sqrt_count[i - 1])

while True:
    L, U = map(int, input().rstrip().split())
    if L == -1 and U == -1:
        break
    l, u = L, U
    if L <= 0:
        l = 1
    if U < 0:
        u = 0
    x = prime_count[u] - prime_count[l - 1]
    y = sqrt_count[u] - sqrt_count[l - 1]
    print(L, U, x, y)
