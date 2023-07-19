import heapq
import sys
input = sys.stdin.readline

N = int(input())
lst = []
for _ in range(N):
    s, e = map(int, input().split())
    lst.append((s, e))

lst.sort(key=lambda x: x[0])

cnt = 1
pq = []
heapq.heappush(pq, (0, 0))
for i in range(N):
    s, e = lst[i]
    last_fin, last_start = heapq.heappop(pq)
    if s >= last_fin:
        heapq.heappush(pq, (e, s))
    elif s < last_fin:
        heapq.heappush(pq, (last_fin, last_start))
        heapq.heappush(pq, (e, s))
        cnt += 1

print(cnt)