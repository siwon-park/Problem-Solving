# 등장하지 않는 문자의 합 (3059번)
import sys
input = sys.stdin.readline

_sum = sum(i for i in range(65, 91))

T = int(input().rstrip())
for tc in range(T):
    S = set(input().rstrip())  # 여러 번 나와도 한 번만 빼야 함
    tmp = 0
    for s in S:
        tmp += ord(s)
    print(_sum - tmp)

