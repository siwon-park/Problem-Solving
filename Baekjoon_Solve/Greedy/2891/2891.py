# 카약과 강풍 (2891번)
import sys
input = sys.stdin.readline

N, S, R = map(int, input().split())
broken = list(map(int, input().split()))
extra = set(map(int, input().split()))

broken.sort()  # 정렬

extra_used = set()
cnt = 0
for i in range(S):
    cur = broken[i]  # 현재 고장난 팀 번호
    if cur in extra:
        extra_used.add(cur)
        cnt += 1

for i in range(S):
    cur = broken[i]
    if cur in extra_used:
        continue
    if cur - 1 in extra and cur - 1 not in extra_used:
        extra_used.add(cur - 1)
        cnt += 1
    elif cur + 1 in extra and cur + 1 not in extra_used:
        extra_used.add(cur + 1)
        cnt += 1

print(S - cnt)