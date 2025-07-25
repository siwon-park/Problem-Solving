import sys

input = sys.stdin.readline

# SASA 모형을 만들어보자 (23825번)
n, m = map(int, input().rstrip().split())
print(min(n, m) // 2)

