# 너의 평점은 (25206번)
import sys
input = sys.stdin.readline

score_dict = {"A+": 4.5, "A0": 4.0, "B+": 3.5, "B0": 3.0, "C+": 2.5, "C0": 2.0, "D+": 1.5, "D0": 1.0, "F": 0}
total = 0
score = 0
for i in range(20):
    lst = input().rstrip().split()
    if lst[2] == "P":
        continue
    score += float(lst[1]) * score_dict[lst[2]]
    total += float(lst[1])

print(f'{(score / total):.6f}')

