# ACM Craft(1005번)
################################################################################################
    # 문제: https://www.acmicpc.net/problem/1005
    # 위상정렬, DP
    # DP로도 풀 수 있다는데 나는 위상정렬로 풀었다. 정말 오랜만에 푸는 위상정렬 문제였다.
    # 너무 오랜만에 풀다보니, 위상정렬인데 시작지점을 어떻게 찾지? 했는데, 곰곰히 생각해보니
    # 그래프 간의 관계를 넣으면서 진입차수를 += 1하고, 1 ~ N까지 순회하여 진입차수가 0인 노드부터 출발하면 됬었다.
    # 그리고 시간 배열을 만들고 맨 처음의 값은 그 건물을 짓는 값으로 초기화하고 큐에서 현재까지 소비한 시간이 나왔을 때
    # 해당 값과 다음 건물을 짓는 시간을 더한 값, T[nxt]에 기록된 누적 값을 비교하여 더 큰 값으로 T[nxt]를 갱신시켜준다.
    # 문제 태그에 DP라고 달려있길래 이 문제 어떻게 DP로 풀지, 탑-다운, 바텀업하기 쉽지 않은데? 했었는데
    # 문제를 잘 보니 W까지의 건설 순서에 따른 최소 시간을 구하는 것이므로, 마지막 도달 지점을 W로 잡고 탑 다운 방식으로 해결하면 된다.
    # 실제로도 빠른 풀이를 보니 탑 다운 방식의 DP이었다.
################################################################################################
import sys
from collections import deque
input = sys.stdin.readline

T = int(input())
for tc in range(T):
    N, K = map(int, input().split())
    D = list(map(int, input().split()))

    graph = [[] for _ in range(N + 1)]
    indegree = [0] * (N + 1)
    for k in range(K):
        X, Y = map(int, input().split()) # X를 짓고나서 Y를 지을 수 있음
        graph[X].append(Y)
        indegree[Y] += 1 # Y를 짓기위해 필요한 선행 건물의 수를 += 1

    W = int(input())

    T = [0] * (N + 1) # 시간을 기록하기 위한 배열
    q = deque([])
    for i in range(1, N + 1):
        T[i] = D[i - 1]
        if indegree[i] == 0: # 진입차수가 0인 것들을 큐에 삽입함
            q.append((i, D[i - 1])) # 현재 건물, 시간

    while q:
        cur, cur_time = q.popleft()
        for nxt in graph[cur]:
            indegree[nxt] -= 1
            T[nxt] = max(cur_time + D[nxt - 1], T[nxt])

            if indegree[nxt] == 0:
                q.append((nxt, T[nxt]))

    print(T[W])
