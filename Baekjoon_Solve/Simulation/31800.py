import sys

input = sys.stdin.readline

# Best Chance (31800번)
n = int(input().rstrip())
profit = list(map(int, input().rstrip().split()))
lst = sorted(profit, reverse=True)
price = list(map(int, input().rstrip().split()))

for i in range(n):
    p = lst[0]
    if p == profit[i]:
        p = lst[1]
    print(profit[i] - p, end=' ')

