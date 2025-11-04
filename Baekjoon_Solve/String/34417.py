import sys

input = sys.stdin.readline

# Alphabet Soup (34417번)
ans = ""
_lst = ["A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"]
S = input().rstrip()
for s in _lst:
    if s not in S:
        ans += s

if ans == "":
    print("Alphabet Soup!")
else:
    print(ans)

