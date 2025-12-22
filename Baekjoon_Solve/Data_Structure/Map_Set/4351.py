import sys

input = sys.stdin.readline

# Hay Points (4351번)
m, n = map(int, input().rstrip().split())
word_value = dict()
for i in range(m):
    k, v = input().rstrip().split()
    word_value[k] = int(v)

for _ in range(n):
    ans = 0
    while True:
        line = input().rstrip()
        if line == ".":
            break
        line = line.split()
        for w in line:
            if w in word_value:
                ans += word_value[w]
    print(ans)

