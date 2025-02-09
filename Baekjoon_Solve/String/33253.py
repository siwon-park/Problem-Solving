import sys
input = sys.stdin.readline

# Game Night (33253번)
n = int(input().rstrip())
_dict = dict()
old_pw = input().rstrip()
new_pw = input().rstrip()

for i in range(n):
    _dict[old_pw[i]] = _dict.get(old_pw[i], 0) + 1

ans = 0
for i in range(n):
    if _dict.get(new_pw[i]) is None or _dict.get(new_pw[i]) == 0:
        ans += 1
    else:
        _dict[new_pw[i]] = _dict.get(new_pw[i]) - 1

print(ans)

