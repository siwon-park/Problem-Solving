# 회상 (32953번)
import sys
input = sys.stdin.readline

N, M = map(int, input().rstrip().split())
_dict = dict()
for i in range(N):
    K = int(input().rstrip())
    lst = list(input().rstrip().split())
    for s_num in lst:
        _dict[s_num] = _dict.get(s_num, 0) + 1

cnt = 0
for k, v in _dict.items():
    if _dict[k] >= M:
        cnt += 1

print(cnt)

