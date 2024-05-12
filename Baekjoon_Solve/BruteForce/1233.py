# 주사위 (1233번)
import sys
input = sys.stdin.readline

S1, S2, S3 = map(int, input().rstrip().split())
ret_dict = dict()
for i in range(1, S1 + 1):
    for j in range(1, S2 + 1):
        for k in range(1, S3 + 1):
            _sum = i + j + k
            ret_dict[_sum] = ret_dict.get(_sum, 0) + 1

ans = 0
max_v = 0
for k, v in ret_dict.items():
    if v > max_v:
        ans = k
        max_v = v
    elif v == max_v:
        ans = min(ans, k)

print(ans)

