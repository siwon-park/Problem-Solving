import sys, heapq
input = sys.stdin.readline
N = int(input())
max_q, min_q = [], []
lmx, lmn = 0, 0
for _ in range(N):
    num = int(input())
    if lmx == lmn:
        heapq.heappush(max_q, -num)
        lmx += 1
    else:
        heapq.heappush(min_q, num)
        lmn += 1
    if min_q:
        max_num = -heapq.heappop(max_q)
        min_num = heapq.heappop(min_q)
        if min_num < max_num:
            heapq.heappush(min_q, max_num)
            heapq.heappush(max_q, -min_num)
        else:
            heapq.heappush(min_q, min_num)
            heapq.heappush(max_q, -max_num)
    print(-max_q[0])