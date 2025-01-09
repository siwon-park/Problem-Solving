# 얼룩말을 찾아라! (30454번)
import sys
input = sys.stdin.readline

N, L = map(int, input().rstrip().split())
ans = 0
cnt = 0
for i in range(N):
    zebra = list(map(int, input().rstrip()))
    stripe = 0
    last = 0
    # print(zebra)
    for j in range(L):
        cur = zebra[j]
        if last != cur and cur == 1:
            stripe += 1
        last = cur
    # print(stripe)
    if stripe > cnt:
        cnt = stripe
        ans = 1
    elif stripe == cnt:
        cnt = stripe
        ans += 1

print(cnt, ans)


