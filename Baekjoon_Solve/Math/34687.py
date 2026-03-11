import sys

input = sys.stdin.readline

# 라면 끓여 먹자 야호 (34687번)
n, m = map(int, input().rstrip().split())
n *= 81
m *= 100
if m >= n:
    print("yaho")
else:
    print("no")

