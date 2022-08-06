# 연료 채우기(1826번)
######################################################################################
    # 문제: https://www.acmicpc.net/problem/1826
    # 그리디, 우선순위 큐
    # 현재 위치에서 갈 수 있는 위치이면서 그 위치에서 연료를 충전했을 때 가장 멀리 갈 수 있는 곳을 반복적으로 탐색하면서
    # 목적지의 위치 이상으로 갈 수 있는지 탐색하면 된다
    # 문제에 입력이 순서대로 주어진다는 조건이 없었으므로 정렬을 해주었다.
    # 또한 최대 멀리 갈 수 있는 위치를 바로 뽑기 위해 최대 우선순위 큐를 활용하였다
    # 이 로직이 성립할 수 있는 이유는 현재 위치에서 갈 수 있으면서 항상 최대 연료를 충전하여 가장 멀리갈 수 있다면,
    # 멀리 간 그 위치보다 작은 위치는 무조건 갈 수 있기 때문이다(그리디)
######################################################################################
import sys, heapq
sys.setrecursionlimit(int(1e5))
input = sys.stdin.readline

N = int(input())
lst = []
for _ in range(N):
    a, b = map(int, input().split()) # 주유소까지의 거리, 충전 연료량
    lst.append((a, b))

L, P = map(int, input().split()) # 마을까지의 거리, 원래 연료량

def check(lst, L, P):
    if P >= L: # 어느 곳도 방문하지 않고 바로 갈 수 있는 경우
        return 0
    lst.sort(key=lambda x: (x[0], -x[1]))
    pq = []
    i = 0
    cnt = 0
    while P < L:
        while i < N and lst[i][0] <= P: # 다음 위치까지 갈 수 있는지 탐색
            a, b = lst[i]
            heapq.heappush(pq, (-b, a)) # 가장 멀리 갈 수 있는 후보군
            i += 1
        if not pq: # 주유소를 전부 탐색했는데 갈 수 있는 곳이 없으니 -1을 return
            return -1
        b, a = heapq.heappop(pq) # 가장 먼 거리를 갈 수 있는 후보군
        P += -b
        cnt += 1

    return cnt

print(check(lst, L, P))
