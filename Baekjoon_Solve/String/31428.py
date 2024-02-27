# 엘리스 트랙 매칭 (31428번)
import sys
input = sys.stdin.readline

N = int(input().rstrip())
lst = input().rstrip().split()
_dict = dict()
for i in range(N):
    _dict[lst[i]] = _dict.get(lst[i], 0) + 1

S = input().rstrip()
print(_dict.get(S, 0))

