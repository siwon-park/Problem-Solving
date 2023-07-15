# 강의실 배정(11000번)
import sys, heapq
input = sys.stdin.readline

pq = []
N = int(input())
lst = []
for _ in range(N):
    S, T = map(int, input().split())
    lst.append((S, T))

lst.sort() # 강의가 빨리 끝나는 순으로 정렬
heapq.heappush(pq, lst[0][1]) # (가장 빨리 시작하는)강의의 끝나는 시간을 우선 순위 큐에 삽입

cnt = 1 # 초깃값은 1
for i in range(1, N):
    end = heapq.heappop(pq)
    if lst[i][0] < end: # 현재 강의 시작 시간이 가장 빨리 끝나는 강의 종료 시간보다 작으면
        cnt += 1 # 다른 강의실에서 강의를 해야하므로 cnt += 1
        heapq.heappush(pq, end) # 우선 순위 큐에 pop했던 요소를 그대로 넣는다.
        heapq.heappush(pq, lst[i][1]) # 현재 강의의 끝나는 시간을 우선순위 큐에 삽입한다.
    else:
        heapq.heappush(pq, lst[i][1])
print(cnt)
