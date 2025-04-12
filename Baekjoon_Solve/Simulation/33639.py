import sys

input = sys.stdin.readline

# Candy Store (33639번)
N, Q = map(int, input().rstrip().split())
_dict = dict()
for _ in range(N):
    name = input().rstrip().split()
    key = name[0][0] + name[1][0]
    if _dict.get(key) is not None:
        _dict[key] = "ambiguous"
    else:
        _dict[key] = name[0] + " " + name[1]

for _ in range(Q):
    k = input().rstrip()
    if _dict.get(k) is None:
        print("nobody")
    else:
        print(_dict[k])

