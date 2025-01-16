# gahui and sousenkyo 2 (30792번)
import sys
input = sys.stdin.readline

n = int(input().rstrip())
cnt = int(input().rstrip())
rank = 1
lst = list(map(int, input().rstrip().split()))
for i in range(n - 1):
    if lst[i] > cnt:
        rank += 1

print(rank)

