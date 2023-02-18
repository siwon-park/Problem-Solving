# 거짓말(1043번)
#################################################################################
    # 문제: https://www.acmicpc.net/problem/1043
    # BFS
    # 어떤 사람이 진실을 아는 사람에게서 진실을 들었다면 해당 사람도 이제 진실을 아는 사람이므로
    # 다른 파티에 그 사람이 있으면 그 파티에서 진실을 말하면 안 된다.
    # 따라서 입력으로 주어진 파티 정보를 통해 친구 관계를 만들고
    # 진실을 아는 사람을 큐에 담아서 BFS를 돌려서 진실을 아는 사람의 배열을 만든다.
    # 최대로 거짓말을 할 수 있는 파티의 수(cnt)는 M개로 초기화한다.
    # 그리고 각 파티에 대해서 진실을 아는 사람이 있을 경우 그 파티에서는 거짓말을 해서는 안 되므로, cnt -= 1을 해준다.
#################################################################################
import sys
from collections import deque
input = sys.stdin.readline

N, M = map(int, input().split())

trues = [False] * (N + 1) # 진실을 아는 사람
q = deque()
lst = list(map(int, input().split()))
for i in range(1, lst[0] + 1):
    trues[lst[i]] = True
    q.append(lst[i])

graph = [set() for _ in range(N + 1)] # 각 사람 간 연결 관계(중복을 피하기 위해 집합형으로 선언)
party_people = [[] for _ in range(M + 1)] # 각 파티에 참석한 사람의 번호를 담음
for i in range(1, M + 1):
    arr = list(map(int, input().split()))
    party_people[i] = arr[1:] # i번 파티에 파티에 참석한 사람들의 번호 리스틑 담음
    n = arr[0] # 파티에 참석한 인원 수
    # 연결관계를 설정함
    for j in range(1, n + 1):
        for k in range(j+1, n + 1):
            graph[arr[j]].add(arr[k])
            graph[arr[k]].add(arr[j])

# 진실을 알고있는 사람과 연결된 사람들을 진실을 아는 사람으로 바꿈
while q:
    cur = q.popleft()
    for nxt in graph[cur]:
        if not trues[nxt]:
            q.append(nxt)
            trues[nxt] = True

cnt = M # 거짓말을 칠 수 있는 파티의 수
for i in range(1, M + 1):
    for j in party_people[i]:
        if trues[j]: # 진실을 아는 사람이 파티에 있으면 cnt -= 1후 break
            cnt -= 1
            break

print(cnt)
