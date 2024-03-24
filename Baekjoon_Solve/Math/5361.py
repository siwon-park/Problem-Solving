# 전투 드로이드 가격 (5361번)
import sys
input = sys.stdin.readline

part_price_lst = [350.34, 230.90, 190.55, 125.30, 180.90]

T = int(input().rstrip())
for tc in range(T):
    part_lst = list(map(int, input().rstrip().split()))
    price = 0
    for i in range(5):
        price += part_price_lst[i] * part_lst[i]
    print(f'${price:.2f}')

