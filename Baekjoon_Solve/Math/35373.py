import sys

input = sys.stdin.readline

# A Little Leftover Pizza (35373번)
n = int(input().rstrip())
s, m, l = 0, 0, 0
for _ in range(n):
    a, b = input().rstrip().split()
    if a == 'S':
        s += int(b)
    elif a == 'M':
        m += int(b)
    else:
        l += int(b)

ans = 0
if s != 0:
    ans += s // 6 if s % 6 == 0 else s // 6 + 1
if m != 0:
    ans += m // 8 if m % 8 == 0 else m // 8 + 1
if l != 0:
    ans += l // 12 if l % 12 == 0 else l // 12 + 1

print(ans)

