import sys

input = sys.stdin.readline

# 학점계산프로그램 (29614번)
s_dict = {"A+": 4.5, "A": 4.0, "B+": 3.5, "B": 3.0, "C+": 2.5, "C": 2.0, "D+": 1.5, "D": 1.0, "F": 0.0}
S = input().rstrip()
m = len(S)
idx = 0
total = 0
cnt = 0
while idx < m:
    total += s_dict[S[idx]]
    if idx + 1 < m and S[idx + 1] == "+":
        total += 0.5
        idx += 1
    idx += 1
    cnt += 1

print(f'{total / cnt:.5f}')

