# 지능형 기차 (2455번)
import sys
input = sys.stdin.readline

max_ride = 0
cur_ride = 0
for _ in range(4):
    left, ride = map(int, input().rstrip().split())
    max_ride = max(max_ride, cur_ride - left + ride)
    cur_ride += (ride - left)

print(max_ride)
