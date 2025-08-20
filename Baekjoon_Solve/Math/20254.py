import sys

input = sys.stdin.readline

# Site Score (20254번)
ur, tr, uo, to = map(int, input().rstrip().split())
print(ur * 56 + tr * 24 + uo * 14 + to * 6)

