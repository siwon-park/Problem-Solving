# 강의실(1374번)
#######################################################################################################
    # 문제: https://www.acmicpc.net/problem/1374
    # 그리디, 최소힙(우선순위큐)
    # 지난 풀었던 회의실 배정과 비슷한 문제이다.
    # 따라서 자세한 풀이는 생략하고 주석을 참조하면 될 것 같다
    # 강의실 번호가 주어지는데 사실상 쓸 곳은 없었다.
#######################################################################################################
import sys, heapq
input = sys.stdin.readline

N = int(input())
lst = []
for _ in range(N):
    no, s, e = map(int, input().split())
    lst.append((no, s, e))

lst.sort(key=lambda x: (x[1], x[2])) # 시작 시간을 기준으로 오름차순 정렬

cnt = 1 # 강의실 개수(디폴트는 1)

pq = []
heapq.heappush(pq, (lst[0][2], lst[0][1])) # 끝나는 시간 기준 최소힙

for i in range(1, N):
    no, s, e = lst[i]
    last_e, last_s = heapq.heappop(pq) # 마지막 강의의 끝난 시간, 마지막 강의의 시작 시간
    if s >= last_e: # 현재 강의의 시작 시간이 마지막 강의의 끝난 시간보다 크거나 같으면 이어서 할 수 있음
        heapq.heappush(pq, (e, s))
    else: # 그렇지 않으면 원래 것도 최소힙에 추가함
        heapq.heappush(pq, (last_e, last_s))
        heapq.heappush(pq, (e, s))
        cnt += 1 # 강의실 개수를 하나 추가

print(cnt)
