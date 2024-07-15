# 반복 (19564번)
import sys
input = sys.stdin.readline

S = input().rstrip()
k = 1
m = len(S)
count = [0 for _ in range(26)]
count[ord(S[0]) - 97] += 1
for i in range(1, m):
    if ord(S[i - 1]) < ord(S[i]) and count[ord(S[i]) - 97] == 0:
        count[ord(S[i]) - 97] += 1
    else:
        count = [0 for _ in range(26)]
        count[ord(S[i]) - 97] += 1
        k += 1

print(k)

