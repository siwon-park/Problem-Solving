# 이번학기 평점은 몇점? (2755번)
import sys, math
input = sys.stdin.readline

N = int(input().rstrip())
_dict = {"A+": 4.3, "A0": 4.0, "A-": 3.7, "B+": 3.3, "B0": 3.0, "B-": 2.7, "C+": 2.3, "C0": 2.0, "C-": 1.7,
       "D+": 1.3, "D0": 1.0, "D-": 0.7, "F": 0.0}

score = 0
total = 0
for _ in range(N):
    lst = input().rstrip().split()
    score += int(lst[1])
    total += (int(lst[1]) * _dict[lst[2]])

print(f'{(total / score) + 0.000000000001:.2f}')

