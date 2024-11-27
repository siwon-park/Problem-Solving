# 미역은 식물 아닌데요 (30502번)
import sys
input = sys.stdin.readline

N, M = map(int, input().rstrip().split())
p_dict, m_dict = dict(), dict()
for i in range(M):
    a, b, c = input().rstrip().split()
    a = int(a)
    if b == "P":
        p_dict[a] = int(c)
    else:
        m_dict[a] = int(c)

_min, _max = 0, 0
for i in range(1, N + 1):
    if p_dict.get(i) == 1 and m_dict.get(i) is None:
        _max += 1
    elif p_dict.get(i) == 1 and m_dict.get(i) == 0:
        _min += 1
        _max += 1
    elif p_dict.get(i) is None and (m_dict.get(i) == 0 or m_dict.get(i) is None):
        _max += 1

print(_min, _max)

