# 조교는 새디스트야 (14656번)
import sys
input = sys.stdin.readline

N = int(input().rstrip())
lst = list(map(int, input().rstrip().split()))
cnt = 0
for i in range(1, N + 1):
    if lst[i - 1] != i:
        cnt += 1

print(cnt)