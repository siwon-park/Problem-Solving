# UOSPC 세기 (30822번)
import sys
input = sys.stdin.readline

N = int(input().rstrip())
S = input().rstrip()
_dict = dict()
for s in S:
    _dict[s] = _dict.get(s, 0) + 1

uospc = "uospc"
ans = 1000
for w in uospc:
    ans = min(ans, _dict.get(w, 0))

print(ans)

