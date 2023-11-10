# 호반우가 학교에 지각한 이유 1 (30468번)
import sys
input = sys.stdin.readline

_str, _dex, _int, _luk, N = map(int, input().rstrip().split())
avg = (_str + _dex + _int + _luk) / 4
if avg >= N:
    print(0)
else:
    print((N * 4) - (_str + _dex + _int + _luk))