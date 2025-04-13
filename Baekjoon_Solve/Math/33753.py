import sys, math

input = sys.stdin.readline

# 주차 요금 정산하기 (33753번)
A, B, C = map(int, input().rstrip().split())
T = int(input().rstrip())
if T <= 30:
    print(A)
else:
    exceed = T - 30
    print(A + C * math.ceil(exceed / B))

