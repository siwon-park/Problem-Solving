import sys

input = sys.stdin.readline

# 이 대회는 이제 제 겁니다 (31922번)
a, p, c = map(int, input().rstrip().split())
print(max(p, a + c))

