import sys

input = sys.stdin.readline

# 콰트로치즈피자 (27964번)
n = int(input().rstrip())
_set = set()
lst = input().rstrip().split()
for i in range(n):
    s = lst[i]
    m = len(s)
    if m >= 6 and s[m - 6:m] == "Cheese":
        _set.add(s)

if len(_set) >= 4:
    print("yummy")
else:
    print("sad")
