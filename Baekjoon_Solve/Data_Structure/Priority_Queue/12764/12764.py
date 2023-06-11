# 싸지방에 간 준하 (12764번)
import sys, heapq
input = sys.stdin.readline

N = int(input().rstrip()) # 사람 수
lst = []
for _ in range(N):
    s, e = map(int, input().rstrip().split())
    lst.append((s, e))

lst.sort(key=lambda x: x[0]) # 시작 시간이 빠른 순으로 정렬
use = [0 for _ in range(N)] # 컴퓨터에 대한 사용 빈도 수 -> 최악의 경우 N개
pq = [] # 끝나는 시간이 우선 순위를 가지는 우선 순위 큐
min_cpu = 0 # 컴퓨터의 최소 개수
cpu_pq = []
size = 0
for i in range(N):
    s, e = lst[i]
    cur = s # 현재 시간
    if not pq: # 우선 순위 큐가 비어 있으면 -> 아무도 컴퓨터를 사용하고 있지 않음 -> 1번 컴퓨터 사용 가능
        heapq.heappush(pq, (e, s, 0)) # 1번 컴퓨터에 삽입
        size += 1
    else: # 우선 순위 큐가 비어있지 않으면
        while pq: # 큐의 맨 위에 있는 요소를 확인
            last_e, last_s, cpu_no = heapq.heappop(pq)
            if cur < last_e: # 현재 시간이 끝나는 시간보다 작으면
                heapq.heappush(pq, (last_e, last_s, cpu_no)) # 원래 요소를 다시 집어 넣고
                break
            else:
                use[cpu_no] += 1
                heapq.heappush(cpu_pq, cpu_no)
                size -= 1
        # 현재 요소를 집어 넣음 -> 사용이 끝난 CPU가 있으면 사용하고 아니면 큐의 크기를 삽입
        if cpu_pq:
            heapq.heappush(pq, (e, s, heapq.heappop(cpu_pq)))
        else:
            heapq.heappush(pq, (e, s, size))
        size += 1
        min_cpu = max(min_cpu, size)

# 우선 순위 큐에 남아 있는 요소 처리
while pq:
    s, e, cpu_no = heapq.heappop(pq)
    use[cpu_no] += 1

ret = []
i = 0
while i < N and use[i] > 0:
    ret.append(use[i])
    i += 1

print(min_cpu)
print(*ret)