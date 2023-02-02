# 리그 오브 레게노 (23059번)
"""
  문제:https://www.acmicpc.net/problem/23059
  위상정렬, 해시맵
  문제에서 주어진 조건을 잘 읽어야 풀 수 있다.
  1. 현재 구매할 수 있는 아이템 중 아직 구매하지 않은 아이템을 찾는다
  2. 찾은 아이템을 '사전 순'으로 모두 구매한다
  3. 모든 아이템을 구매할 수 없다면 -1을 출력한다
  1번 규칙은 단순히 큐에서 뽑는 것이 아니라 현재 큐의 크기만큼 반복한다는 의도를 갖고 있다.
  2번 규칙은 큐에 요소를 넣기 전에 잠깐 모아뒀다가 정렬해야함을 의미한다.
  3번 결과가 빈 리스트이거나 n개의 아이템을 모두 담고 있지 않으면(길이가 n이 아니면), -1을 출력해야한다.
"""
import sys
from collections import deque

input = sys.stdin.readline

N = int(input().rstrip())
s = set()
tmp = []
for _ in range(N):
    A, B = input().rstrip().split()
    tmp.append((A, B))
    s.add(A)
    s.add(B)

n = 0
item_dict = dict()
no_dict = dict()
lst = sorted(list(s))  # 사전순으로 정렬함
for item in lst:
    item_dict[item] = n  # 아이템:번호
    no_dict[n] = item  # 번호:아이템
    n += 1

graph = [[] for _ in range(n)]
indegree = [0] * n
for a, b in tmp:
    a_n, b_n = item_dict[a], item_dict[b]
    graph[a_n].append(b_n)
    indegree[b_n] += 1

q = deque([])
for i in range(n):
    if not indegree[i]:
        q.append(i)

ret = []
while q:
    size = len(q)
    tmp_q = []  # 사전순으로 아이템을 찾기위한 임시 리스트
    for _ in range(size):  # 현재 큐의 크기만큼 반복
        cur = q.popleft()
        ret.append(no_dict[cur])
        for nxt in graph[cur]:
            indegree[nxt] -= 1
            if not indegree[nxt]:
                tmp_q.append(nxt)
    tmp_q.sort()  # 사전순 탐색을 위한 임시 리스트 정렬
    for nxt_i in tmp_q:
        q.append(nxt_i)

if not ret or len(ret) != n:  # 모든 아이템을 구매할 수 없다면 -1을 출력
    print(-1)
else:
    for item in ret:
        print(item)
