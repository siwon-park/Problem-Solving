import sys

input = sys.stdin.readline

# 정보섬의 대중교통 (28113번)
N, A, B = map(int, input().rstrip().split())

if A == B:
    print("Anything")
elif A < B:
    print("Bus")
else:
    print("Subway")

