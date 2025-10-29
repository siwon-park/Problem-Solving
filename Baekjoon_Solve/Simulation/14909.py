import sys

input = sys.stdin.readline

# 양수 개수 세기 (14909번)
lst = list(map(int, input().rstrip().split()))
cnt = 0
for n in lst:
    if n > 0:
        cnt += 1

print(cnt)

