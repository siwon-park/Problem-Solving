# 미국 스타일 (2712번)
import sys
input = sys.stdin.readline

N = int(input().rstrip())

_dict1 = {"kg": 2.2046, "lb": 0.4536, "l": 0.2642, "g": 3.7854}
_dict2 = {"kg": "lb", "lb": "kg", "l": "g", "g": "l"}

for _ in range(N):
    tmp_num, unit = input().rstrip().split()
    num = float(tmp_num)
    cal = num * _dict1[unit]
    print(f'{cal:.4f} {_dict2[unit]}')

