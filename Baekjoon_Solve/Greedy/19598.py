# 최소 회의실 개수(19589번)
######################################################################################
    # 문제: https://www.acmicpc.net/problem/19598
    # 최소 힙(우선순위 큐), 그리디, 정렬
    # 회의실 시간을 리스트에 받아서 시작 시간 기준 오름차순 정렬해준다
    # 최소 힙에서 요소를 뽑아서 현재 시작 시간과 비교한다
    # 최소 힙의 첫번째 요소는 회의가 끝나는 가장 빠른 시간이므로, 만약 이 값보다 현재 시작 시간이 더 크면
    # 큐에 있는 회의가 끝나고 현재 회의를 바로 시작할 수 있다는 의미이므로 현재 시간 정보를 큐에 넣는다
    # 그렇지 않으면 큐에 있는 요소를 다시 집어 넣고 현재 시간 정보 역시 큐에 넣고 회의실의 개수를 += 1해준다.
######################################################################################
import heapq
import sys
input = sys.stdin.readline

N = int(input())
lst = []
for _ in range(N):
    s, e = map(int, input().split())
    lst.append((s, e))

lst.sort(key=lambda x: x[0]) # 시작 시간 기준 오름차순 정렬해준다

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
