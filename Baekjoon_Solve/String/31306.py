# Is Y a Vowel? (31306번)
import sys
input = sys.stdin.readline

line = input().rstrip()
cnt1, cnt2 = 0, 0
for w in line:
    if w == 'a' or w == 'e' or w == 'i' or w == 'o' or w == 'u':
        cnt1 += 1
    elif w == 'y':
        cnt2 += 1

print(cnt1, cnt1 + cnt2)

