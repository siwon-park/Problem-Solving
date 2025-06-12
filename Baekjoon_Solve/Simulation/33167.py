import sys

input = sys.stdin.readline

# Rock-Scissors-Paper (33167번)
N = int(input().rstrip())
S = input().rstrip()
T = input().rstrip()
cnt1, cnt2 = 0, 0
for i in range(N):
    if S[i] == T[i]:
        continue
    if S[i] == "R" and T[i] == "S":
        cnt1 += 1
    elif S[i] == "S" and T[i] == "P":
        cnt1 += 1
    elif S[i] == "P" and T[i] == "R":
        cnt1 += 1
    else:
        cnt2 += 1

print(cnt1, cnt2)

