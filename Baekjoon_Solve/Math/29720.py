import sys

input = sys.stdin.readline

# 그래서 님 푼 문제 수가? (29720번)
n, m, k = map(int, input().rstrip().split())
print(max(0, n - (m * k)), n - (m * (k - 1)) - 1)
