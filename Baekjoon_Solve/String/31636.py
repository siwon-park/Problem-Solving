import sys

input = sys.stdin.readline

# Three Consecutive (31636번)
N = int(input().rstrip())
S = input().rstrip()

streak = 0
last = ""
for i in range(N):
    if S[i] == "o":
        if last != "o":
            streak = 1
        elif last == "o":
            streak += 1
            if streak >= 3:
                break
    else:
        streak = 0
    last = S[i]

if streak >= 3:
    print("Yes")
else:
    print("No")

