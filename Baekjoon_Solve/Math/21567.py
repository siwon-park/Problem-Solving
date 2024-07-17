# 숫자의 개수 2 (21567번)
import sys
input = sys.stdin.readline

A = int(input().rstrip())
B = int(input().rstrip())
C = int(input().rstrip())
count = [0 for _ in range(10)]
N = A * B * C
while N > 0:
    count[N % 10] += 1
    N //= 10

for cnt in count:
    print(cnt)

