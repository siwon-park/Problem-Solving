# 국회의원 선거 (1417번)
"""
  문제: https://www.acmicpc.net/problem/1417
  우선순위 큐(최대 우선순위 큐)
  우선순위 큐에서 요소를 뽑아서 매번 다솜이의 현재 표 상태에 + 1씩 더하고
  -1 씩 빼서 우선순위 큐에 삽입한다.
  그리고 마찬가지로 더한 횟수를 기록한다.
  만약 다솜이의 현재 득표 수가 우선순위 큐에서 나온 수보다 크면 최댓값이므로 break하고 출력한다.
"""

import sys, heapq
input = sys.stdin.readline

N = int(input().rstrip())
pq = []
D = int(input().rstrip())

for i in range(N - 1):
    n = int(input().rstrip())
    heapq.heappush(pq, -n)

ans = 0
if not pq:
    print(ans)

while pq:
    n = heapq.heappop(pq)
    n = -n
    if D > n:
        print(ans)
        break
    n -= 1
    D += 1
    ans += 1
    heapq.heappush(pq, -n)
