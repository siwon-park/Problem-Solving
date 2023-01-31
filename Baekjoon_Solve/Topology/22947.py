# 실행 시간 (22947번)
"""
  문제: https://www.acmicpc.net/problem/22947
  브루트포스, 위상정렬
  문제를 잘못 읽는 바람에 맞왜틀을 했다.
  시작 작업과 마무리 작업을 제외한 min(N - 2, K)개의 작업 시간을 강제로 0으로 만들어야하는데,
  모든 작업 중에서 K개의 작업들의 조합에 대해서 시간을 강제로 0으로 만들고 있었다.
  마지막 작업은 역진입 차수 배열을 통해서 찾고(역진입 차수 배열에서 진입 차수가 0인 노드가 마지막 작업임)
  2부터 N까지 역진입 차수 배열에서 0이 아닌 노드들을 조합을 만들 배열에 담아서 K개의 조합을 구성한다.
  나머지 부분은 위상 정렬을 통해서 모든 작업을 완료할 수 있는 가장 작은 시간을 찾는다.
"""
import sys
from collections import deque
from itertools import combinations
input = sys.stdin.readline

N, M, K = map(int, input().split())  # 작업 개수, 작업 순서 수, 실행 시간이 0인 수
time = [0] + list(map(int, input().split()))  # 실행 시간
graph = [[] for _ in range(N + 1)]
indegree = [0] * (N + 1)  # 진입 차수
reverse_ind = [0] * (N + 1)  # 역진입차수(마지막 작업을 찾기 위함)

for _ in range(M):
    s, e = map(int, input().split())
    graph[s].append(e)
    indegree[e] += 1
    reverse_ind[s] += 1

arr = []
for i in range(2, N + 1):
    if reverse_ind[i]:
        arr.append(i)

combs = list(combinations(arr, K))
min_time = sys.maxsize
for comb in combs:
    tmp_ind = indegree[:]  # 진입 차수 복사
    tmp_t = time[:]  # 실행 시간 복사
    T = [0] * (N + 1)
    T[1] = tmp_t[1]
    for n in comb:
        tmp_t[n] = 0

    q = deque([(T[1], 1)])  # 1은 항상 작업 시작임
    while q:
        cost, cur = q.popleft()
        for nxt in graph[cur]:
            tmp_ind[nxt] -= 1
            T[nxt] = max(cost + tmp_t[nxt], T[nxt])
            if tmp_ind[nxt] == 0:
                q.append((T[nxt], nxt))

    min_time = min(min_time, max(T))

print(min_time)
