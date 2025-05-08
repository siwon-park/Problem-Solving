import sys

input = sys.stdin.readline

# 디미고에 가고 싶어! (32184번)
A, B = map(int, input().rstrip().split())
ans = 0
if A % 2 == 0:
    ans += 1
    A += 1
if B % 2 == 1:
    ans += 1
    B -= 1

print(ans + (B - A + 1) // 2)

