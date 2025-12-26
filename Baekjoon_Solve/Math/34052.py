import sys

input = sys.stdin.readline

# 체육은 수학과목 입니다 2 (34052번)
_sum = 0
for _ in range(4):
    _sum += int(input().rstrip())

if _sum + 300 <= 1800:
    print("Yes")
else:
    print("No")

