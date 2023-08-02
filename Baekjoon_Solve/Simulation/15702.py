# 중간고사 채점 (15702번)
import sys
input = sys.stdin.readline

N, M = map(int, input().rstrip().split())
score = list(map(int, input().rstrip().split()))
lst = []
for _ in range(M):
    tmp = input().rstrip().split()
    hit = tmp[1:]
    s = 0
    for i in range(N):
        if hit[i] == "O":
            s += score[i]
    lst.append((int(tmp[0]), s))

lst.sort(key=lambda x: (-x[1], x[0]))

print(*lst[0])
