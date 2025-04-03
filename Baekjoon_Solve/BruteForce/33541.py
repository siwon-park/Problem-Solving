import sys

input = sys.stdin.readline

# 2025는 무엇이 특별할까? (33541번)
X = input().rstrip()
ans = -1
int_x = int(X)
while int_x + 1 < 10000:
    right = (int_x + 1) // 100
    left = (int_x + 1) % 100
    if int_x + 1 == (right + left) ** 2:
        ans = int_x + 1
        break
    int_x += 1

print(ans)

