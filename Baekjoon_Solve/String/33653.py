import sys

input = sys.stdin.readline

# Search Wizard (33653번)
w = input().rstrip()
m = int(input().rstrip())
s = input().rstrip().split()
cnt = 0

k = len(w)
for word in s:
    n = len(word)
    for i in range(n - k + 1):
        if word[i:i+k] == w:
            cnt += 1

print(cnt)

