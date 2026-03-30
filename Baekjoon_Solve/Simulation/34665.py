import sys

input = sys.stdin.readline

# 가희와 교통 요금 (34665번)
A = input().rstrip()
B = input().rstrip()
if A == B:
    print(0)
else:
    print(1550)
