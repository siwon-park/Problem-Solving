# 성 지키기 (1236번)
import sys
input = sys.stdin.readline

N, M = map(int, input().rstrip().split())
row_cnt = [0 for _ in range(N)]
col_cnt = [0 for _ in range(M)]

for i in range(N):
    line = input().rstrip()
    for j in range(M):
        if line[j] == 'X':
            row_cnt[i] = 1
            col_cnt[j] = 1

cnt = 0  # 놓아야 하는 개수
# 둘 다 0인 지점에 우선해서 놓음
for i in range(N):
    for j in range(M):
        if row_cnt[i] == 0 and col_cnt[j] == 0:
            cnt += 1
            row_cnt[i] = 1
            col_cnt[j] = 1

# 둘 중 남은 곳을 아무 곳에나 둠
for i in range(N):
    for j in range(M):
        if row_cnt[i] == 0 or col_cnt[j] == 0:
            cnt += 1
            row_cnt[i] = 1
            col_cnt[j] = 1

print(cnt)

