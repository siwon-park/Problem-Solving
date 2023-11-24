# 치킨댄스를 추는 곰곰이를 본 임스 2 (26068번)
import sys
input = sys.stdin.readline

N = int(input().rstrip())
cnt = 0
for _ in range(N):
    gift = input().rstrip()
    left = int(gift[2:])
    if left <= 90:
        cnt += 1

print(cnt)
