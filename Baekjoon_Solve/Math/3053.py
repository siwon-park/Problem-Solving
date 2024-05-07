# 택시 기하학 (3053번)
import sys
import math
input = sys.stdin.readline

R = int(input().rstrip())
pi = math.pi

euclid = R * R * pi
taxi_geo = R * R * 2

print(f'{euclid:.6f}')
print(f'{taxi_geo:.6f}')

