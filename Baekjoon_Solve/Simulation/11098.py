# 첼시를 도와줘! (11098번)
import sys
input = sys.stdin.readline

n = int(input().rstrip())
for _ in range(n):
    p = int(input().rstrip())
    max_price = -sys.maxsize
    buy = ""
    for _ in range(p):
        price, name = input().rstrip().split()
        price = int(price)
        if max_price < price:
            max_price = price
            buy = name
    print(buy)


