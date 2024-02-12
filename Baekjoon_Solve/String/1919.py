# 애너그램 만들기 (1919번)
import sys
input = sys.stdin.readline

_dict = dict()
line1 = input().rstrip()
line2 = input().rstrip()

for i in range(len(line1)):
    _dict[line1[i]] = _dict.get(line1[i], [0, 0])
    _dict[line1[i]][0] += 1

for i in range(len(line2)):
    _dict[line2[i]] = _dict.get(line2[i], [0, 0])
    _dict[line2[i]][1] += 1

ans = 0
for k, v in _dict.items():
    ans += abs(v[0] - v[1])

print(ans)

