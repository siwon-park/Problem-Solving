# 쿠폰 (10179번)
import sys
input = sys.stdin.readline

T = int(input().rstrip())
for tc in range(T):
    p = float(input().rstrip())
    print(f'${(p * 0.8):.2f}')

