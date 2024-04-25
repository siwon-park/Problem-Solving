# 칠무해 (14729번)
import sys
input = sys.stdin.readline

N = int(input().rstrip())
lst = []
for _ in range(N):
    lst.append(float(input().rstrip()))

lst.sort()
for i in range(7):
    print(f'{lst[i]:.3f}')

