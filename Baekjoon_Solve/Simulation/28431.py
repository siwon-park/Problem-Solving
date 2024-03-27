# 양말 짝 맞추기 (28431번)
import sys
input = sys.stdin.readline

_set = set()
for _ in range(5):
    socks = int(input().rstrip())
    if socks in _set:
        _set.remove(socks)
    else:
        _set.add(socks)

print(_set.pop())

