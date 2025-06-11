import sys

input = sys.stdin.readline

# 브실이의 입시전략 (29723번)
N, M, K = map(int, input().rstrip().split())
_dict = dict()
for i in range(N):
    s, p = input().rstrip().split()
    _dict[s] = int(p)

base_score = 0
_set = set()
for i in range(K):
    target = input().rstrip()
    base_score += _dict[target]
    _set.add(target)

lst = []
for k, v in _dict.items():
    if k in _set:
        continue
    lst.append(v)

lst.sort()
l = len(lst)
_min, _max = base_score, base_score
for i in range(M - K):
    _min += lst[i]
    _max += lst[l - 1 - i]

print(_min, _max)

