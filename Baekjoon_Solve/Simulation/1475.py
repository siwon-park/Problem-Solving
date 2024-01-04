# 방 번호 (1475번)
import sys
input = sys.stdin.readline

N = int(input().rstrip())
check = [0 for _ in range(10)]
while N > 0:
    r = N % 10
    if r == 9 or r == 6:
        if check[6] < check[9]:
            check[6] += 1
        else:
            check[9] += 1
    else:
        check[r] += 1
    N //= 10

print(max(check))

