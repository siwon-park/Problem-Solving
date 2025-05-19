import sys

input = sys.stdin.readline

# 단순한 문제 (small) (25494번)
n = int(input().rstrip())

def check(n1: int, n2: int, n3: int) -> int:
    cnt = 0
    for i in range(1, n1 + 1):
        for j in range(1, n2 + 1):
            for k in range(1, n3 + 1):
                if i % j == j % k and j % k == k % i:
                    cnt += 1
    return cnt

for i in range(n):
    a, b, c = map(int, input().rstrip().split())
    print(check(a, b, c))

