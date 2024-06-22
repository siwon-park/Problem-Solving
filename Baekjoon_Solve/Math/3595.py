# 맥주 냉장고 (3595번)
import sys
input = sys.stdin.readline

n = int(input().rstrip())
div = []
for i in range(1, n + 1):
    if n % i == 0:
        div.append(i)

min_size = int(1e9)
a, b, c = 0, 0, 0
for i in div:
    for j in div:
        for k in div:
            if i * j * k == n:
                cur_size = (2 * i * j) + (2 * i * k) + (2 * j * k)
                if cur_size < min_size:
                    min_size = cur_size
                    a, b, c = i, j, k

print(a, b, c)

