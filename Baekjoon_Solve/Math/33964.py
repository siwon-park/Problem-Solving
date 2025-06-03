import sys

input = sys.stdin.readline

# 레퓨닛의 덧셈 (33964번)
x, y = map(int, input().rstrip().split())
print(int("1" * x) + int("1" * y))
