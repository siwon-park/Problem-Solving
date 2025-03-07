import sys
input = sys.stdin.readline

# 동일한 단어 그룹화하기 (16499번)
_dict = dict()
N = int(input().rstrip())
for i in range(N):
    lst = list(input().rstrip())
    lst.sort()
    s = "".join(lst)
    _dict[s] = _dict.get(s, 0) + 1

print(len(_dict))

