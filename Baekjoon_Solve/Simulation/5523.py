# 경기 결과 (5523번)
import sys
input = sys.stdin.readline

N = int(input().rstrip())
A, B = 0, 0
for i in range(N):
    a, b = map(int, input().rstrip().split())
    if a > b:
        A += 1
    elif a < b:
        B += 1

print(A, B)

