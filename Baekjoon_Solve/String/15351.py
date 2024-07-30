# 인생 점수 (15351번)
import sys
input = sys.stdin.readline

N = int(input().rstrip())
for i in range(N):
    score = 0
    words = input().rstrip()
    for w in words:
        if w == " ":
            continue
        score += ord(w) - 64
    if score == 100:
        print("PERFECT LIFE")
    else:
        print(score)

