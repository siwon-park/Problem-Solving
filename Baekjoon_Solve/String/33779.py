import sys

input = sys.stdin.readline

# Back and Forth (33779번)
s = input().rstrip()
n = len(s)

if n % 2 == 1 and s[:n//2] == s[n//2 + 1:][::-1]:
    print("beep")
elif n % 2 == 0 and s[:n//2] == s[n//2:][::-1]:
    print("beep")
else:
    print("boop")

