# 작업(2056번)
#############################################################################################
    # 문제: https://www.acmicpc.net/problem/2056
    # 위상정렬
    # 일반적인 위상 정렬 문제이다.
    # nxt까지의 누적 작업 시간 중 가장 큰 시간을 기록하면 그게 해당 작업까지의 최소 걸리는 시간이다. T[nxt] = max(cost + times[nxt], T[nxt])
    # 왜냐하면 사이클만 아니면, 모든 요소를 indegree가 0이 될 때까지만 방문하기 때문이다.
    # 그리고 최종적으로 max(T)를 구해주면 된다. 큐에서 빠져나왔을 때는 indegree가 모두 0이므로 모든 작업이 끝난 상태이기 때문.
#############################################################################################
import sys
from collections import deque
input = sys.stdin.readline

N = int(input())

indegree = [0] * (N + 1)
graph = [[] for _ in range(N + 1)]
times = [0]
q = deque()

for a in range(1, N + 1):
    lst = list(map(int, input().split()))
    cost = lst[0] # 작업 소모 시간
    m = lst[1] # 선행관계에 있는 작업들의 수
    indegree[a] += m
    times.append(cost)
    if m:
        for i in range(2, m + 2):
            b = lst[i]
            graph[b].append(a)

T = [0] * (N + 1) # 누적 작업 시간 배열

# 진입 차수가 0인 작업들 큐에 삽입
for i in range(1, N + 1):
    T[i] = times[i]
    if not indegree[i]:
        q.append((times[i], i))

while q:
    cost, cur = q.popleft()

    for nxt in graph[cur]:
        indegree[nxt] -= 1
        T[nxt] = max(T[nxt], cost + times[nxt])
        if indegree[nxt] == 0:
            q.append((T[nxt], nxt))

print(max(T))

##########################################################################33
# DP 풀이
import sys
input = sys.stdin.readline

def calc_time(n):
    global time, dp, first
    if dp[n]: return dp[n]

    if not first[n]:
        dp[n] = time[n]
        return dp[n]

    maxx = 0
    while first[n]:
        nn = first[n].pop()
        ret = calc_time(nn)
        if maxx < ret:
            maxx = ret

    dp[n] = time[n] + maxx
    return dp[n]

N = int(input())
dp = [0]*(N+1)
time = [0]*(N+1)
first = [set() for _ in range(N+1)]
for i in range(1, N+1):
    t, n, *arr = map(int, input().split())
    time[i] = t
    first[i] = set(arr)

for i in range(1, N+1):
    dp[i] = calc_time(i)

print(max(dp))
