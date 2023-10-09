# 파일 합치기 3 (13975번)
import sys, heapq
input = sys.stdin.readline

T = int(input())
for tc in range(T):
    K = int(input())
    files = list(map(int, input().split()))
    pq = []
    for i in range(K):
        heapq.heappush(pq, files[i])

    ans = 0
    while pq:
        min1 = heapq.heappop(pq)
        if pq:
            min2 = heapq.heappop(pq)
            ans += min1 + min2
            heapq.heappush(pq, min1 + min2)

    print(ans)
