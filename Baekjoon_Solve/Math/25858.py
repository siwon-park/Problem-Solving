import sys

input = sys.stdin.readline

# Divide the Cash (25858번)
n, d = map(int, input().rstrip().split())
lst = []
total = 0
for i in range(n):
    m = int(input().rstrip())
    total += m
    lst.append(m)

quote = d // total
for i in range(n):
    print(lst[i] * quote)

