# 과제 (13904번)
"""
  문제: https://www.acmicpc.net/problem/13904
  우선순위 큐, 정렬
  주어지는 d, w를 리스트에 담아서 d를 기준으로 오름차순 정렬하고
  우선순위 큐와 현재 날짜인 day 변수를 선언한다.
  리스트를 순회하면서, 만약 우선순위 큐에 요소가 없으면 삽입하고 day를 1 증가시킨다.
  우선순위 큐에 요소가 있고 d가 day보다 크다면 과제를 수행할 수 있으므로 우선순위 큐에 삽입한다.
  만약 d가 day 이하라면, 우선순위 큐에서 요소를 뽑아서 지금 넣으려는 w와 비교를 한 다음
  w가 더 크면 우선순위 큐에 넣고, 이하라면 다시 뽑았던 원래 요소를 우선순위 큐에 넣는다.
  그 후 우선순위 큐를 순회하면서 w를 누적해서 반환하면 끝
"""
import sys, heapq
input = sys.stdin.readline

N = int(input())
lst = []
for _ in range(N):
    d, w = map(int, input().split())
    lst.append((d, w))

lst.sort()

pq = []
day = 0
for i in range(N):
    d, w = lst[i]
    if not pq:
        heapq.heappush(pq, (w, d))
        day += 1
    else:
        if d > day:
            heapq.heappush(pq, (w, d))
            day += 1
        else:
            pq_w, pq_d = heapq.heappop(pq)
            if pq_w < w:
                heapq.heappush(pq, (w, d))
            else:
                heapq.heappush(pq, (pq_w, pq_d))

ans = 0
while pq:
    w, d = heapq.heappop(pq)
    ans += w

print(ans)
