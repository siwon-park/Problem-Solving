import sys

input = sys.stdin.readline

# 구멍 (33571번)
_dict = {"A": 1, "a": 1, "B": 2, "b": 1, "D": 1, "d": 1, "e": 1, "g": 1, "O": 1, "o": 1,
         "P": 1, "p": 1, "Q": 1, "q": 1, "R": 1, "@": 1}

S = input().rstrip()
ans = 0
for s in S:
    if s in _dict:
        ans += _dict[s]

print(ans)

