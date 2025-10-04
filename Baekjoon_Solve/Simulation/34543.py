import sys

input = sys.stdin.readline

# 와우산 스탬프 투어 (34543번)
N = int(input().rstrip())
W = int(input().rstrip())
s = N * 10 + (20 if N >= 3 else 0) + (50 if N == 5 else 0) - (15 if W > 1000 else 0)
print(max(0, s))

