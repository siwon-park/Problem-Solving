import sys, heapq
input = sys.stdin.readline
N, K = map(int, input().split())
INF = int(1e9)
distance = [INF] * 100001
def dijkstra():
    q = []
    heapq.heappush(q, (0, N))
    distance[N] = 0
    while q:
        t, cur = heapq.heappop(q)
        if cur == K:
            return t
        if 0 <= cur - 1 <= 100000:    
            if distance[cur - 1] > t + 1:
                distance[cur - 1] = t + 1        
                heapq.heappush(q, (t + 1, cur - 1))
        if 0 <= cur + 1 <= 100000:         
            if distance[cur + 1] > t + 1:
                distance[cur + 1] = t + 1      
                heapq.heappush(q, (t + 1, cur + 1))
        if 0 <= cur * 2 <= 100000:                       
            if distance[cur * 2] > t:
                distance[cur * 2] = t                
                heapq.heappush(q, (t, cur * 2))        
    return distance
print(dijkstra()) 