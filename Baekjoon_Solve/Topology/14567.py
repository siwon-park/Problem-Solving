# 선수과목(14567번)
#######################################################
    # 문제: https://www.acmicpc.net/problem/14567
    # 위상정렬
    # BOJ태그에 다이나믹 프로그래밍이라고 적혀있는데, 그렇게 푸는 방법도 있는듯...?
    # 평범한 위상정렬 문제이지만, 출력이 정렬한 결과가 아니라, 각 과목별 이수를 시작하는 학기를 출력해야한다.
    # 따라서 큐에 (학기, 과목 번호)를 넣고 나중에 뽑았을 때, ret[과목번호-1] = sec으로 기록한다.
#######################################################
import sys
from collections import deque
input = sys.stdin.readline

N, M = map(int, input().split())
graph = [[] for _ in range(N+1)]
indegree = [0]*(N+1)

for i in range(M):
    A, B = map(int, input().split())
    indegree[B] += 1
    graph[A].append(B)

def topology_sort():
    ret = [0]*N
    q = deque()
    for i in range(1, N+1):
        if indegree[i] == 0:
            q.append((1, i)) # 학기, 과목 번호
    while q:
        sec, cur = q.popleft()
        ret[cur-1] = sec
        for nxt in graph[cur]:
            indegree[nxt] -= 1
            if indegree[nxt] == 0: # 진입 차수가 0이 되었으니
                q.append((sec+1, nxt)) # 현재 학기 +1, 다음 과목을 큐에 삽입
    return ret

result = topology_sort()
print(*result)
