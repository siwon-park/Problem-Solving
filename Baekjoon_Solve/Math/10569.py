import sys

input = sys.stdin.readline

# 다면체 (10569번)
T = int(input().rstrip())
for _ in range(T):
    v, e = map(int, input().rstrip().split())
    print(2 - v + e)

